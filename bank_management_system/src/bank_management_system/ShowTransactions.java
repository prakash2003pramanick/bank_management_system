package bank_management_system;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.util.Vector;

public class ShowTransactions {
    public static void main(String[] args) {
        // Connect to the database
        try {
            // Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "username", "password");
            // Statement statement = connection.createStatement();
            // ResultSet resultSet = statement.executeQuery("SELECT * FROM Transactions");

            Conn c = new Conn();
            ResultSet resultSet = c.s.executeQuery("SELECT * FROM Transactions");

            // Create a Vector to hold the column names
            Vector<String> columnNames = new Vector<>();

            columnNames.add("Transaction ID");
            columnNames.add("Date");
            columnNames.add("Time");
            columnNames.add("Account Number");
            columnNames.add("Type");
            columnNames.add("Amount");
            columnNames.add("Balance");

            // Create a Vector to hold the data
            Vector<Vector<Object>> data = new Vector<>();

            // Iterate through the ResultSet and add each row to the data Vector
            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                row.add(resultSet.getInt("transaction_id"));
                row.add(resultSet.getDate("date"));
                row.add(resultSet.getTime("time"));
                row.add(resultSet.getString("accountnumber"));
                row.add(resultSet.getString("type"));
                row.add(resultSet.getFloat("amount"));
                row.add(resultSet.getFloat("balance"));
                data.add(row);
            }

            // Create a DefaultTableModel with the data and column names
            DefaultTableModel model = new DefaultTableModel(data, columnNames);

            // Create a JTable with the DefaultTableModel
            JTable table = new JTable(model);

            // Create a JScrollPane and add the table to it
            JScrollPane scrollPane = new JScrollPane(table);

            // Display the JScrollPane in a JFrame
            JFrame frame = new JFrame("Transactions");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(scrollPane);
            frame.pack();
            frame.setVisible(true);

            // Close the ResultSet
            resultSet.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
