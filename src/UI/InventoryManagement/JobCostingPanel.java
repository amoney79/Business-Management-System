package UI.InventoryManagement;

import javax.swing.*;
import java.awt.*;

public class JobCostingPanel extends JPanel {

    public JobCostingPanel() {
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Job Costing", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        JTextArea area = new JTextArea("Track and analyze job cost details here...");
        area.setEditable(false);
        add(new JScrollPane(area), BorderLayout.CENTER);

        JPanel bottom = new JPanel(new FlowLayout());
        bottom.add(new JButton("Add Job"));
        bottom.add(new JButton("Edit Job"));
        add(bottom, BorderLayout.SOUTH);
    }
}
