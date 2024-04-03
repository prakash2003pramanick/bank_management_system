package bank_management_system;

import java.sql.SQLException;

public class CreateTablesDepedencies {
	private String queryString;
	public CreateTablesDepedencies() {
		Conn c = new Conn();
		//queryString = "create table constants(varname varchar(20),val int(10));";
		//queryString = "create table netbanking (formno varchar(20),accountnumber varchar(10), debitcardnumber varchar(12), creditcardnumber varchar(12), user_pin int(4), IntPass varchar(12));";
		//queryString = "drop table constants1";
		//queryString = "CREATE TABLE Employee (EmployeeID VARCHAR(10) PRIMARY KEY, FirstName VARCHAR(50), LastName VARCHAR(50), DateOfBirth DATE, Gender CHAR(1), Address VARCHAR(255), ContactNumber VARCHAR(15), Email VARCHAR(255), DateHired DATE, Position VARCHAR(100), Department VARCHAR(100), SupervisorID INT, Salary DECIMAL(10,2), LoginId VARCHAR(10), Pass VARCHAR(8));";
		// queryString = "CREATE TABLE Transactions ( transaction_id INT AUTO_INCREMENT PRIMARY KEY, date DATE, time TIME, accountnumber VARCHAR(10), type VARCHAR(10), amount FLOAT, balance FLOAT);";

		
		try {
			c.s.execute(queryString);
			System.out.println("Table is created");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String args[]) {
		new CreateTablesDepedencies();
	}

}
