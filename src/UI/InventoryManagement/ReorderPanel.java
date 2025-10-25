package UI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ReorderPanel extends JPanel {

    public ReorderPanel() {
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Re-order Levels", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        String[] cols = {"Product ID", "Product Name", "Current Qty", "Reorder Level", "Status"};
        JTable table = new JTable(new DefaultTableModel(cols, 0));
        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton refresh = new JButton("Check Levels");
        refresh.setBackground(new Color(255, 165, 0));
        refresh.setForeground(Color.WHITE);
        JPanel bottom = new JPanel();
        bottom.add(refresh);

        add(bottom, BorderLayout.SOUTH);
    }
}
