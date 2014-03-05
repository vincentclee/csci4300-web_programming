/**
 * @author Vincent Lee
 * @author Meghan Redwine
 */

package db;

import java.util.ArrayList;

public class Band {
	private String bandName;
	private int bandId;
	private ArrayList<String> list = new ArrayList<String>();
	
	/**
	 * Default Constructor which sets bandId and bandName
	 * @param bandId numerical value
	 * @param bandName String value
	 */
	public Band(int bandId, String bandName) {
		this.bandId = bandId;
		this.bandName = bandName;
	}

	/**
	 * @return the bandName
	 */
	public String getBandName() {
		return bandName;
	}

	/**
	 * @return the bandId
	 */
	public int getBandId() {
		return bandId;
	}
	
	/**
	 * Adds an album to the Album table, linked to
	 * its band.
	 */
	public void addAlbum(String albumName) {
		list.add(albumName);
	}
	
	/**
	 * Returns a list of all the albums by a band
	 */
	public ArrayList<String> getAlbumList() {
		return list;
	}
}