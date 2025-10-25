/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.AccountManagement;

/**
 *
 * @author macke
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SalesOrderPanel extends JPanel {

    private JTable ordersTable;
    private DefaultTableModel model;
    private JTextField txtCustomerName, txtItem, txtQty, txtOrderDate;

    public SalesOrderPanel() {
        setLayout(new BorderLayout());

        // Title
        JLabel title = new JLabel("Sales Orders", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        // === Center Panel ===
        JPanel centerPanel = new JPanel(new BorderLayout());

        // === Form ===
        JPanel formPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("New Sales Order"));

        txtCustomerName = new JTextField();
        txtItem = new JTextField();
        txtQty = new JTextField();
        txtOrderDate = new JTextField(); // Suggest using a date picker in future

        formPanel.add(new JLabel("Customer Name:"));
        formPanel.add(txtCustomerName);
        formPanel.add(new JLabel("Item:"));
        formPanel.add(txtItem);
        formPanel.add(new JLabel("Quantity:"));
        formPanel.add(txtQty);
        formPanel.add(new JLabel("Order Date (YYYY-MM-DD):"));
        formPanel.add(txtOrderDate);

        JButton btnAdd = new JButton("Add Order");
        formPanel.add(new JLabel());
        formPanel.add(btnAdd);

        // === Orders Table ===
        String[] cols = {"Customer", "Item", "Qty", "Order Date"};
        model = new DefaultTableModel(cols, 0);
        ordersTable = new JTable(model);
        JScrollPane tablePane = new JScrollPane(ordersTable);
        tablePane.setBorder(BorderFactory.createTitledBorder("All Sales Orders"));

        // Layout
        centerPanel.add(formPanel, BorderLayout.WEST);
        centerPanel.add(tablePane, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        // === Button Logic ===
        btnAdd.addActionListener(e -> {
            String cust = txtCustomerName.getText().trim();
            String item = txtItem.getText().trim();
            String qty = txtQty.getText().trim();
            String date = txtOrderDate.getText().trim();

            if (cust.isEmpty() || item.isEmpty() || qty.isEmpty() || date.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields.");
                return;
            }

            model.addRow(new Object[]{cust, item, qty, date});
            clearForm();
        });
    }

    private void clearForm() {
        txtCustomerName.setText("");
        txtItem.setText("");
        txtQty.setText("");
        txtOrderDate.setText("");
    }
}
