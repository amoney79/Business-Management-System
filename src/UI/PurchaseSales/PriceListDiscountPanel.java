package UI.PurchaseSales;

import javax.swing.*;
import java.awt.*;

public class PriceListDiscountPanel extends JPanel {

    public PriceListDiscountPanel() {
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.WHITE);

        JLabel title = new JLabel("Price List & Discount Management", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        String[] columns = {"List ID", "Item", "Base Price", "Discount (%)", "Effective Date"};
        Object[][] data = {
            {"PL-001", "Laptop", "$1200", "10%", "2025-10-01"},
            {"PL-002", "Printer", "$200", "5%", "2025-09-15"}
        };

        JTable table = new JTable(data, columns);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        String[] btns = {"Add", "Edit", "Delete", "Apply"};
        for (String b : btns) buttons.add(new JButton(b));
        add(buttons, BorderLayout.SOUTH);
    }
}
