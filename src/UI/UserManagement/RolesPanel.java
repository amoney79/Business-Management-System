package UI.UserManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Role & Permission Assignment - UI-only
 */
public class RolesPanel extends JPanel {
    private DefaultTableModel rolesModel;
    private JTextField roleField;
    private JTextField permissionField;
    private DefaultTableModel assignModel;
    private JTextField assignEmpField;
    private JComboBox<String> roleSelector;

    public RolesPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JLabel title = new JLabel("Roles & Permissions", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 16));
        add(title, BorderLayout.NORTH);

        // Left: create roles
        JPanel left = new JPanel(new GridLayout(3,2,8,8));
        left.setBorder(BorderFactory.createTitledBorder("Create Role / Permission"));
        roleField = new JTextField();
        permissionField = new JTextField();
        JButton createRoleBtn = new JButton("Create Role");
        left.add(new JLabel("Role:")); left.add(roleField);
        left.add(new JLabel("Permission (comma sep):")); left.add(permissionField);
        left.add(new JLabel()); left.add(createRoleBtn);
        add(left, BorderLayout.WEST);

        rolesModel = new DefaultTableModel(new String[]{"Role","Permissions"},0);
        JTable rolesTbl = new JTable(rolesModel);
        add(new JScrollPane(rolesTbl), BorderLayout.CENTER);

        // Bottom: Assign role to employee
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.LEFT));
        assignEmpField = new JTextField(12);
        roleSelector = new JComboBox<>();
        JButton assignBtn = new JButton("Assign Role");
        assignModel = new DefaultTableModel(new String[]{"Employee","Role"},0);
        JTable assignTbl = new JTable(assignModel);
        bottom.add(new JLabel("Employee:")); bottom.add(assignEmpField);
        bottom.add(new JLabel("Role:")); bottom.add(roleSelector);
        bottom.add(assignBtn);
        add(bottom, BorderLayout.SOUTH);
        add(new JScrollPane(assignTbl), BorderLayout.EAST);

        createRoleBtn.addActionListener(e -> {
            String r = roleField.getText().trim();
            String p = permissionField.getText().trim();
            if (r.isEmpty()) { JOptionPane.showMessageDialog(this, "Enter role name.", "Error", JOptionPane.ERROR_MESSAGE); return; }
            rolesModel.addRow(new Object[]{r, p});
            roleSelector.addItem(r);
            roleField.setText(""); permissionField.setText("");
        });

        assignBtn.addActionListener(e -> {
            String emp = assignEmpField.getText().trim();
            String r = (String) roleSelector.getSelectedItem();
            if (emp.isEmpty() || r == null) { JOptionPane.showMessageDialog(this, "Enter employee and select role.", "Error", JOptionPane.ERROR_MESSAGE); return; }
            assignModel.addRow(new Object[]{emp, r});
            assignEmpField.setText("");
        });
    }
}
