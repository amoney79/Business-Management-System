/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessl.management.system;

/**
 *
 * @author macke
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame {

    JPanel contentPanel;

    public Dashboard() {
        setTitle("Business Management System");
        setSize(1100, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // === Side Panel ===
        JPanel sidePanel = new JPanel(new GridLayout(0, 1, 10, 10));
        sidePanel.setPreferredSize(new Dimension(250, 600));
        sidePanel.setBackground(new Color(40, 40, 70));
        sidePanel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));

        String[] modules = {
            "Account Management", "Inventory Management",
            "Purchase & Sales", "Internet Features", "Business Reports", "Employees Management"
        };

        for (String module : modules) {
            JButton btn = new JButton(module);
            btn.setFocusPainted(false);
            btn.setFont(new Font("Arial", Font.BOLD, 14));
            btn.setBackground(Color.LIGHT_GRAY);
            sidePanel.add(btn);

            btn.addActionListener(e -> switchModule(module));
        }

        // === Content Panel (Dynamic) ===
        contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(new JLabel("Welcome to Business Management System", SwingConstants.CENTER), BorderLayout.CENTER);

        // === Layout ===
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(sidePanel, BorderLayout.WEST);
        getContentPane().add(contentPanel, BorderLayout.CENTER);
    }

    private void switchModule(String module) {
        contentPanel.removeAll();

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
            case "Internet Features":
                contentPanel.add(new InternetFeaturesPanel(), BorderLayout.CENTER);
                break;
            case "Business Reports":
                contentPanel.add(new ReportsPanel(), BorderLayout.CENTER);
                break;
            case "Employees Management":
                contentPanel.add(new EmployeesManagementPanel(), BorderLayout.CENTER);
            default:
                contentPanel.add(new JLabel("Module not found", SwingConstants.CENTER));
        }

        contentPanel.revalidate();
        contentPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Dashboard().setVisible(true));
    }
}
