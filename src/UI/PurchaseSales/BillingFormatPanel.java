package UI.PurchaseSales;

import javax.swing.*;
import java.awt.*;

public class BillingFormatPanel extends JPanel {

    public BillingFormatPanel() {
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.WHITE);

        JLabel title = new JLabel("Billing Formats", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        String[] columns = {"Format ID", "Name", "Type", "Default", "Status"};
        Object[][] data = {
            {"BF-001", "Retail Invoice", "Sales", "Yes", "Active"},
            {"BF-002", "Purchase Bill", "Purchase", "No", "Active"}
        };

        JTable table = new JTable(data, columns);
        JScrollPane scroll = new JScrollPane(table);
        add(scroll, BorderLayout.CENTER);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        String[] btns = {"Add", "Edit", "Delete", "Preview"};
        for (String b : btns) buttons.add(new JButton(b));
        add(buttons, BorderLayout.SOUTH);
    }
}
