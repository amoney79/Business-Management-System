package UI.InventoryManagement;

import javax.swing.*;
import java.awt.*;

public class ExpiryPanel extends JPanel {

    public ExpiryPanel() {
        setLayout(new BorderLayout());
        JLabel title = new JLabel("Manufacture & Expiry Dates", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridLayout(0, 2, 10, 10));
        form.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));

        form.add(new JLabel("Product:"));
        form.add(new JTextField(15));

        form.add(new JLabel("Manufacture Date:"));
        JSpinner mfgDate = new JSpinner(new SpinnerDateModel());
        mfgDate.setEditor(new JSpinner.DateEditor(mfgDate, "yyyy-MM-dd"));
        form.add(mfgDate);

        form.add(new JLabel("Expiry Date:"));
        JSpinner expDate = new JSpinner(new SpinnerDateModel());
        expDate.setEditor(new JSpinner.DateEditor(expDate, "yyyy-MM-dd"));
        form.add(expDate);

        JButton save = new JButton("Save Dates");
        save.setBackground(new Color(46, 204, 113));
        save.setForeground(Color.WHITE);

        JPanel bottom = new JPanel();
        bottom.add(save);

        add(form, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
    }
}
