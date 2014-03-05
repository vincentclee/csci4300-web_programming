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
                //Parse ith class meeting
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
                        //Format if not at last class meeting
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
         * Get prefix
	 * @return the jSONprefix
	 */
	public String getJSONprefix() {
		return JSONprefix;
	}

	/**
         * Get number
	 * @return the jSONnumber
	 */
	public String getJSONnumber() {
		return JSONnumber;
	}

	/**
         * Get title
	 * @return the jSONtitle
	 */
	public String getJSONtitle() {
		return JSONtitle;
	}

	/**
         * Get instructor
	 * @return the jSONinstructor
	 */
	public String getJSONinstructor() {
		return JSONinstructor;
	}

	/**
         * Get day
	 * @return the jSONday
	 */
	public String getJSONday() {
		return JSONday;
	}

	/**
         * Get start time
	 * @return the jSONstartTime
	 */
	public String getJSONstartTime() {
		return JSONstartTime;
	}

	/**
         * Get end time
	 * @return the jSONendTime
	 */
	public String getJSONendTime() {
		return JSONendTime;
	}

	/**
         * Get building
	 * @return the jSONbuilding
	 */
	public String getJSONbuilding() {
		return JSONbuilding;
	}

	/**
         * Get room
	 * @return the jSONroom
	 */
	public String getJSONroom() {
		return JSONroom;
	}

	/**
         * Get position x for graph
	 * @return the jSONposX
	 */
	public String getJSONposX() {
		return JSONposX;
	}

	/**
         * Get position Y for graph
	 * @return the jSONposY
	 */
	public String getJSONposY() {
		return JSONposY;
	}

	/**
         * Get height for graph
	 * @return the jSONheight
	 */
	public String getJSONheight() {
		return JSONheight;
	}
}
