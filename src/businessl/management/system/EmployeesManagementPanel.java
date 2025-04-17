/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessl.management.system;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


   
/**
 *
 * @author macke
 */
import javax.swing.*;
import java.awt.*;

public class EmployeesManagementPanel extends JPanel {

    public EmployeesManagementPanel() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Employee Management", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        JPanel options = new JPanel(new GridLayout(0, 2, 15, 15));
        options.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        String[] features = {
            "Manage Employees"
            
        
        };

        for (String feature : features) {
            JButton btn = new JButton(feature);
            options.add(btn);

            btn.addActionListener(e -> {
                JOptionPane.showMessageDialog(this, feature + " feature coming soon!");
                // TODO: Load respective sub-module panel
            });
        }

        add(options, BorderLayout.CENTER);
    }
}

