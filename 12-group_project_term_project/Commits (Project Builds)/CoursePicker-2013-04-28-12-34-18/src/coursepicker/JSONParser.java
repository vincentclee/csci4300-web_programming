package coursepicker;

import java.util.ArrayList;

/**
 * Manages the parsing operation from java to javascript.
 * @author Vincent Lee
 */
public class JSONParser {
	protected ArrayList<Meeting> classMeetings;
	protected String JSONprefix;
	protected String JSONnumber;
	protected String JSONtitle;
	protected String JSONinstructor;
	protected String JSONday;
	protected String JSONstartTime;
	protected String JSONendTime;
	protected String JSONbuilding;
	protected String JSONroom;
	protected String JSONposX;
	protected String JSONposY;
	protected String JSONheight;
	
	/**
	 * Constructor which takes in classMeetings.
	 * @param classMeetings All of the meeeting times for classes
	 * @author Vincent Lee
	 */
	public JSONParser(ArrayList<Meeting> classMeetings) {
		this.classMeetings = classMeetings;
		JSONprefix = "";
		JSONnumber = "";
		JSONtitle = "";
		JSONinstructor = "";
		JSONday = "";
		JSONstartTime = "";
		JSONendTime = "";
		JSONbuilding = "";
		JSONroom = "";
		JSONposX = "";
		JSONposY = "";
		JSONheight = "";
	}
	
	/**
	 * Default Constructor
	 * @author Vincent Lee
	 */
	public JSONParser() {
		classMeetings = new ArrayList<Meeting>();
		JSONprefix = "";
		JSONnumber = "";
		JSONtitle = "";
		JSONinstructor = "";
		JSONday = "";
		JSONstartTime = "";
		JSONendTime = "";
		JSONbuilding = "";
		JSONroom = "";
		JSONposX = "";
		JSONposY = "";
		JSONheight = "";
	}
	
	/**
	 * Method that does the parsing for all strings.
	 * @author Vincent Lee
	 */
	public void parse() {
		for (int i = 0; i < classMeetings.size(); i++) {
			JSONprefix += classMeetings.get(i).getPrefix();
			JSONnumber += classMeetings.get(i).getNumber();
			JSONtitle += classMeetings.get(i).getTitle();
			JSONinstructor += classMeetings.get(i).getInstructor();
			JSONday += classMeetings.get(i).getDay();
			JSONstartTime += classMeetings.get(i).getStartTime();
			JSONendTime += classMeetings.get(i).getEndTime();
			JSONbuilding += classMeetings.get(i).getBuilding();
			JSONroom += classMeetings.get(i).getRoom();
			JSONposX += classMeetings.get(i).getPixelX();
			JSONposY += classMeetings.get(i).getPixelY();
			JSONheight += classMeetings.get(i).getHeight();
			if (i < classMeetings.size()-1) {
				JSONprefix += "\", \"";
				JSONnumber += "\", \"";
				JSONtitle += "\", \"";
				JSONinstructor += "\", \"";
				JSONday += "\", \"";
				JSONstartTime += "\", \"";
				JSONendTime += "\", \"";
				JSONbuilding += "\", \"";
				JSONroom += "\", \"";
				JSONposX += "\", \"";
				JSONposY += "\", \"";
				JSONheight += "\", \"";
			}
		}
	}

	/**
	 * @return the jSONprefix
	 */
	public String getJSONprefix() {
		return JSONprefix;
	}

	/**
	 * @return the jSONnumber
	 */
	public String getJSONnumber() {
		return JSONnumber;
	}

	/**
	 * @return the jSONtitle
	 */
	public String getJSONtitle() {
		return JSONtitle;
	}

	/**
	 * @return the jSONinstructor
	 */
	public String getJSONinstructor() {
		return JSONinstructor;
	}

	/**
	 * @return the jSONday
	 */
	public String getJSONday() {
		return JSONday;
	}

	/**
	 * @return the jSONstartTime
	 */
	public String getJSONstartTime() {
		return JSONstartTime;
	}

	/**
	 * @return the jSONendTime
	 */
	public String getJSONendTime() {
		return JSONendTime;
	}

	/**
	 * @return the jSONbuilding
	 */
	public String getJSONbuilding() {
		return JSONbuilding;
	}

	/**
	 * @return the jSONroom
	 */
	public String getJSONroom() {
		return JSONroom;
	}

	/**
	 * @return the jSONposX
	 */
	public String getJSONposX() {
		return JSONposX;
	}

	/**
	 * @return the jSONposY
	 */
	public String getJSONposY() {
		return JSONposY;
	}

	/**
	 * @return the jSONheight
	 */
	public String getJSONheight() {
		return JSONheight;
	}
}
