package bands;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

/**
 * Manages database access for the Bands project.
 * @author drdan
 *
 */
public class DBHelper {
	static String JDBC_URL = "jdbc:mysql://localhost/csci4300";
  /**
   * Establish a connection to the database and create the
   * PreparedStgatements
   */
	public DBHelper(){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection(JDBC_URL, "root", "mysql");
				System.out.println("Connected to csci4300 database");
			}
		    catch(Exception e){
		    	e.printStackTrace();
		    }
		}//constructor
	/**
	 * Adds Band 'bandName' to the bands table
	 */
	public void addBand(String bandName){
		
	}
	/**
	 * Adds Album 'albumName' to the bands table
	 * @param albumName name of the  album
	 * @param bandId id of the band that recorded this album
	 */
	public void addAlbum(String albumName, int bandId){
		
	}
	/**
	 * Returns a list of all the Bands, each including its list of 
	 * albums
	 */
	public ArrayList<Band> getBandList(){
		ArrayList<Band> result = new ArrayList<Band>();
		//TODO: extract Bands and Albums from DB
		return result;
	}
	
}
