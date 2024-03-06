package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Personal extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField nameField;
    private JTextField rollField;
    private JTextArea displayArea;

    public Personal() {
        setTitle("Student Information Form");
        setSize(300, 150); // Adjusted size for a more compact layout
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // Changed layout to BorderLayout for better arrangement

        JPanel inputPanel = new JPanel(new GridLayout(2, 2)); // Panel for input fields
        JLabel nameLabel = new JLabel("Name:");
        inputPanel.add(nameLabel);
        nameField = new JTextField();
        inputPanel.add(nameField);
        JLabel rollLabel = new JLabel("Roll:");
        inputPanel.add(rollLabel);
        rollField = new JTextField();
        inputPanel.add(rollField);
        add(inputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Panel for the submit button
        JButton submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(100, 30)); // Set preferred size for the button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String roll = rollField.getText();
                displayArea.setText("Name: " + name + "\nRoll: " + roll);
            }
        });
        buttonPanel.add(submitButton);
        add(buttonPanel, BorderLayout.CENTER);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea); // Adding scroll bar for text area
        add(scrollPane, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Personal();
            }
        });
    }
}
