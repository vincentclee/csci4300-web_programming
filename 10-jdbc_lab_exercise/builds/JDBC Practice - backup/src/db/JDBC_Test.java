/**
 * @author Vincent Lee
 * @author Meghan Redwine
 */

package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC_Test {
	
	static String JDBC_URL = "jdbc:mysql://localhost/csci4300";
	
	/**
	 * Attempt to connect to JDBC_URL
	 */
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(JDBC_URL, "root", "mysql");
			System.out.println("Connected to csci4300 database");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}