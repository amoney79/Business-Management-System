package UI.PurchaseSales;

import javax.swing.*;
import java.awt.*;

public class PurchaseOrderPanel extends JPanel {

    public PurchaseOrderPanel() {
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.WHITE);

        JLabel title = new JLabel("Purchase Orders", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        String[] columns = {"PO ID", "Supplier", "Date", "Status", "Total"};
        Object[][] data = {
            {"PO-001", "Global Traders", "2025-10-21", "Approved", "$3200"},
            {"PO-002", "TechWorld Ltd.", "2025-10-19", "Pending", "$4500"}
        };

        JTable table = new JTable(data, columns);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        String[] btns = {"Add", "Edit", "Delete", "Approve", "Export"};
        for (String b : btns) buttons.add(new JButton(b));
        add(buttons, BorderLayout.SOUTH);
    }
}
