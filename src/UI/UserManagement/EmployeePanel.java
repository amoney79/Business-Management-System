package UI.UserManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Employee Management Panel (CRUD) - UI only
 */
public class EmployeePanel extends JPanel {

    private JTextField nameField, positionField, emailField, empNumberField, mobileField;
    private DefaultTableModel tableModel;
    private int employeeIdCounter = 1;
    private JTable employeeTable;

    public EmployeePanel() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ===== LEFT PANEL: Add Employee Form =====
        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBorder(BorderFactory.createTitledBorder("Add / Edit Employee"));
        leftPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel nameLabel = new JLabel("Name:");
        JLabel positionLabel = new JLabel("Position:");
        JLabel emailLabel = new JLabel("Email:");
        JLabel empNumberLabel = new JLabel("Employee Number:");
        JLabel mobileLabel = new JLabel("Mobile:");

        nameField = new JTextField(15);
        positionField = new JTextField(15);
        emailField = new JTextField(15);
        empNumberField = new JTextField(15);
        mobileField = new JTextField(15);

        JButton addButton = new JButton("Add Employee");
        addButton.setBackground(new Color(46, 204, 113));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);

        JButton updateButton = new JButton("Update Selected");
        JButton clearButton = new JButton("Clear");

        gbc.gridx = 0; gbc.gridy = 0; leftPanel.add(nameLabel, gbc);
        gbc.gridx = 1; leftPanel.add(nameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1; leftPanel.add(positionLabel, gbc);
        gbc.gridx = 1; leftPanel.add(positionField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; leftPanel.add(emailLabel, gbc);
        gbc.gridx = 1; leftPanel.add(emailField, gbc);

        gbc.gridx = 0; gbc.gridy = 3; leftPanel.add(empNumberLabel, gbc);
        gbc.gridx = 1; leftPanel.add(empNumberField, gbc);

        gbc.gridx = 0; gbc.gridy = 4; leftPanel.add(mobileLabel, gbc);
        gbc.gridx = 1; leftPanel.add(mobileField, gbc);

        gbc.gridx = 1; gbc.gridy = 5; leftPanel.add(addButton, gbc);
        gbc.gridx = 1; gbc.gridy = 6; leftPanel.add(updateButton, gbc);
        gbc.gridx = 1; gbc.gridy = 7; leftPanel.add(clearButton, gbc);

        // ===== RIGHT PANEL: Employee Table =====
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBorder(BorderFactory.createTitledBorder("Employee Table"));
        rightPanel.setBackground(Color.WHITE);

        String[] columns = {"ID", "Name", "Position", "Email", "Employee Number", "Mobile"};
        tableModel = new DefaultTableModel(columns, 0);
        employeeTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(employeeTable);

        // Delete button
        JButton deleteButton = new JButton("Delete Selected");
        deleteButton.setBackground(new Color(231, 76, 60));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFocusPainted(false);

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.add(deleteButton);

        rightPanel.add(scrollPane, BorderLayout.CENTER);
        rightPanel.add(bottomPanel, BorderLayout.SOUTH);

        // ===== SPLIT PANE =====
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setDividerLocation(350);
        splitPane.setResizeWeight(0.3);
        splitPane.setOneTouchExpandable(true);
        add(splitPane, BorderLayout.CENTER);

        // Add Button Logic
        addButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String position = positionField.getText().trim();
            String email = emailField.getText().trim();
            String empNumber = empNumberField.getText().trim();
            String mobile = mobileField.getText().trim();

            if (name.isEmpty() || position.isEmpty() || email.isEmpty() || empNumber.isEmpty() || mobile.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                tableModel.addRow(new Object[]{
                        employeeIdCounter++, name, position, email, empNumber, mobile
                });
                clearForm();
            }
        });

        // Update Selected
        updateButton.addActionListener(e -> {
            int sel = employeeTable.getSelectedRow();
            if (sel == -1) {
                JOptionPane.showMessageDialog(this, "Select a row to update.", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            tableModel.setValueAt(nameField.getText().trim(), sel, 1);
            tableModel.setValueAt(positionField.getText().trim(), sel, 2);
            tableModel.setValueAt(emailField.getText().trim(), sel, 3);
            tableModel.setValueAt(empNumberField.getText().trim(), sel, 4);
            tableModel.setValueAt(mobileField.getText().trim(), sel, 5);
            clearForm();
        });

        // Clear form
        clearButton.addActionListener(e -> clearForm());

        // Delete Button Logic
        deleteButton.addActionListener(e -> {
            int selectedRow = employeeTable.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select an employee to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this employee?",
                        "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    tableModel.removeRow(selectedRow);
                }
            }
        });

        // Clicking table row fills form for editing
        employeeTable.getSelectionModel().addListSelectionListener(e -> {
            int sel = employeeTable.getSelectedRow();
            if (sel != -1) {
                nameField.setText((String) tableModel.getValueAt(sel, 1));
                positionField.setText((String) tableModel.getValueAt(sel, 2));
                emailField.setText((String) tableModel.getValueAt(sel, 3));
                empNumberField.setText((String) tableModel.getValueAt(sel, 4));
                mobileField.setText((String) tableModel.getValueAt(sel, 5));
            }
        });
    }

    private void clearForm() {
        nameField.setText("");
        positionField.setText("");
        emailField.setText("");
        empNumberField.setText("");
        mobileField.setText("");
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
}
