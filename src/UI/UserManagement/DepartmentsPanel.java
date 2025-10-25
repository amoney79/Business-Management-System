package UI.UserManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Departments & Designations management (UI-only)
 */
public class DepartmentsPanel extends JPanel {
    private DefaultTableModel deptModel;
    private JTextField deptField, designationField;

    public DepartmentsPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JLabel title = new JLabel("Departments & Designations", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 16));
        add(title, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridLayout(3,2,8,8));
        form.setBorder(BorderFactory.createTitledBorder("Add Department / Designation"));

        deptField = new JTextField();
        designationField = new JTextField();
        JButton addDeptBtn = new JButton("Add");

        form.add(new JLabel("Department:"));
        form.add(deptField);
        form.add(new JLabel("Designation:"));
        form.add(designationField);
        form.add(new JLabel());
        form.add(addDeptBtn);

        add(form, BorderLayout.WEST);

        String[] cols = {"Department", "Designation"};
        deptModel = new DefaultTableModel(cols, 0);
        JTable table = new JTable(deptModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        addDeptBtn.addActionListener(e -> {
            String d = deptField.getText().trim();
            String des = designationField.getText().trim();
            if (d.isEmpty() || des.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Fill both fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            deptModel.addRow(new Object[]{d, des});
            deptField.setText(""); designationField.setText("");
        });
    }
}
