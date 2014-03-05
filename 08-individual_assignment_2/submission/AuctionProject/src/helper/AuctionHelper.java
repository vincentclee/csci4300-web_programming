/**
 * Handles database access for the Auction project
 * @author Vincent Lee
 */

package helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.sql.Timestamp;
import org.apache.commons.codec.digest.DigestUtils;

public class AuctionHelper {
	/**
	 * Connect to DB and create PreparedStatements
	 */
	public AuctionHelper() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("<Instantiated MySQL driver>");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/AuctionProject", "root", "mysql");
			System.out.println("<Connected to MySQL>");
			
			//Prepared statements used to query database - Users
			listUsersStatement = conn.prepareStatement("select * from Users");
			addUserStatement = conn.prepareStatement("insert into Users(username, password) values(?, ?)");
			clearUsersStatement = conn.prepareStatement("delete from Users");
			updateUsersPasswordStatement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			//Prepared statements used to query database - Items
			listItemsStatement = conn.prepareStatement("select * from Items");
			addItemStatement = conn.prepareStatement("insert into Items(itemName, listingName, imageURL, description, availability, startingBid, currentBid, startDate, endDate, bidderName, bidderEmail, categoryID) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			clearItemsStatement = conn.prepareStatement("delete from Items");
			updateItemStatement = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			
			//Prepared statements used to query database - Categories
			listCategoriesStatement = conn.prepareStatement("select * from Categories");
			clearCategoriesStatement = conn.prepareStatement("delete from Categories");
			addCategoryStatement = conn.prepareStatement("insert into Categories(category) values(?)");
		} catch(Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
	
	//Users
	PreparedStatement listUsersStatement; //Statement to list all the administrators from the Users table
	PreparedStatement addUserStatement; //Statement to add a new administrator to the Users table
	PreparedStatement clearUsersStatement; //Statement to delete all the administrators from the Users table
	Statement updateUsersPasswordStatement; //Statement to update a administrator's password from the Users table
	
	//Items
	PreparedStatement listItemsStatement; //Statement to list all the items from the Items table
	PreparedStatement addItemStatement; //Statement to add a new item to the Items table
	PreparedStatement clearItemsStatement; //Statement to delete all the items from the Items table
	Statement updateItemStatement; //Statement to update a item's values from the Items tables
	
	//Categories
	PreparedStatement listCategoriesStatement; //Statement to list all the categories from the Categories table
	PreparedStatement addCategoryStatement; //Statement to add a new category to the Categories table
	PreparedStatement clearCategoriesStatement; //Statement to delete all the categories from the Categories table
	
/******************************************************************
 *                   Clearing the Database                        *
 ******************************************************************/
	/**
	 * Removes all the users from the Users table
	 */
	public void clearUsers() {
		try {
			clearUsersStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
	
	/**
	 * Removes all the items from the Items table
	 */
	public void clearItems() {
		try {
			clearItemsStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	/**
	 * Removes all the categories from the Categories table
	 */
	public void clearCategories() {
		try {
			clearCategoriesStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

/******************************************************************
 *                       User Functions                           *
 ******************************************************************/
	
	/**
	 * Adds a new user to the database.
	 * Hashes and Salts password into MD5
	 * @param username String for the username
	 * @param password String for the password
	 * @return boolean for successful user add
	 */
	public boolean addUser(String username, String password) {
		try {
			/**
			 * Password hashing comes from the: commons-codec-1.7.jar
			 * http://commons.apache.org/proper/commons-codec//
			 */

			//Salt value contains all the most infrequently used characters
			final String salt = "!*%<.+)>;@(^|~-&$`=:_#,";
			
			//Add username and password has to database and update
			addUserStatement.setString(1, username);
			addUserStatement.setString(2, DigestUtils.md5Hex(password + salt));
			addUserStatement.executeUpdate();
			
			System.out.println("addUser() : user " + username);
			return true;
		} catch (Exception e) {
			 System.out.println("Error in addUser():\n" + e.getClass().getName() + ": " + e.getMessage());
		}
		return false;
	}
	
	/**
	 * Logins a user into the admin panel.
	 * @param username String for the username
	 * @param password String for the password
	 * @return boolean for successful login
	 */
	public boolean validateUser(String username, String password) {
		System.out.println("yes I am in");
		try {
			//Salt value contains all the most infrequently used characters
			final String salt = "!*%<.+)>;@(^|~-&$`=:_#,";
			
			ResultSet rs = listUsersStatement.executeQuery();
			while (rs.next()){
				if (rs.getString("username").equals(username) && rs.getString("password").equals(DigestUtils.md5Hex(password + salt))) {
					System.out.println("validateUser() : user " + username);
					return true;
				}
			}
		} catch (Exception e) {
			 System.out.println("Error in validateUser():\n" + e.getClass().getName() + ": " + e.getMessage());
		}
		return false;
	}
	
	/**
	 * Changes the password of a given user.
	 * @param username String for the username
	 * @param password String for the password
	 * @param newPassword String for the new password
	 * @return boolean for successful change
	 */
	public boolean changePassword(String username, String password, String newPassword) {
		try {
			//Salt value contains all the most infrequently used characters
			final String salt = "!*%<.+)>;@(^|~-&$`=:_#,";
			
			ResultSet rs = listUsersStatement.executeQuery();
			ResultSet rss = updateUsersPasswordStatement.executeQuery("select * from Users");
			
			while (rs.next()){
				if (rs.getString("username").equals(username) && rs.getString("password").equals(DigestUtils.md5Hex(password + salt))) {
					
					//Set updater to the correct row in Items
					rss.absolute(rs.getRow());
					rss.updateString("password", DigestUtils.md5Hex(newPassword + salt));
					rss.updateRow();
					System.out.println("changePassword() : user " + username);
					return true;
				}
			}
		} catch (Exception e) {
			 System.out.println("Error in changePassword():\n" + e.getClass().getName() + ": " + e.getMessage());
		}
		return false;
	}

/******************************************************************
 *                       Item Functions                           *
 ******************************************************************/
	
	/**
	 * Returns a list of categories, with their item names.
	 * @return LinkedHashMap with items linked to categories.
	 */
	public LinkedHashMap<String, List<String>> getCategoryTree() {
		/*
		 * Stores information for left sidebar.
		 * 
		 * LinkedHashMap preserves insertion order.
		 * HashMap has a key and a value.
		 * Key: String
		 * Value: ArrayList<String>
		 * 
		 * For example:
		 * key: Dance Lessons
		 * value: Lindy Hop dance lessons, Texas Swing dance lessons, Indian classical dance lessons
		 * or
		 * {["Dance Lessons", ["Lindy Hop dance lessons", "Texas Swing dance lessons", "Indian classical dance lessons"]]}
		 */
		LinkedHashMap<String, List<String>> map = new LinkedHashMap<String, List<String>>();
		try {
			ResultSet rs = listCategoriesStatement.executeQuery();
			//Goes to next item in category list result set
			while (rs.next()) {
				//Cycles through the different categories
				int id = rs.getInt("id");
				String category = rs.getString("category");
				
				map.put(category, new ArrayList<String>());
				
				ResultSet rss = listItemsStatement.executeQuery();
				/*
				 * Goes to next item in item list result set.
				 * Get categoryID and add to if that categoryID == the id retrieved above
				 */
				while (rss.next()) {
					int idItem = rss.getInt("categoryID");
					String itemName = rss.getString("itemName");
					if (idItem == id)
						map.get(category).add(itemName);
				}
			}
		} catch (Exception e) {
			 System.out.println("Error in getCategoryTree():\n" + e.getClass().getName() + ": " + e.getMessage());
		}
		
		//Print out Array
		Iterator<String> iterator = map.keySet().iterator();
		System.out.println("getCategoryTree():");
		while (iterator.hasNext()) {
			String arrayName = iterator.next();
			List<String> list = map.get(arrayName);
			System.out.print("\t" + arrayName + ":[");
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i));
				if (i <list.size()-1)
					System.out.print(", ");
			}
			System.out.println("]");
		}
		return map;
	}
	
	public Object[] getItemProperties(int category, int item) {
		Object[] itemProperties = new Object[11];
		try {
			ResultSet rs = listCategoriesStatement.executeQuery();
			rs.absolute(category);
			
			ResultSet rss = listItemsStatement.executeQuery();
			
			int counter = 1;
			//Continues only if there are more items in the result set
			while (rss.next()) {
				
				//Checks if the item is a subset of category
				if (rs.getInt("id") == rss.getInt("categoryID")) {
					if (counter == item) {
						for (int i = 2; i < 13; i++)
							itemProperties[i-2] = rss.getObject(i);
						break;
					} else
						counter++;
				}
			}
		} catch (Exception e) {
			 System.out.println("Error in getItemProperties():\n" + e.getClass().getName() + ": " + e.getMessage());
		}
		
		System.out.print("getItemProperties():[");
		for (int i = 0; i < 11; i++) {
			System.out.print(itemProperties[i]);
			if (i < 10)
				System.out.print(", ");
		}
		System.out.println("]");
		
		return itemProperties;
	}
	
	/**
	 * Add a items to the Items table
	 * @param itemName String for the itemName
	 * @param listingName String for the listingName
	 * @param imageURL String for the imageURL
	 * @param description String for the description
	 * @param availability String for the availability
	 * @param startingBid double for the starting price
	 * @param duration int for the auction time in days
	 * @param categoryID int corresponding to category
	 * @return boolean for successful addition
	 */
	public boolean addItem(String itemName, String listingName, String imageURL, String description, String availability, double startingBid, int duration, int categoryID) {
		try {
			long time = (long) 86400000 * duration;
//			long time = (long) 3610000; //hour
//			long time = (long) 80000; //min
			
			ResultSet rs = listCategoriesStatement.executeQuery();
			rs.next();
			
			//Get 'i'th item of result set rs
			for (int i = 0; i < categoryID; i++)
				rs.next();
				
			
			int id = rs.getInt("id");
			
			addItemStatement.setString(1, itemName);
			addItemStatement.setString(2, listingName);
			addItemStatement.setString(3, imageURL);
			addItemStatement.setString(4, description);
			addItemStatement.setString(5, availability);
			addItemStatement.setDouble(6, startingBid);
			addItemStatement.setDouble(7, 0.0);
			addItemStatement.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
			addItemStatement.setTimestamp(9, new Timestamp(System.currentTimeMillis() + time));
			addItemStatement.setString(10, null);
			addItemStatement.setString(11, null);
			addItemStatement.setInt(12, id);
			addItemStatement.executeUpdate();
			
			System.out.println("addItem() : " + itemName);
			return true;
		} catch (Exception e) {
			 System.out.println("Error in addItem():\n" + e.getClass().getName() + ": " + e.getMessage());
		}
		
		return false;
	}
	
	public boolean placeBid(int categoryID, int itemID, double bid, String name, String email) {
		try {
			ResultSet rs = listCategoriesStatement.executeQuery();
			rs.absolute(categoryID);
			
			ResultSet rss = listItemsStatement.executeQuery();
			ResultSet rsss = updateItemStatement.executeQuery("select * from Items");
			
			int counter = 1;
			//Continues only if there are more items in the result set
			while (rss.next()) {
				//Checks if the item is a subset of category
				if (rs.getInt("id") == rss.getInt("categoryID")) {
					if (counter == itemID) {
						break;
					} else
						counter++;
				}
			}
			
			//Set updater to the correct row in Items
			rsss.absolute(rss.getRow());
			
			//Check if auction has ended.
			if (new Timestamp(System.currentTimeMillis()).before(rss.getTimestamp("endDate"))) {
				//Check if bid is greater than currentBid
				
				//If there no bids, then check it against the starting price.
				if (rss.getDouble("currentBid") == 0.0) {
					if (bid >= rss.getDouble("startingBid")) {
						rsss.updateDouble("currentBid", bid);
						rsss.updateString("bidderName", name);
						rsss.updateString("bidderEmail", email);
						rsss.updateRow();
					}
				}
				//Check bid is greater than current bid, if bid is already in place.
				else if (bid > rss.getDouble("currentBid")) {
					rsss.updateDouble("currentBid", bid);
					rsss.updateString("bidderName", name);
					rsss.updateString("bidderEmail", email);
					rsss.updateRow();
					System.out.println("else if");
				}
				else
					return false;
			} else
				return false;
			
			System.out.println("placeBid():[" + bid + " " + name + " " + email + "]");
		} catch (Exception e) {
			 System.out.println("Error in placeBid: " + e.getClass().getName() + ": " + e.getMessage());
			 return false;
		}
		return true;
	}
	
/******************************************************************
 *                    Category Functions                          *
 ******************************************************************/
	
	/**
	 * Adds a new category to the Categories table
	 * @param category String for a category
	 * @return boolean for successful addition
	 */
	public boolean addCategory(String category) {
		try {
			addCategoryStatement.setString(1, category);
			addCategoryStatement.executeUpdate();
			System.out.println("addCategory() : " + category);
			return true;
		} catch (Exception e) {
			 System.out.println("Error in addCategory():\n" + e.getClass().getName() + ": " + e.getMessage());
		}
		return false;
	}
}