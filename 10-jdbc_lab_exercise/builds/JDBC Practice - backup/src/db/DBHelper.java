/**
 * @author Vincent Lee
 * @author Meghan Redwine
 */

package db;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DBHelper {
	/**
	 * Opens a connection to the course database
	 */
	public DBHelper() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Instantiated MySQL driver!");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/csci4300", "root", "mysql");
			System.out.println("Connected to MySQL!");
			
			clearBandsStatement = conn.prepareStatement("delete from Band");
			listBandsStatement = conn.prepareStatement("select id, bandName from Band");
			addBandStatement = conn.prepareStatement("insert into Band (bandName) values(?)");
			addAlbumStatement = conn.prepareStatement("insert into Album (bandId, albumName) values(?, ?)");
			listAlbumsStatement = conn.prepareStatement("select Band (id), albumName from Band values(?)");
		} catch(Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
	
	/**
	 * Statement to add a band to the Band table
	 */
	PreparedStatement addBandStatement;
	
	/**
	 * Statement to delete all the bands from the Band table
	 */
	PreparedStatement clearBandsStatement;
	
	/**
	 * Statement to list all the bands from the Band table
	 */
	PreparedStatement listBandsStatement;
	
	/**
	 * Statement to add a album to a band Album table
	 */
	PreparedStatement addAlbumStatement;

	/**
	 * Statement to list all the albums for a Band from Album table
	 */
	PreparedStatement listAlbumsStatement;

	/**
	 * Removes all the bands from the Band table
	 */
	public void clearBands() {
		try {
			clearBandsStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
	
	/**
	 * Returns a list of all the bands
	 */
	public ArrayList<Band> getBandList(){
		ArrayList<Band> list = new ArrayList<Band>();
		try {
			ResultSet rs = listBandsStatement.executeQuery();
			while (rs.next()) {
				/*
				 * package the current record as a Band object
				 * and add to list
				 */
				int id = rs.getInt("id");
				String bandName = rs.getString("bandName");
				Band band = new Band(id, bandName);
				list.add(band);
			}
			return list;
		} catch (Exception e) {
			 System.out.println("Error populating Band list\n" + 
					 e.getClass().getName() + ": " + e.getMessage());
		 }
		return list;
	}

	/**
	 * Adds a band to the Band table
	 */
	public void addBand(String bandName) {
		try {
			addBandStatement.setString(1, bandName);
			addBandStatement.executeUpdate();
		} catch (Exception e) {
			 System.out.println("Error in addBand: "+
		        e.getClass().getName()+": "+ e.getMessage());
		 }
	}
	
	/**
	 * Adds an album to the Album table, linked to
	 * its band.
	 */
	public void addAlbum(String albumName, int bandId) {
		try {
			addAlbumStatement.setString(bandId, albumName);
			addAlbumStatement.executeUpdate();
		} catch (Exception e) {
			 System.out.println("Error in addAlbum: "+
		        e.getClass().getName()+": "+ e.getMessage());
		}
	}
	
	/**
	 * Returns a list of all albums associated with the
	 * bands whose id is 'bandId'
	 */
	public ArrayList<String> getAlbumList(int bandId) {
		ArrayList<String> list = new ArrayList<String>();
		try {
			listAlbumsStatement.setInt(1, bandId);
			
			ResultSet rs = listBandsStatement.executeQuery();
			while (rs.next()){
				//add the album name in the current record to list
				String albumName = rs.getString("albumName");
				list.add(albumName);
			}	
		} catch (Exception e) {
			 System.out.println("Error in listing albums: " +
		     e.getClass().getName() + ": " + e.getMessage());
		}
		return list;
	}
}	
