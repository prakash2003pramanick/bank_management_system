//package bank;
//import java.sql.*;
//import com.mysql.cj.jdbc.Driver;
//
//
//
//public class Conn {
////main method is not required 
//	//register the driver
//	//create connection
//	//create statement
//	//execute querry
//	//close connection
//	Connection c;
//	Statement s;
//	public Conn() {
//		//mysql is an external entity therefore it may give runtime errror so we need to use try catch 
//		try {
//			Class.forName(com.mysql.cj.jdbc.Driver);
////			c=DriverManager.getConnection("jdbc:mysql://localhost:3306");
////			c=DriverManager.getConnection("jdbc:mysql:///bank","prakash","prakash");
//			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "prakash", "prakash");
//
//			s=c.createStatement();
//			
//		} catch (Exception e) {
//		    e.printStackTrace();
//		}
//
//	}
//	
//}
package bank;

import java.sql.*; // Correct import statement

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        // MySQL is an external entity, so we need to use try-catch
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "prakash", "prakash");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
