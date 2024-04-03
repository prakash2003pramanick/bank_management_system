package bank_management_system;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Transactions { // This program aims to store the transactions along with the time stamps
    ResultSet getTransactions(String AccountNumber){
        ResultSet resultSet = null;
        
        return resultSet;
    }
    static long addTransaction(String accountNumber, double amount, String type){// This is to make any transactions
    //If the transaction was successfull then this function returns transaction_id else -ve value
        System.out.println("Write the code to fetch the limit from the database in the function addTranscation");
        int limit = Integer.MAX_VALUE; // get the transaction limit form the userDetails 
        //furter implement daily transaction limit etc
        if(amount < limit){
            //add this transcation to the database table - > Tarnsactions
            //request the admin to generate a transaction id
            System.out.println("Write the code to fetch the balance from the database in the function addTranscation");
            double balance = 0;
            //calulations for new balance 
            if( type == "Debit"){
                balance = balance - amount;
            }
            else if(type == "Credit"){
                balance = balance + amount;
            }
            else {
                System.out.println("Write code to handle "+type+" of transcations !!");
            }
            
            String query = "INSERT INTO Transactions (date, time, accountnumber, type, amount, balance) VALUES (CURDATE(), CURTIME(), '"+accountNumber+"', '"+type+"',"+amount+", "+balance+");";
            try {
                Conn c = new Conn();
                c.s.execute(query);
                System.out.println("The transaction table has been updated successfull");
            } catch (SQLException e) {
                System.out.println(e);
            }
            
            //update the new balance
            updateBalance(accountNumber, balance);
            return Admin.allotTransactionId();
        }else {
            //generate an dialog message 
            JOptionPane.showMessageDialog(null, "Transaction limit has reached");

        }
        return -1;
    }
    static void updateBalance(String accountNumber, double balance){
        //write the code to update the balance 
        System.out.println("Write the code to update the balance inside the function updateBalance");
    }
    public static void main(String[] args) {
        System.out.println("This is a trial program");
        addTransaction("1234", 50, "Debit");
    }
}
