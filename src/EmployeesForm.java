import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class EmployeesForm extends JFrame {

    private JTextField nameField, positionField, emailField, empNumberField, mobileField;
    private DefaultTableModel tableModel;
    private int employeeIdCounter = 1;

    public EmployeesForm() {
        setTitle("Employee Management System");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);

        // ===== LEFT PANEL: Add Employee Form =====
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridBagLayout());
        leftPanel.setBorder(BorderFactory.createTitledBorder("Add New Employee"));

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

        // ===== RIGHT PANEL: Employee Table + Delete Button =====
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBorder(BorderFactory.createTitledBorder("Employee Table"));

        // Table Columns
        String[] columns = {"ID", "Name", "Position", "Email", "Employee Number", "Mobile"};
        tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        // Delete Button
        JButton deleteButton = new JButton("Delete Selected Employee");
        deleteButton.setFocusable(false);
        deleteButton.setBackground(Color.RED);
        deleteButton.setForeground(Color.WHITE);

        deleteButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select an employee to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
            } else {
                int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this employee?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    tableModel.removeRow(selectedRow);
                }
            }
        });

        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(deleteButton);

        rightPanel.add(scrollPane, BorderLayout.CENTER);
        rightPanel.add(bottomPanel, BorderLayout.SOUTH);

        // ===== SPLIT PANE =====
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setDividerLocation(350);
        splitPane.setResizeWeight(0.3);
        splitPane.setOneTouchExpandable(true);

        add(splitPane);

        // ===== Add Button Logic =====
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
                nameField.setText("");
                positionField.setText("");
                emailField.setText("");
                empNumberField.setText("");
                mobileField.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EmployeesForm().setVisible(true);
        });
    }
}
