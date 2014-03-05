/**
 * @author Vincent Lee
 * @author Meghan Redwine
 */

package db;

public class Band {
	private String bandName;
	private int bandId;
	
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
}