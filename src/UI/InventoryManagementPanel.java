package UI;

import javax.swing.*;
import java.awt.*;
import UI.InventoryManagement.*;

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
            btn.setFont(new Font("Segoe UI", Font.BOLD, 15));
            btn.setFocusPainted(false);
            btn.setBackground(new Color(100, 149, 237));
            btn.setForeground(Color.WHITE);
            options.add(btn);

            btn.addActionListener(e -> openSubPanel(feature));
        }

        add(options, BorderLayout.CENTER);
    }

    private void openSubPanel(String feature) {
        JFrame frame = new JFrame(feature);
        frame.setSize(900, 550);
        frame.setLocationRelativeTo(null);

        switch (feature) {
            case "Stock Groups & Categories":
                frame.setContentPane(new StockGroupsPanel());
                break;
            case "Godowns & Batch Management":
                frame.setContentPane(new GodownsPanel());
                break;
            case "MFG & Expiry Dates":
                frame.setContentPane(new ExpiryPanel());
                break;
            case "Units of Measure":
                frame.setContentPane(new UnitsPanel());
                break;
            case "Job Costing":
                frame.setContentPane(new JobCostingPanel());
                break;
            case "Item Cost Tracking":
                frame.setContentPane(new ItemCostTrackingPanel());
                break;
            case "Re-order Levels":
                frame.setContentPane(new ReorderPanel());
                break;
            case "Stock Valuation":
                frame.setContentPane(new StockValuationPanel());
                break;
            default:
                frame.setContentPane(new JPanel(new BorderLayout()) {{
                    add(new JLabel("Feature Coming Soon", SwingConstants.CENTER), BorderLayout.CENTER);
                }});
        }

        frame.setVisible(true);
    }
}
