package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import models.User;

public class Dashboard extends JFrame {

    private JPanel contentPanel;
    private JPanel sidePanel;
    private JPanel menuPanel;
    private JPanel headerPanel;
    private JLabel breadcrumbLabel;
    private JLabel clockLabel;
    private JButton toggleBtn;
    private boolean sidebarExpanded = true;
    private int expandedWidth = 250;
    private int collapsedWidth = 60;

    private JButton activeButton = null;
    private final Color activeColor = new Color(100, 149, 237);
    private final Color normalColor = Color.LIGHT_GRAY;

    private final String[][] modules = {
            {"Account Management", "icons/account.png"},
            {"Inventory Management", "icons/inventory.png"},
            {"Purchase & Sales", "icons/sales.png"},
            {"Business Reports", "icons/report.png"},
            {"Employees Management", "icons/employees.png"},
            {"Internet Features", "icons/internet.png"}
    };

    private final Map<JButton, String> buttonLabels = new HashMap<>();
    private final User currentUser;

    public Dashboard(User user) {
        this.currentUser = user;
        setTitle("Business Management System");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // === HEADER BAR ===
        headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(30, 30, 50));
        headerPanel.setPreferredSize(new Dimension(1200, 50));
        headerPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 15));

        // Left: Breadcrumb
        breadcrumbLabel = new JLabel("Dashboard");
        breadcrumbLabel.setForeground(Color.WHITE);
        breadcrumbLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));

        // Center: Clock
        clockLabel = new JLabel();
        clockLabel.setForeground(Color.LIGHT_GRAY);
        clockLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        clockLabel.setHorizontalAlignment(SwingConstants.CENTER);
        startClock();

        // Right: User Info + Logout
        JPanel userPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        userPanel.setOpaque(false);

        JLabel userLabel = new JLabel("👤 " + user.getUsername() + " (" + user.getRole() + ")");
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setFocusPainted(false);
        logoutBtn.setBackground(new Color(220, 53, 69));
        logoutBtn.setForeground(Color.WHITE);
        logoutBtn.setFont(new Font("Segoe UI", Font.BOLD, 12));
        logoutBtn.addActionListener(e -> logout());

        userPanel.add(userLabel);
        userPanel.add(logoutBtn);

        headerPanel.add(breadcrumbLabel, BorderLayout.WEST);
        headerPanel.add(clockLabel, BorderLayout.CENTER);
        headerPanel.add(userPanel, BorderLayout.EAST);

        // === SIDE PANEL ===
        sidePanel = new JPanel(new BorderLayout());
        sidePanel.setPreferredSize(new Dimension(expandedWidth, 600));
        sidePanel.setBackground(new Color(40, 40, 70));
        sidePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Toggle Button (arrow)
        toggleBtn = new JButton("⮜");
        toggleBtn.setFocusPainted(false);
        toggleBtn.setFont(new Font("Arial", Font.BOLD, 16));
        toggleBtn.setForeground(Color.WHITE);
        toggleBtn.setBackground(new Color(60, 60, 90));
        toggleBtn.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        toggleBtn.addActionListener(new ToggleSidebarListener());
        sidePanel.add(toggleBtn, BorderLayout.NORTH);

        // Sidebar buttons
        menuPanel = new JPanel(new GridLayout(0, 1, 10, 10));
        menuPanel.setOpaque(false);

        for (String[] moduleData : modules) {
            String moduleName = moduleData[0];
            String iconPath = moduleData[1];

            JButton btn = new JButton(moduleName, loadIcon(iconPath, 24, 24));
            btn.setFocusPainted(false);
            btn.setFont(new Font("Arial", Font.BOLD, 14));
            btn.setBackground(normalColor);
            btn.setHorizontalAlignment(SwingConstants.LEFT);
            btn.setForeground(new Color(30, 30, 30));
            btn.setToolTipText(moduleName);

            btn.addActionListener(e -> {
                switchModule(moduleName);
                setActiveButton(btn);
            });

            menuPanel.add(btn);
            buttonLabels.put(btn, moduleName);
        }

        sidePanel.add(menuPanel, BorderLayout.CENTER);

        // === CONTENT PANEL WITH LOGO + WELCOME TEXT ===
        contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setOpaque(false);
        centerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Load logo (place it in src/icons/logo.png)
        ImageIcon logoIcon = loadIcon("icons/Business Logo.png", 150, 150);
        JLabel logoLabel = new JLabel(logoIcon);
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel welcomeLabel = new JLabel("Welcome to Business Management System", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel taglineLabel = new JLabel("Empowering Business Intelligence", SwingConstants.CENTER);
        taglineLabel.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        taglineLabel.setForeground(Color.DARK_GRAY);
        taglineLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(logoLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        centerPanel.add(welcomeLabel);
        centerPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        centerPanel.add(taglineLabel);
        centerPanel.add(Box.createVerticalGlue());

        contentPanel.add(centerPanel, BorderLayout.CENTER);

        // === ADD COMPONENTS ===
        add(headerPanel, BorderLayout.NORTH);
        add(sidePanel, BorderLayout.WEST);
        add(contentPanel, BorderLayout.CENTER);
    }

    // fallback constructor for testing
    public Dashboard() {
        this(new User("admin", "Administrator"));
    }

    private void switchModule(String module) {
        contentPanel.removeAll();

        // update breadcrumb
        breadcrumbLabel.setText("Dashboard > " + module);

        switch (module) {
            case "Account Management":
                contentPanel.add(new AccountManagementPanel(), BorderLayout.CENTER);
                break;
            case "Inventory Management":
                contentPanel.add(new InventoryManagementPanel(), BorderLayout.CENTER);
                break;
            case "Purchase & Sales":
                contentPanel.add(new PurchaseSalesPanel(), BorderLayout.CENTER);
                break;
            case "Business Reports":
                contentPanel.add(new ReportsPanel(), BorderLayout.CENTER);
                break;
            case "Employees Management":
                contentPanel.add(new UserManagementPanel(), BorderLayout.CENTER);
                break;
            case "Internet Features":
                contentPanel.add(new InternetFeaturesPanel(), BorderLayout.CENTER);
                break;
            default:
                contentPanel.add(new JLabel("Feature Coming Soon", SwingConstants.CENTER),BorderLayout.CENTER);
        }

        contentPanel.revalidate();
        contentPanel.repaint();
    }

    // highlight active button
    private void setActiveButton(JButton btn) {
        if (activeButton != null) {
            activeButton.setBackground(normalColor);
            activeButton.setForeground(new Color(30, 30, 30));
        }

        activeButton = btn;
        btn.setBackground(activeColor);
        btn.setForeground(Color.WHITE);
    }

    // logout logic
    private void logout() {
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?",
                "Logout", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            dispose();
            new UI.LoginManagementSystem().setVisible(true);
        }
    }

    // live clock
    private void startClock() {
        Timer timer = new Timer(1000, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM dd yyyy  |  hh:mm:ss a");
            clockLabel.setText(LocalDateTime.now().format(formatter));
        });
        timer.start();
    }

    // sidebar toggle handler
    private class ToggleSidebarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            sidebarExpanded = !sidebarExpanded;
            toggleBtn.setText(sidebarExpanded ? "⮜" : "⮞");

            int targetWidth = sidebarExpanded ? expandedWidth : collapsedWidth;

            Timer timer = new Timer(5, null);
            timer.addActionListener(new ActionListener() {
                int currentWidth = sidePanel.getWidth();
                int step = sidebarExpanded ? 10 : -10;

                @Override
                public void actionPerformed(ActionEvent ev) {
                    currentWidth += step;
                    if ((step > 0 && currentWidth >= targetWidth) || (step < 0 && currentWidth <= targetWidth)) {
                        currentWidth = targetWidth;
                        timer.stop();
                    }
                    sidePanel.setPreferredSize(new Dimension(currentWidth, 600));
                    sidePanel.revalidate();
                }
            });
            timer.start();

            for (JButton btn : buttonLabels.keySet()) {
                if (sidebarExpanded) {
                    btn.setText(buttonLabels.get(btn));
                    btn.setHorizontalAlignment(SwingConstants.LEFT);
                } else {
                    btn.setText("");
                    btn.setHorizontalAlignment(SwingConstants.CENTER);
                }
            }
        }
    }

    // load scaled icon
    private ImageIcon loadIcon(String path, int width, int height) {
        try {
            ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource(path));
            Image image = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(image);
        } catch (Exception e) {
            return new ImageIcon(new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Dashboard().setVisible(true));
    }
}
