/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class WelcomePage extends JFrame {
    
     private final JPanel contentPanel;

    public WelcomePage() {
        setTitle("Welcome");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setResizable(true);
        
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
        

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        JButton exitButton = new JButton("Exit");
        
        
        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);
        buttonPanel.add(exitButton);

        // Layout setup
        setLayout(new BorderLayout());
        add(contentPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);
       

        // Action Listeners
        loginButton.addActionListener(e -> {
    new  LoginManagementSystem().setVisible(true);

        });

        registerButton.addActionListener(e -> {
        new RegisterPage().setVisible(true);

        });

        exitButton.addActionListener(e -> {
            System.exit(0);
        });
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
        SwingUtilities.invokeLater(() -> {
            new WelcomePage().setVisible(true);
        });
    }
}
