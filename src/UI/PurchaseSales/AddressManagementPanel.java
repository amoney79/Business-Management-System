package UI.PurchaseSales;

import javax.swing.*;
import java.awt.*;

public class AddressManagementPanel extends JPanel {

    public AddressManagementPanel() {
        setLayout(new BorderLayout(10, 10));
        setBackground(Color.WHITE);

        JLabel title = new JLabel("Multiple Address Management", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        String[] columns = {"Address ID", "Company Name", "Contact", "City", "Country"};
        Object[][] data = {
            {"AD-001", "Acme Ltd.", "John Doe", "Nairobi", "Kenya"},
            {"AD-002", "Beta Corp", "Jane Smith", "Mombasa", "Kenya"}
        };

        JTable table = new JTable(data, columns);
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        String[] btns = {"Add", "Edit", "Delete"};
        for (String b : btns) buttons.add(new JButton(b));
        add(buttons, BorderLayout.SOUTH);
    }
}
