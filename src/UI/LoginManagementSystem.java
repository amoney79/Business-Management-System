/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import models.User;
import javax.swing.*;
import java.awt.*;

public class LoginManagementSystem extends JFrame {

    private final JTextField usernameField;
    private final JPasswordField passwordField;

    public LoginManagementSystem() {
        setTitle("Login - Sintoil Management System");
        setSize(400, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center window
        setResizable(false);

        // Components
        JLabel titleLabel = new JLabel("Sintoil Business Management System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titleLabel.setForeground(new Color(44, 62, 80));

        JLabel userLabel = new JLabel("Username:");
        JLabel passLabel = new JLabel("Password:");
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        JButton loginBtn = new JButton("Login");

        // Layout setup
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(userLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(usernameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(passLabel, gbc);
        gbc.gridx = 1;
        formPanel.add(passwordField, gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(loginBtn, gbc);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(formPanel, BorderLayout.CENTER);

        add(mainPanel);

        // Action for login
        loginBtn.addActionListener(e -> handleLogin());
    }

    private void handleLogin() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        // Dummy credentials - replace later with DB check
        if ((username.equalsIgnoreCase("admin") && password.equals("1234"))
            || (username.equalsIgnoreCase("accountant") && password.equals("1111"))
            || (username.equalsIgnoreCase("sales") && password.equals("2222"))) {

            JOptionPane.showMessageDialog(this, "Login successful!", "Access Granted", JOptionPane.INFORMATION_MESSAGE);

            // Assign role based on username
            String role;
            if (username.equalsIgnoreCase("admin")) role = "Admin";
            else if (username.equalsIgnoreCase("accountant")) role = "Accountant";
            else role = "Salesperson";

            // Create user and open dashboard
            User loggedInUser = new User(username, role);
            SwingUtilities.invokeLater(() -> new Dashboard(loggedInUser));

            dispose(); // Close login window
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginManagementSystem().setVisible(true);
        });
    }
}
