package bank_management_system;
import java.security.PublicKey;
import java.sql.*;
import com.mysql.cj.jdbc.Driver;
public class Conn {

	/*
	 * Register the driver
	 * Create Connection 
	 * Create Statement
	 * Execute Query
	 * Close connection
	 * 
	 * sudo apt install mysql-server
	 * sudo systemctl status mysql
	 * mysql username - sudo mysql -u root -p
	 * prakash123
	 * 
	 * create database banktry; -> this is the temporary name in the file 
	 * show databases; - to see all the databases
	 * 
	 * 
	 * mysql> create table user(formno varchar(7), f_name varchar(10), l_name varchar(10), dob date, gender varchar(7));
	 */
	Connection c;
	Statement s;
	public Conn() {
	    try {
	        //Class.forName("com.mysql.jdbc.Driver");
	        String url = "jdbc:mysql://localhost:3306/banktry";
	        String username = "root";
	        String password = "prakash123";
	        
	        c = DriverManager.getConnection(url,username,password);
	        s = c.createStatement();
	        
	        if (c != null) {	
	            System.out.println("Connection established!");
	            s = c.createStatement();
	        } else {
	            System.out.println("Failed to establish connection!");	
	        }
	    } catch (SQLException e) {
	        System.out.println("Error: Failed to connect to database!");
	        e.printStackTrace();
	    }
	}
}

	
