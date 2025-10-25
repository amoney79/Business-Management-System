package UI.PurchaseSales;

import javax.swing.*;
import java.awt.*;

public class GRNPanel extends JPanel {

    public GRNPanel() {
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.WHITE);

        JLabel title = new JLabel("Goods Receipt Note (GRN)", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        String[] columns = {"GRN ID", "PO ID", "Supplier", "Received Date", "Status"};
        Object[][] data = {
            {"GRN-001", "PO-001", "Global Traders", "2025-10-23", "Verified"},
            {"GRN-002", "PO-002", "TechWorld Ltd.", "2025-10-20", "Pending"}
        };

        JTable table = new JTable(data, columns);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        String[] btns = {"Add", "Edit", "Verify", "Delete"};
        for (String b : btns) buttons.add(new JButton(b));
        add(buttons, BorderLayout.SOUTH);
    }
}
