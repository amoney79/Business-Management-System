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

public class InternetFeaturesPanel extends JPanel {

    public InternetFeaturesPanel() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Internet-Based Capabilities", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        JPanel options = new JPanel(new GridLayout(0, 2, 15, 15));
        options.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        String[] features = {
            "Secure Remote Access", "Email Invoices/Reports",
            "Help & Support", "License/User Management",
            "TallyShop Integration", "Browser Reports"
        };

        for (String feature : features) {
            JButton btn = new JButton(feature);
            options.add(btn);
            btn.addActionListener(e -> JOptionPane.showMessageDialog(this, feature + " feature coming soon!"));
        }

        add(options, BorderLayout.CENTER);
    }
}

