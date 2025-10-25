package UI.InventoryManagement;

import javax.swing.*;
import java.awt.*;

public class ItemCostTrackingPanel extends JPanel {

    public ItemCostTrackingPanel() {
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Item Cost Tracking", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        JTable table = new JTable(new Object[][]{}, new Object[]{"Item", "Last Cost", "Average Cost", "Current Value"});
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}
