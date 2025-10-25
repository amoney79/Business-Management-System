package UI.InventoryManagement;

import javax.swing.*;
import java.awt.*;

public class StockValuationPanel extends JPanel {

    public StockValuationPanel() {
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Stock Valuation", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        JTextArea valuationArea = new JTextArea("Total stock value, cost method (FIFO/LIFO/AVG) summary will appear here.");
        valuationArea.setEditable(false);
        add(new JScrollPane(valuationArea), BorderLayout.CENTER);

        JButton calcBtn = new JButton("Calculate Valuation");
        calcBtn.setBackground(new Color(100, 149, 237));
        calcBtn.setForeground(Color.WHITE);
        JPanel bottom = new JPanel();
        bottom.add(calcBtn);
        add(bottom, BorderLayout.SOUTH);
    }
}
