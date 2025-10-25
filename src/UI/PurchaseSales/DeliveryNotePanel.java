package UI.PurchaseSales;

import javax.swing.*;
import java.awt.*;

public class DeliveryNotePanel extends JPanel {

    public DeliveryNotePanel() {
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.WHITE);

        JLabel title = new JLabel("Delivery Note (DC)", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        String[] columns = {"DC ID", "Sales Order", "Customer", "Delivery Date", "Status"};
        Object[][] data = {
            {"DC-001", "SO-001", "Acme Ltd.", "2025-10-24", "Delivered"},
            {"DC-002", "SO-002", "Beta Corp", "2025-10-22", "Pending"}
        };

        JTable table = new JTable(data, columns);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        String[] btns = {"Add", "Edit", "Print", "Delete"};
        for (String b : btns) buttons.add(new JButton(b));
        add(buttons, BorderLayout.SOUTH);
    }
}
