package coursepicker;

import java.util.ArrayList;

/**
 * This class represents one course meeting.  Most courses will have multiple meetings.
 * A meeting can be checked against multiple meetings to determine if can be taken in 
 * conjunction with those meetings.  A meetings can also be set to pixel values that
 * correspond with a schedule graph. 
 * @author Meghan Redwine
 */
public class Meeting {
	protected String prefix;
	protected String number;
	protected String title;
	protected String instructor;
	protected String day;
	protected String building;
	protected String room;
	protected int startTime;
	protected int endTime;

    
    /**
     * Constructor
     * Parses times from String to int in 24-hr format
     * @param prefix
     * @param title
     * @param number
     * @param instructor
     * @param day
     * @param startTime
     * @param endTime
     * @param building
     * @param room 
     */
    public Meeting(String prefix, String number, String title, String instructor, 
            String day, String startTime, String endTime, String building, String room) {
        this.prefix = prefix;
        this.title = title;
        this.number = number;
        this.instructor = instructor;
        this.day = day;
        this.building = building;
        this.room = room;
        
        /*
         * Change time into 24-hr format - parse from String to int
         */
        for(int i = 0; i<2; i++) {
            String time = "";
            if(i==0)
                time = startTime;
            else
                time = endTime;
            
            String time2 = time.substring(time.length()-1);
            String time1 = time.substring(0, time.length()-1);
            int timeInt = 0;

            //parse time to int
            try {
                timeInt = Integer.parseInt(time1);
            } catch(Exception e) {
                timeInt = 0;
            }

            //Afternoon class - convert to 24hr format
            if(time2.compareToIgnoreCase("p")==0) {     
                if(time1.substring(0, 2).compareTo("12") == 0) {
                    //do nothing - noon
                }
                else {
                    timeInt = timeInt+1200;
                }
            }
            else if(time2.compareToIgnoreCase("a")==0) {
                //do nothing
            }
            else {
                timeInt = 0; //Error with time format
            }
            if(i==0) {
                this.startTime = timeInt;
            }
            else {
                this.endTime = timeInt;
            }
        }
    }
    
    public Meeting() {
    	
    }
    
    /**
     * Get meeting day
     * @return the day
     */
    public String getDay() {
        return day;
    }


    /**
     * Get meeting start time
     * @return the startTime
     */
    public int getStartTime() {
        return startTime;
    }
    
    /**
     * Get meeting end time
     * @return the endTime
     */
    public int getEndTime() {
        return endTime;
    }

    /**
     * Get meeting prefix
     * @return the prefix
     * Takes 
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Get meeting title
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get meeting number
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * Get meeting instructor
     * @return the instructor
     */
    public String getInstructor() {
        return instructor;
    }

    /**
     * Get meeting building number
     * @return the building
     */
    public String getBuilding() {
        return building;
    }

    /**
     * Get meeting room number
     * @return the room
     */
    public String getRoom() {
        return room;
    }
    
    /**
     * Returns the 'x' of the schedule block based on the meeting day
     * @return x
     */
    public int getPixelX() {
        int offset;
        int x = 0;
        
        if(this.day.compareToIgnoreCase("M")==0)//Monday
            offset = 0;
        else if(this.day.compareToIgnoreCase("T")==0)//Tuesday
            offset = 1;
        else if(this.day.compareToIgnoreCase("W")==0)//Wednesday
            offset = 2;
        else if(this.day.compareToIgnoreCase("R")==0)//Thursday
            offset = 3;
        else//Friday
            offset = 4;
        
        x = (int)(50+156*offset);
             
        return x;
    }
    
    /**
     * returns the 'y' of the schedule block - estimated to the nearest 15 minutes
     * @return y
     */
    public int getPixelY() {
        //Every 11  = 15
        //Every 100 = 45
        
        int timeAfter8 = this.startTime-800;
        double hoursD = timeAfter8/100;
        int hours = (int)hoursD;//truncate
        
        
        int minute = timeAfter8%100;
        double minutesD = minute/15;
        int minutes = (int)minutesD;//truncate
        int pixMins = minutes*11;//Adds 11 for every set of 15 minutes
        int pixHours = hours*45; //adds 45 for every hour past 8
        
        /*
         * ie: 915
         * 915 - 800 = 115
         * 115/100(trunc) = 1
         * 60+1*45 = 105
         * 
         * 115%100 = 15
         * 15/15(trunc) = 1
         * 15*1 = 15
         * 
         * 915 = 120 pixels
         */
        int pixY = 51 +pixHours + pixMins;
        return pixY;   
    }
    
    /**
     * Get estimated height of schedule block - to the nearest 15 minutes
     * @return height
     */
    public int getHeight() {
        int timeAfter8 = this.endTime-800;//1205 - 800 = 405
        double hoursD = timeAfter8/100;//4
        int hours = (int)hoursD;//truncate
        
        int minute = timeAfter8%100;//5
        double minutesD = minute/15;//0
        int minutes = (int)minutesD;//truncate
        int pixMins = minutes*11;//Adds 11 for every set of 15 minutes
        int pixHours = hours*45; //adds 45 for every hour past 8
        //45*4 = 180
        int height = (pixMins+pixHours+55 - this.getPixelY());
        return height;
    }
    /**
     * Check if class meeting can be added to schedule without interfering with any class meeting
     * @param current
     * @param meetings
     * @return 
     */
    public boolean checkFullSchedule(ArrayList <Meeting> current, ArrayList <Meeting> meetings) {
        //Get ith meeting from current list of meetings and compare to meetings already added to schedule
    	for (int i = 0; i < current.size(); i++) {
    		day = current.get(i).getDay();
    		startTime = current.get(i).getStartTime();
    		endTime = current.get(i).getEndTime();
    		
    		if (!checkSchedule(meetings))
    			return false;
    	}
    	
    	return true;
    }
    
    /**
     * Check meeting day and time against other meetings in schedule.  
     * Return true if class meeting does not interfere with current schedule
     */
    public boolean checkSchedule(ArrayList <Meeting> meetings) {
        //Need to keep an array of all class meetings added to schedule
        
        //Checks the start and end time of one meeting against current meetings in schedule
        //to see if the meeting 
        if(!meetings.isEmpty()) {
            //Checks if there is an interference with the ith meeting
            for(int i = 0; i < meetings.size(); i++) {
                Meeting scheduled = meetings.get(i);
                
                //Check if day conflicts
                if(this.day.compareToIgnoreCase(scheduled.getDay()) == 0) {
                    //Check if time on same day conflicts
                    if(this.startTime >=scheduled.getStartTime() && this.startTime <= scheduled.getEndTime() || this.endTime>=scheduled.getStartTime() && this.endTime <= scheduled.getEndTime()) {
                    	outputConflict(scheduled);
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    public void outputConflict(Meeting meeting) {
    	System.out.println("\n\tERROR: First time conflict:");
    	System.out.println("\t[" + meeting.prefix + ", " + meeting.number + ", " + meeting.title + ", " + meeting.instructor + ", " + meeting.day + ", " + meeting.startTime + ", " + meeting.endTime + ", " + meeting.building + ", " + meeting.room + "]");
    	System.out.println("\tERROR: Class Not Added.\n");
    }
    
    public String toString() {
    	return "[" + prefix + ", " + number + ", " + title + ", " + instructor + ", " + day + ", " + startTime + ", " + endTime + ", " + building + ", " + room + "]";
    }
}
