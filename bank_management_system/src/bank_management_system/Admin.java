package bank_management_system;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;

import com.mysql.cj.xdevapi.AddResult;

public class Admin extends JFrame{
	static Conn c = new Conn();
	private static final long serialVersionUID = 1L;
	static private long accountNumber = 0;
	static private long debitcardNumber = 0;
	public Admin() {
	}
	public static synchronized long allotAccountNumber() {
		try {
			accountNumber = getNewNumber("accountnumber");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		setNewNumber("accountnumber",accountNumber+1);
		return accountNumber;
		
	}
	public static synchronized long allotDebitNumber() {
		try {
			debitcardNumber = getNewNumber("debitcardnumber");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		setNewNumber("debitcardnumber",debitcardNumber+1);
		return debitcardNumber;
		
	}
	public static synchronized long allotTransactionId() {
		long transaction_id = -1;
		transaction_id =  getNewNumber("transaction_id");
		setNewNumber("transaction_id", transaction_id+1);
		return transaction_id;
	}
	
	private static long getNewNumber(String var){
		String newnumber=null;
		String query = "select val from constants where varname = '"+var+"';";
		ResultSet result;
		try {
			result = c.s.executeQuery(query);
			result.next();
			newnumber = result.getString(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Long.parseLong(newnumber);
	}
	private static void setNewNumber(String var, long newNumber) {
		String query = "update constants set val ="+ newNumber+" where varname = '"+var+"';";
		try {
			c.s.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	// Mehtods to be implemented 
	// 1. addEmployee();
	// 2. deleteEmploye();
	// 3. viewEmployeeDetails();
	// 4. alterEmployeeDetails();	
	final boolean addEmployee(String fields, String attributes){
		//write the code to add an employee to the database
		String query = "insert into employee("+fields+") values("+attributes+");";
		//c.s.execute(query);
		return false;
	}
	final boolean deleteEmployee(){
		//write the code to delete an employee from the database

		return false;
	}
	final boolean viewEmployeeDetails(String employeeNumber){
		//write the code to view the employee details of an employee with the help fo the employee number
		return false;
	}
	final boolean updateEmployeeDetials(String employeeNumber, String query){
		//write the code to update the details of an employee
		return false;
	}
	private static void resetAccountNumber() {
		setNewNumber("accountnumber",1);
	}
	private static void resetDebitcardNumber() {
		setNewNumber("debitcardnumber", 1);
	}
	private static void resetTranscationID() {
		setNewNumber("transaction_id", 1);
	}
	private static void resetAllConstants() {
		resetAccountNumber();
		resetDebitcardNumber();
		resetTranscationID();
	}
	
	public static void main(String []args) {
		// allotAccountNumber();
		// System.out.println(accountNumber);
		// System.out.println(debitcardNumber);
	}

}
