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
	@SuppressWarnings("unused")
	private String bandName, albumName, searchName, clear;
	private int command;
	private ArrayList<String> findList;


	/** Opens a connection to the course database */
	public DBHelper() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Instantiated MySQL driver!");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/csci4300", "root", "mysql");
			System.out.println("Connected to MySQL!");
			
			clearBandsStatement = conn.prepareStatement("delete from Band");
			clearAlbumsStatement = conn.prepareStatement("delete from Album");
			listBandsStatement = conn.prepareStatement("select id, bandName from Band");
			addBandStatement = conn.prepareStatement("insert into Band (bandName) values(?)");
			addAlbumStatement = conn.prepareStatement("insert into Album (albumName, bandId) values(?, ?)");
			listAlbumsStatement = conn.prepareStatement("select bandId, albumName from Album");
			
			findList = new ArrayList<String>();
		} catch(Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

	/** Statement to add a band to the Band table */
	PreparedStatement addBandStatement;
	
	/** Statement to delete all the bands from the Band table */
	PreparedStatement clearBandsStatement;
	
	/** Statement to delete all the albums from the Albums table */
	PreparedStatement clearAlbumsStatement;
	
	/** Statement to list all the bands from the Band table */
	PreparedStatement listBandsStatement;
	
	/** Statement to add a album to a band Album table */
	PreparedStatement addAlbumStatement;

	/** Statement to list all the albums for a Band from Album table */
	PreparedStatement listAlbumsStatement;

	/** Removes all the bands from the Band table */
	public void clearBands() {
		try {
			clearBandsStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
	
	/** Removes all the albums from the Album table */
	public void clearAlbums() {
		try {
			clearAlbumsStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}
	
	/** Returns a list of all the bands */
	public ArrayList<Band> getBandList(){
		ArrayList<Band> list = new ArrayList<Band>();
		ArrayList<String> albums = null;
		try {
			ResultSet rs = listBandsStatement.executeQuery();
			// Goes to next item in band list result set
			while (rs.next()) {
				// package the current record as a Band object and add to list
				int id = rs.getInt("id");
				String bandName = rs.getString("bandName");
				
				albums = new ArrayList<String>();
				ResultSet rss = listAlbumsStatement.executeQuery();
				/*
				 * Goes to next item in album list result set.
				 * Get band id and add if that band id == the id retrieved above
				 */
				while (rss.next()) {
					int idBand = rss.getInt("bandId");
					String albumName = rss.getString("albumName");
					if (idBand == id)
						albums.add(albumName);
				}
				list.add(new Band(id, bandName, albums));
			}
			return list;
		} catch (Exception e) {
			 System.out.println("Error populating Band list\n" + 
					 e.getClass().getName() + ": " + e.getMessage());
		}
		return list;
	}

	/** Adds a band to the Band table */
	public void addBand(String bandName) {
		try {
			addBandStatement.setString(1, bandName);
			addBandStatement.executeUpdate();
		} catch (Exception e) {
			 System.out.println("Error in addBand: "+
		        e.getClass().getName()+": "+ e.getMessage());
		}
	}
	
	/** Adds an album to the Album table, linked to its band. */
	public void addAlbum(String albumName, int bandId) {
		try {
			ResultSet rs = listBandsStatement.executeQuery();
			rs.next();
			
			//Get 'i'th item of result set rs
			for (int i = 0; i < bandId; i++)
				rs.next();
			
			int id = rs.getInt("id");
			
			addAlbumStatement.setString(1, albumName);
			addAlbumStatement.setInt(2, id);
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
			ResultSet rss = listBandsStatement.executeQuery();
			rss.next();
			//Get 'i'th item of result set rss
			for (int i = 0; i < bandId; i++)
				rss.next();
			int id = rss.getInt("id");
						
			//getAlbum
			ResultSet rs = listAlbumsStatement.executeQuery();
			while (rs.next()) {
				int idBand = rs.getInt("bandId");
				String albumName = rs.getString("albumName");
				if (idBand == id)
					list.add(albumName);
			}
			return list;
		} catch (Exception e) {
			 System.out.println("Error listing albums: " +
		     e.getClass().getName()+": "+ e.getMessage());
		}
		return list;
	}

	/** @param bandName the bandName to set */
	public void setBandName(String bandName) {
		addBand(bandName);
	}
	
	/** @param albumName the albumName to set */
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
		addAlbum(albumName, command);
	}
	
	/** @param command the command to set */
	public void setCommand(int command) {
		this.command = command;
	}

	/** @param searchName the searchName to set */
	public void setSearchName(String searchName) {
		this.searchName = searchName;
		
		ArrayList<String> searchList = getAlbumList(command);
		
		findList = new ArrayList<String>();
		
		boolean found = false;
		//make String temp equal to next item.  Search for this item in bandlist.
		for (String item : searchList) {
			String temp = item;
			
		    if (item.toLowerCase().contains(searchName.toLowerCase())) {
		    	findList.add(getBandList().get(command).getBandName() + " - " + temp);
		    	found = true;
		    }
		}
		//item found in search
		if (found) {
			if (searchList.size() == 1)
				findList.add(0, "Search Result for \"" + searchName + "\" in \"" + getBandList().get(command).getBandName() + "\"");
			else
				findList.add(0, "Search Results for \"" + searchName + "\" in \"" + getBandList().get(command).getBandName() + "\"");
		} 
		//item not found in search
		else {
			findList.add(0, "Search Result for \"" + searchName + "\" in \"" + getBandList().get(command).getBandName() + "\"");
			findList.add("Sorry, no albums matched your criteria.");
		}
			
	}
	
	/** @return the findList */
	public ArrayList<String> getFindList() {
		return findList;
	}
	
	/** @param clear the clear to set */
	public void setClear(String clear) {
		this.clear = clear;
		findList.clear();
	}
}