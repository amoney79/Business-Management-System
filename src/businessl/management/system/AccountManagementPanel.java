package businessl.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountManagementPanel extends JPanel {

    public AccountManagementPanel() {
        setLayout(new BorderLayout());

        JLabel title = new JLabel("Account Management", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 20, 20));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        JButton btnChartOfAccounts = new JButton("Chart of Accounts");
        JButton btnStockManagement = new JButton("Stock Management");
        JButton btnSalesOrders = new JButton("Sales Orders");
        JButton btnLedgerReports = new JButton("Ledger Reports");

        buttonPanel.add(btnChartOfAccounts);
        buttonPanel.add(btnStockManagement);
        buttonPanel.add(btnSalesOrders);
        buttonPanel.add(btnLedgerReports);

        add(buttonPanel, BorderLayout.CENTER);

        // Button Actions
        btnChartOfAccounts.addActionListener(e -> {
            JFrame frame = new JFrame("Chart of Accounts");
            frame.setContentPane(new ChartOfAccountsPanel());
            frame.setSize(800, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

        btnStockManagement.addActionListener(e -> {
            JFrame frame = new JFrame("Stock Management");
            frame.setContentPane(new StockManagementPanel());
            frame.setSize(850, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

        btnSalesOrders.addActionListener(e -> {
            JFrame frame = new JFrame("Sales Orders");
            frame.setContentPane(new SalesOrderPanel());
            frame.setSize(850, 500);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });

        btnLedgerReports.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Ledger Reports");
                frame.setContentPane(new LedgerReportsPanel());
                frame.setSize(850, 500);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
