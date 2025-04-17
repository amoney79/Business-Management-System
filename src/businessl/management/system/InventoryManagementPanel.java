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

public class InventoryManagementPanel extends JPanel {

    public InventoryManagementPanel() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Inventory Management", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        JPanel options = new JPanel(new GridLayout(0, 2, 15, 15));
        options.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        String[] features = {
            "Stock Groups & Categories", "Godowns & Batch Management",
            "MFG & Expiry Dates", "Units of Measure",
            "Job Costing", "Item Cost Tracking", 
            "Re-order Levels", "Stock Valuation"
        };

        for (String feature : features) {
            JButton btn = new JButton(feature);
            options.add(btn);
            
            
           btn.addActionListener(e -> {
            JFrame frame = new JFrame("Stock Management");
            frame.setContentPane(new StockManagementPanel());
            frame.setSize(900, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
});

        }

        add(options, BorderLayout.CENTER);
    }
}
