/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helpers;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Meghan
 */
public class AuctionHelper {
    
    
    static String JDBC_URL = "jdbc:mysql://localhost/auction";
	
	/**
	 * Attempt to connect to JDBC_URL
	 */
	public static void main(String[] args){
		try{
                        
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(JDBC_URL, "root", "mysql");
			System.out.println("Connected to auction database");
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
                
                
                //listItems = conn.prepareStatement("select * from items");

        }
        
    
}
