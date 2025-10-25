package UI.UserManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Basic Payroll UI - calculate simple net pay and show payslip rows.
 */
public class PayrollPanel extends JPanel {
    private DefaultTableModel payrollModel;
    private JTextField empNameField, basicField, allowancesField, deductionsField;

    public PayrollPanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JLabel title = new JLabel("Payroll Management", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 16));
        add(title, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridLayout(5,2,8,8));
        form.setBorder(BorderFactory.createTitledBorder("Generate Payslip"));

        empNameField = new JTextField();
        basicField = new JTextField();
        allowancesField = new JTextField();
        deductionsField = new JTextField();
        JButton genBtn = new JButton("Generate Payslip");

        form.add(new JLabel("Employee Name:")); form.add(empNameField);
        form.add(new JLabel("Basic Salary:")); form.add(basicField);
        form.add(new JLabel("Allowances:")); form.add(allowancesField);
        form.add(new JLabel("Deductions:")); form.add(deductionsField);
        form.add(new JLabel()); form.add(genBtn);

        add(form, BorderLayout.WEST);

        payrollModel = new DefaultTableModel(new String[]{"Employee","Basic","Allowances","Deductions","Net"},0);
        JTable table = new JTable(payrollModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        genBtn.addActionListener(e -> {
            try {
                String name = empNameField.getText().trim();
                double basic = Double.parseDouble(basicField.getText().trim());
                double allow = Double.parseDouble(allowancesField.getText().trim());
                double deduct = Double.parseDouble(deductionsField.getText().trim());
                double net = basic + allow - deduct;
                payrollModel.addRow(new Object[]{name, basic, allow, deduct, net});
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter numeric values for salary fields.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
