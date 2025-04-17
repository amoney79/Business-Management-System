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

public class ChartOfAccountsPanel extends JPanel {

    private JTable accountTable;
    private DefaultTableModel model;
    private JTextField txtAccountName, txtAccountType, txtAccountCode;

    public ChartOfAccountsPanel() {
        setLayout(new BorderLayout());

        // Title
        JLabel title = new JLabel("Chart of Accounts", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        // Center Layout with Input Form + Table
        JPanel centerPanel = new JPanel(new BorderLayout());

        // === Left: Input Form ===
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Add New Account"));

        txtAccountCode = new JTextField();
        txtAccountName = new JTextField();
        txtAccountType = new JTextField();

        formPanel.add(new JLabel("Account Code:"));
        formPanel.add(txtAccountCode);

        formPanel.add(new JLabel("Account Name:"));
        formPanel.add(txtAccountName);

        formPanel.add(new JLabel("Account Type (e.g. Asset, Expense):"));
        formPanel.add(txtAccountType);

        JButton btnAdd = new JButton("Add Account");
        formPanel.add(new JLabel()); // Empty cell
        formPanel.add(btnAdd);

        // === Right: Table View ===
        String[] cols = {"Account Code", "Account Name", "Account Type"};
        model = new DefaultTableModel(cols, 0);
        accountTable = new JTable(model);

        JScrollPane tablePane = new JScrollPane(accountTable);
        tablePane.setBorder(BorderFactory.createTitledBorder("Accounts List"));

        // Add panels to center
        centerPanel.add(formPanel, BorderLayout.WEST);
        centerPanel.add(tablePane, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        // === Button Logic ===
        btnAdd.addActionListener(e -> {
            String code = txtAccountCode.getText().trim();
            String name = txtAccountName.getText().trim();
            String type = txtAccountType.getText().trim();

            if (code.isEmpty() || name.isEmpty() || type.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields.");
                return;
            }

            model.addRow(new Object[]{code, name, type});

            // Clear fields
            txtAccountCode.setText("");
            txtAccountName.setText("");
            txtAccountType.setText("");
        });
    }
}
