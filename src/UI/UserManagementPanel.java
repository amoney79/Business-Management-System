package UI;

import UI.UserManagement.RolesPanel;
import UI.UserManagement.PerformancePanel;
import UI.UserManagement.PayrollPanel;
import UI.UserManagement.LeavePanel;
import UI.UserManagement.EmployeePanel;
import UI.UserManagement.DepartmentsPanel;
import UI.UserManagement.AttendancePanel;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Main User Management container with tabs for all sub-modules.
 */
public class UserManagementPanel extends JPanel {
    private final JTabbedPane tabs;
    private final EmployeePanel employeePanel;
    private final DepartmentsPanel departmentsPanel;
    private final AttendancePanel attendancePanel;
    private final PayrollPanel payrollPanel;
    private final LeavePanel leavePanel;
    private final PerformancePanel performancePanel;
    private final RolesPanel rolesPanel;
    private final ReportsPanel reportsPanel;

    public UserManagementPanel() {
        setLayout(new BorderLayout());
        JLabel title = new JLabel("User & Employee Management", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        // Preload all sub-panels
        employeePanel = new EmployeePanel();
        departmentsPanel = new DepartmentsPanel();
        attendancePanel = new AttendancePanel();
        payrollPanel = new PayrollPanel();
        leavePanel = new LeavePanel();
        performancePanel = new PerformancePanel();
        rolesPanel = new RolesPanel();
        reportsPanel = new ReportsPanel();

        tabs = new JTabbedPane();
        tabs.addTab("Employees", employeePanel);
        tabs.addTab("Departments", departmentsPanel);
        tabs.addTab("Attendance", attendancePanel);
        tabs.addTab("Payroll", payrollPanel);
        tabs.addTab("Leave", leavePanel);
        tabs.addTab("Performance", performancePanel);
        tabs.addTab("Roles", rolesPanel);
        tabs.addTab("Reports", reportsPanel);

        // log tab changes (simple activity log)
        tabs.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                String tabTitle = tabs.getTitleAt(tabs.getSelectedIndex());
                logActivity("Opened User Management tab: " + tabTitle);
            }
        });

        add(tabs, BorderLayout.CENTER);
    }

    private void logActivity(String action) {
        try (FileWriter fw = new FileWriter("activity_log.txt", true)) {
            fw.write(LocalDateTime.now() + " - " + action + System.lineSeparator());
        } catch (IOException ex) {
            // ignore in UI-only mode, but print for debugging

        }
    }

    // small helper so other modules can access employee table model if needed
    public EmployeePanel getEmployeePanel() {
        return employeePanel;
    }
}
