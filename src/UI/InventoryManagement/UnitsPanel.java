package UI.InventoryManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class UnitsPanel extends JPanel {

    public UnitsPanel() {
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Units of Measure", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        String[] cols = {"ID", "Unit Name", "Symbol", "Conversion Factor"};
        JTable table = new JTable(new DefaultTableModel(cols, 0));
        add(new JScrollPane(table), BorderLayout.CENTER);

        JPanel bottom = new JPanel(new FlowLayout());
        bottom.add(new JButton("Add"));
        bottom.add(new JButton("Edit"));
        bottom.add(new JButton("Delete"));
        add(bottom, BorderLayout.SOUTH);
    }
}
