/**
 * Handles database access for the Credit Card project
 * @author Vincent Lee
 * @author Meghan Redwine
 */

package creditcard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Timestamp;

public class CreditDAO {

	/**
	 * Connect to DB and create PreparedStatements
	 */
	public CreditDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Instantiated MySQL driver!");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/csci4300", "root", "mysql");
			System.out.println("Connected to MySQL!");
			
			//Prepared statements used to query database
			addCustomerStatement = conn.prepareStatement("insert into Customer (custName, custAddr, creditLimit, unpaidBalance, imageURL) values(?, ?, ?, ?, ?)");
			listCustomersStatement = conn.prepareStatement("select * from Customer");
			addPurchaseStatement = conn.prepareStatement("insert into Purchase (merchantName, merchantCity, merchantState, purchaseDate, purchaseAmount, custID) values(?, ?, ?, ?, ?, ?)");
			listPurchasesStatement = conn.prepareStatement("select * from Purchase");
			clearCustomersStatement = conn.prepareStatement("delete from Customer");
			clearPurchasesStatement = conn.prepareStatement("delete from Purchase");
		    updateCustomerStatement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		} catch(Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
	
	/** Statement to add a customer to the Customer table */
	PreparedStatement addCustomerStatement;
	/** Statement to list all the customers from the Customer table */
	PreparedStatement listCustomersStatement;
	/** Statement to add a purchase to a customer Purchase table */
	PreparedStatement addPurchaseStatement;
	/** Statement to list all the purchases from the Purchase table */
	PreparedStatement listPurchasesStatement;
	/** Statement to delete all the customers from the Customer table */
	PreparedStatement clearCustomersStatement;
	/** Statement to delete all the purchases from the Purchase table */
	PreparedStatement clearPurchasesStatement;
	/** Statement to update unpaid balance of a Customer table */
	Statement updateCustomerStatement;
	boolean flag = false;
	
	
	/**
	 * @return the flag
	 */
	public boolean isFlag() {
		return flag;
	}

	/** Removes all the customers from the Customer table */
	public void clearCustomers() {
		try {
			clearCustomersStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
	
	/** Removes all the customers from the Customer table */
	public void clearPurchases() {
		try {
			clearPurchasesStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
	
	/**
	 * Adds a new record to the Customer table
	 */
	public void addCustomer(String custName, String custAddr, String imageURL, double creditLimit) {
		try {
			addCustomerStatement.setString(1, custName);
			addCustomerStatement.setString(2, custAddr);
			addCustomerStatement.setDouble(3, creditLimit);
			addCustomerStatement.setDouble(4, 0);
			addCustomerStatement.setString(5, imageURL);
			addCustomerStatement.executeUpdate();
		} catch (Exception e) {
			 System.out.println("Error in addCustomer: " + e.getClass().getName() + ": " + e.getMessage());
		}
	}
	
	/**
	 * Returns a list of all Customers in the Customer table, but without embedded Purchases
	 */
	public ArrayList<CustomerAccount> getCustomerList() {
		ArrayList<CustomerAccount> list = new ArrayList<CustomerAccount>();
		try {
			ResultSet rs = listCustomersStatement.executeQuery();
			while (rs.next()){
				//package the current record as a Customer object and add to list
				list.add(new CustomerAccount(rs.getInt("id"), rs.getString("custName"), rs.getString("custAddr"), rs.getDouble("creditLimit"), rs.getDouble("unpaidBalance"), rs.getString("imageURL")));
			}
		} catch (Exception e) {
			 System.out.println("Error listing customers: " + e.getClass().getName() + ": " + e.getMessage());
		}
		return list;
	}
	
	/**
	 * Returns the Customer with account no 'id', including the list of Purchases
	 */
	public CustomerAccount getCustomer(int id) {
		try {
			ArrayList<Purchase> purchaseList = new ArrayList<Purchase>();
			
			ResultSet rs = listCustomersStatement.executeQuery();
			rs.absolute(id);
			
			ResultSet rs1 = listPurchasesStatement.executeQuery();
			
			//Continues only if there are more items in the result set
			while (rs1.next()) {
				//Checks if purchase matches user ID
				if (rs1.getInt("custID") == rs.getInt("id"))
					purchaseList.add(new Purchase(rs1.getString("merchantName"), rs1.getString("merchantCity"), rs1.getString("merchantState"), rs1.getTimestamp("purchaseDate"), rs1.getDouble("purchaseAmount")));
			}			
			//package the current record as a Customer object and add to list
			return new CustomerAccount(rs.getInt("id"), rs.getString("custName"), rs.getString("custAddr"), rs.getDouble("creditLimit"), rs.getDouble("unpaidBalance"), rs.getString("imageURL"), purchaseList);
		} catch (Exception e) {
			 System.out.println("Error listing customer: " + e.getClass().getName() + ": " + e.getMessage());
		}
		return new CustomerAccount();
	}
	
	/**
	 * Adds a Purchase to 'account' with purchase date the present moment.
	 * If the purchase would put 'account' over its credit limit, does not
	 * add the Purchase but sets the error message of 'account'.
	 */
	public void addPurchase(String merchantName, String merchantCity, String merchantState, double purchaseAmount, int custID) {
		try {
			ResultSet rs = updateCustomerStatement.executeQuery("select * from Customer");
			rs.absolute(custID);
			
			//Checks if customer will go over credit limit
			if (rs.getDouble("creditLimit") >= rs.getDouble("unpaidBalance") + purchaseAmount) {
				rs.updateDouble("unpaidBalance", rs.getDouble("unpaidBalance") + purchaseAmount);
				rs.updateRow();
				
				addPurchaseStatement.setString(1, merchantName);
				addPurchaseStatement.setString(2, merchantCity);
				addPurchaseStatement.setString(3, merchantState);			
				addPurchaseStatement.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
				addPurchaseStatement.setDouble(5, purchaseAmount);
				addPurchaseStatement.setInt(6, rs.getInt("id"));
				addPurchaseStatement.executeUpdate();
				flag = false;
			//Sets "flag" to true if purchase limit is exceeded
			} else {
				System.out.println("PURCHASE NOT ADDED: PURCHASE WILL EXCEED CREDIT LIMIT!");
				flag = true;
			}
		} catch (Exception e) {
			 System.out.println("Error in addPurchase: " + e.getClass().getName() + ": " + e.getMessage());
		}
	}
}
