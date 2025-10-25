package UI.UserManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Performance & Appraisal - record appraisals (UI only)
 */
public class PerformancePanel extends JPanel {
    private DefaultTableModel perfModel;
    private JTextField empField;
    private JTextArea notesArea;
    private JComboBox<String> ratingBox;

    public PerformancePanel() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        JLabel title = new JLabel("Performance & Appraisals", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 16));
        add(title, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridLayout(4,2,8,8));
        form.setBorder(BorderFactory.createTitledBorder("Add Appraisal"));

        empField = new JTextField();
        ratingBox = new JComboBox<>(new String[]{"1","2","3","4","5"});
        notesArea = new JTextArea(4,20);
        JButton addBtn = new JButton("Add Appraisal");

        form.add(new JLabel("Employee:")); form.add(empField);
        form.add(new JLabel("Rating (1-5):")); form.add(ratingBox);
        form.add(new JLabel("Notes:")); form.add(new JScrollPane(notesArea));
        form.add(new JLabel()); form.add(addBtn);

        add(form, BorderLayout.WEST);

        perfModel = new DefaultTableModel(new String[]{"Employee","Rating","Notes"},0);
        JTable tbl = new JTable(perfModel);
        add(new JScrollPane(tbl), BorderLayout.CENTER);

        addBtn.addActionListener(e -> {
            String emp = empField.getText().trim();
            String rating = (String) ratingBox.getSelectedItem();
            String notes = notesArea.getText().trim();
            if (emp.isEmpty()) { JOptionPane.showMessageDialog(this, "Enter employee name.", "Error", JOptionPane.ERROR_MESSAGE); return; }
            perfModel.addRow(new Object[]{emp, rating, notes});
            empField.setText(""); notesArea.setText("");
        });
    }
}
