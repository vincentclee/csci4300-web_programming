/**
 * @author Vincent Lee
 * @author Meghan Redwine
 */

package db;

import java.util.ArrayList;

public class Band {
	private String bandName;
	private int bandId;
	private ArrayList<String> albumNames;
	
	/**
	 * Constructor which sets bandId and bandName, and albumNames
	 * @param bandId numerical value
	 * @param bandName String value
	 * @param albumNames ArrayList storing album names
	 */
	public Band(int bandId, String bandName, ArrayList<String> albumNames) {
		this.bandId = bandId;
		this.bandName = bandName;
		this.albumNames = albumNames;
	}
	
	/**
	 * Constructor which sets bandId and bandName
	 * @param bandId numerical value
	 * @param bandName String value
	 */
	public Band(int bandId, String bandName) {
		this.bandId = bandId;
		this.bandName = bandName;
		albumNames = new ArrayList<String>();
	}

	/**
	 * Default no-args Constructor
	 */
	public Band() {
		bandName = "";
		bandId = 0;
		albumNames = new ArrayList<String>();
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
	 * @return the albumNames
	 */
	public ArrayList<String> getAlbumNames() {
		return albumNames;
	}
}