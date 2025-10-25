package UI.UserManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Leave Management - request and view leaves (UI only)
 */
public class LeavePanel extends JPanel {
    private DefaultTableModel leaveModel;
    private JTextField empField;
    private JComboBox<String> leaveType;
    private JTextField fromField, toField;

    public LeavePanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JLabel title = new JLabel("Leave Management", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 16));
        add(title, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridLayout(5,2,8,8));
        form.setBorder(BorderFactory.createTitledBorder("Request Leave"));
        empField = new JTextField();
        leaveType = new JComboBox<>(new String[]{"Annual", "Sick", "Unpaid"});
        fromField = new JTextField("YYYY-MM-DD");
        toField = new JTextField("YYYY-MM-DD");
        JButton reqBtn = new JButton("Request");

        form.add(new JLabel("Employee:")); form.add(empField);
        form.add(new JLabel("Type:")); form.add(leaveType);
        form.add(new JLabel("From:")); form.add(fromField);
        form.add(new JLabel("To:")); form.add(toField);
        form.add(new JLabel()); form.add(reqBtn);

        add(form, BorderLayout.WEST);

        leaveModel = new DefaultTableModel(new String[]{"Employee","Type","From","To","Status"},0);
        JTable table = new JTable(leaveModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        reqBtn.addActionListener(e -> {
            String emp = empField.getText().trim();
            if (emp.isEmpty()) { JOptionPane.showMessageDialog(this, "Enter employee name.", "Error", JOptionPane.ERROR_MESSAGE); return; }
            leaveModel.addRow(new Object[]{emp, leaveType.getSelectedItem(), fromField.getText(), toField.getText(), "Pending"});
            empField.setText("");
        });
    }
}
