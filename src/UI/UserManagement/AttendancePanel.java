package UI.UserManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Simple Attendance Panel - UI only
 */
public class AttendancePanel extends JPanel {
    private DefaultTableModel attendanceModel;
    private JComboBox<String> employeeSelector;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public AttendancePanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JLabel title = new JLabel("Attendance Management", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 16));
        add(title, BorderLayout.NORTH);

        // Top controls
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        employeeSelector = new JComboBox<>();
        employeeSelector.setEditable(true); // user can type a name when not connected to DB
        JButton clockInBtn = new JButton("Clock In");
        JButton clockOutBtn = new JButton("Clock Out");
        top.add(new JLabel("Employee:"));
        top.add(employeeSelector);
        top.add(clockInBtn);
        top.add(clockOutBtn);
        add(top, BorderLayout.SOUTH);

        // Table
        String[] cols = {"Employee", "Type", "Timestamp"};
        attendanceModel = new DefaultTableModel(cols,0);
        JTable tbl = new JTable(attendanceModel);
        add(new JScrollPane(tbl), BorderLayout.CENTER);

        clockInBtn.addActionListener(e -> addRecord("IN"));
        clockOutBtn.addActionListener(e -> addRecord("OUT"));
    }

    private void addRecord(String type) {
        String emp = ((String) employeeSelector.getSelectedItem());
        if (emp == null || emp.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter/select employee name.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        attendanceModel.addRow(new Object[]{emp, type, LocalDateTime.now().format(dtf)});
    }

    // helper to allow other modules to populate selector (optional)
    public void addEmployeeToSelector(String employeeName) {
        employeeSelector.addItem(employeeName);
    }
}
