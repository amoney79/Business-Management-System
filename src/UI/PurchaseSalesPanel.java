package UI;

import UI.AccountManagement.SalesOrderPanel;
import javax.swing.*;
import java.awt.*;
import UI.PurchaseSales.*;

public class PurchaseSalesPanel extends JPanel {

    public PurchaseSalesPanel() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Purchase & Sales Management", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        JPanel options = new JPanel(new GridLayout(0, 2, 15, 15));
        options.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        String[] features = {
            "Billing Formats", "Price List & Discount Mgmt",
            "Multiple Addresses", "Sales Orders",
            "Purchase Orders", "GRN (Goods Receipt Note)",
            "Delivery Note (DC)"
        };

        for (String feature : features) {
            JButton btn = new JButton(feature);
            btn.setFont(new Font("Segoe UI", Font.BOLD, 15));
            btn.setFocusPainted(false);
            btn.setBackground(new Color(100, 149, 237)); // Cornflower Blue
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
            case "Billing Formats":
                frame.setContentPane(new BillingFormatPanel());
                break;
            case "Price List & Discount Mgmt":
                frame.setContentPane(new PriceListDiscountPanel());
                break;
            case "Multiple Addresses":
                frame.setContentPane(new AddressManagementPanel());
                break;
            case "Sales Orders":
                frame.setContentPane(new SalesOrderPanel());
                break;
            case "Purchase Orders":
                frame.setContentPane(new PurchaseOrderPanel());
                break;
            case "GRN (Goods Receipt Note)":
                frame.setContentPane(new GRNPanel());
                break;
            case "Delivery Note (DC)":
                frame.setContentPane(new DeliveryNotePanel());
                break;
            default:
                frame.setContentPane(new JPanel(new BorderLayout()) {{
                    add(new JLabel("Feature Coming Soon", SwingConstants.CENTER), BorderLayout.CENTER);
                }});
        }

        frame.setVisible(true);
    }
}
