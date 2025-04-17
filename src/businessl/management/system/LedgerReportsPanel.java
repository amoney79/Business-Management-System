/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessl.management.system;

/**
 *
 * @author macke
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LedgerReportsPanel extends JPanel {

    private JTable ledgerTable;
    private DefaultTableModel model;

    public LedgerReportsPanel() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Ledger Reports", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        add(title, BorderLayout.NORTH);

        // Table setup
        String[] columns = {"Date", "Account Name", "Debit", "Credit", "Balance"};
        model = new DefaultTableModel(columns, 0);
        ledgerTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(ledgerTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Ledger Entries"));
        add(scrollPane, BorderLayout.CENTER);

        // Example data (to be replaced with real entries)
        model.addRow(new Object[]{"2025-04-12", "Cash", "1000.00", "", "1000.00"});
        model.addRow(new Object[]{"2025-04-13", "Sales", "", "500.00", "500.00"});
    }
}

