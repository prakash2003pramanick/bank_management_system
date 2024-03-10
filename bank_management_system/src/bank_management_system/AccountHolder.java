package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AccountHolder extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;

    private long accountNumber;

    private JLabel accountNumberLabel;
    private JTextField accountNumberField;
    private JLabel balanceLabel;
    private JTextField balanceField;
    private JButton depositButton;
    private JButton withdrawButton;

    public AccountHolder(long accountNumber) {
        this.accountNumber = accountNumber;

        setTitle("Account Holder");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        accountNumberLabel = new JLabel("Account Number:");
        add(accountNumberLabel);
        accountNumberField = new JTextField(String.valueOf(accountNumber));
        accountNumberField.setEditable(false);
        add(accountNumberField);

        balanceLabel = new JLabel("Balance:");
        add(balanceLabel);
        balanceField = new JTextField();
        balanceField.setEditable(false);
        add(balanceField);

        depositButton = new JButton("Deposit");
        depositButton.addActionListener(this);
        add(depositButton);

        withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(this);
        add(withdrawButton);

        updateBalance(); // Fetch initial balance from the database
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == depositButton) {
            String depositAmount = JOptionPane.showInputDialog(this, "Enter deposit amount:");
            if (depositAmount != null && !depositAmount.isEmpty()) {
                // Perform deposit operation (update balance in the database)
                double deposit = Double.parseDouble(depositAmount);
                // Update balance in the database
                // For now, let's assume balance is updated successfully
                double currentBalance = Double.parseDouble(balanceField.getText());
                currentBalance += deposit;
                balanceField.setText(String.valueOf(currentBalance));
                JOptionPane.showMessageDialog(this, "Deposit successful. New balance: " + currentBalance);
            }
        } else if (e.getSource() == withdrawButton) {
            String withdrawAmount = JOptionPane.showInputDialog(this, "Enter withdrawal amount:");
            if (withdrawAmount != null && !withdrawAmount.isEmpty()) {
                // Perform withdrawal operation (update balance in the database)
                double withdrawal = Double.parseDouble(withdrawAmount);
                // Update balance in the database
                // For now, let's assume balance is updated successfully
                double currentBalance = Double.parseDouble(balanceField.getText());
                if (currentBalance >= withdrawal) {
                    currentBalance -= withdrawal;
                    balanceField.setText(String.valueOf(currentBalance));
                    JOptionPane.showMessageDialog(this, "Withdrawal successful. New balance: " + currentBalance);
                } else {
                    JOptionPane.showMessageDialog(this, "Insufficient balance.");
                }
            }
        }
    }

    private void updateBalance() {
        // Fetch balance from the database based on the account number
        // For now, let's assume balance is fetched successfully
        double balance = 5000.0; // Example balance
        balanceField.setText(String.valueOf(balance));
    }

    public static void main(String[] args) {
        long accountNumber = 123456789; // Example account number
        SwingUtilities.invokeLater(() -> new AccountHolder(accountNumber));
    }
}
