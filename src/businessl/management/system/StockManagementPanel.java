/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessl.management.system;

/**
 *
 * @author macke
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StockManagementPanel extends JPanel {

    private JTable stockTable;
    private DefaultTableModel model;
    private JTextField txtItemName, txtCategory, txtBatchNo, txtMfgDate, txtExpDate;

    public StockManagementPanel() {
        setLayout(new BorderLayout());

        // Title
        JLabel title = new JLabel("Stock Management", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        // === Center Panel ===
        JPanel centerPanel = new JPanel(new BorderLayout());

        // === Left: Input Form ===
        JPanel formPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Add New Stock Item"));

        txtItemName = new JTextField();
        txtCategory = new JTextField();
        txtBatchNo = new JTextField();
        txtMfgDate = new JTextField(); // Suggest date picker later
        txtExpDate = new JTextField();

        formPanel.add(new JLabel("Item Name:"));
        formPanel.add(txtItemName);
        formPanel.add(new JLabel("Category/Group:"));
        formPanel.add(txtCategory);
        formPanel.add(new JLabel("Batch No:"));
        formPanel.add(txtBatchNo);
        formPanel.add(new JLabel("MFG Date (YYYY-MM-DD):"));
        formPanel.add(txtMfgDate);
        formPanel.add(new JLabel("EXP Date (YYYY-MM-DD):"));
        formPanel.add(txtExpDate);

        JButton btnAdd = new JButton("Add Stock Item");
        formPanel.add(new JLabel());
        formPanel.add(btnAdd);

        // === Right: Table ===
        String[] cols = {"Item", "Category", "Batch", "MFG Date", "EXP Date"};
        model = new DefaultTableModel(cols, 0);
        stockTable = new JTable(model);
        JScrollPane tablePane = new JScrollPane(stockTable);
        tablePane.setBorder(BorderFactory.createTitledBorder("Stock Inventory"));

        // Assemble Panels
        centerPanel.add(formPanel, BorderLayout.WEST);
        centerPanel.add(tablePane, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        // === Button Action ===
        btnAdd.addActionListener(e -> {
            String item = txtItemName.getText().trim();
            String cat = txtCategory.getText().trim();
            String batch = txtBatchNo.getText().trim();
            String mfg = txtMfgDate.getText().trim();
            String exp = txtExpDate.getText().trim();

            if (item.isEmpty() || cat.isEmpty() || batch.isEmpty() || mfg.isEmpty() || exp.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields.");
                return;
            }

            model.addRow(new Object[]{item, cat, batch, mfg, exp});
            clearForm();
        });
    }

    private void clearForm() {
        txtItemName.setText("");
        txtCategory.setText("");
        txtBatchNo.setText("");
        txtMfgDate.setText("");
        txtExpDate.setText("");
    }
}
