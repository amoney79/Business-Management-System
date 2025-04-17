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

public class ReportsPanel extends JPanel {

    public ReportsPanel() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Business Reports", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        JPanel options = new JPanel(new GridLayout(0, 2, 15, 15));
        options.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        String[] features = {
            "Ledger Reports", "Cash/Bank Books",
            "Sales/Purchase Registers", "Bills Receivables/Payables",
            "Balance Sheet", "Profit & Loss A/C",
            "Trial Balance", "Ratio Analysis",
            "Stock Summary", "Job Work Reports",
            "Cost Centre/Category", "Budgeting & Projection",
            "Scenario Management", "Comparative Reports"
        };

        for (String feature : features) {
            JButton btn = new JButton(feature);
            options.add(btn);
            btn.addActionListener(e -> JOptionPane.showMessageDialog(this, feature + " feature coming soon!"));
        }

        add(options, BorderLayout.CENTER);
    }
}
