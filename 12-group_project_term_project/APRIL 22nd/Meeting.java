/**
 * This class represents one course meeting.  Most courses will have multiple meetings.
 * A meeting can be checked against multiple meetings to determine if can be taken in 
 * conjunction with those meetings.  A meetings can also be set to pixel values that
 * correspond with a schedule graph. 
 * @author Meghan Redwine
 */

import java.util.ArrayList;


public class Meeting {
    
    private String prefix;
    private String title;
    private String number;
    private String instructor;
    private String day;
    private int startTime;
    private int endTime;
    private String building;
    private String room;
    
    
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
    public Meeting(String prefix, String title, String number, String instructor, 
            String day, String startTime, String endTime, String building, String room)
            
    {
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
        for(int i = 0; i<2; i++)
        {
            String time = "";
            if(i==0)
            {
                time = startTime;
            }
            else
            {
                time = endTime;
            }
            String time2 = time.substring(time.length()-1);
            String time1 = time.substring(0, time.length()-1);
            int timeInt = 0;

            try//parse time to int
            {
                timeInt = Integer.parseInt(time1);
            }catch(Exception e){
                timeInt = 0;
            }

            //Afternoon class - convert to 24hr format
            if(time2.compareToIgnoreCase("p")==0)
            {
                
                if(time1.substring(0, 2).compareTo("12") == 0)
                {
                    //do nothing - noon
                }
                else
                {
                    timeInt = timeInt+1200;
                }
            }
            else if(time2.compareToIgnoreCase("a")==0)
            {
                //do nothing
            }
            else
            {
                timeInt = 0; //Error with time format
            }
            if(i==0)
            {
                this.startTime = timeInt;
            }
            else
            {
                this.endTime = timeInt;
            }
        }
    }
    

    /**
     * @return the day
     */
    public String getDay() {
        return day;
    }

    

    /**
     * @return the startTime
     */
    public int getStartTime() {
        return startTime;
    }

    
    /**
     * @return the endTime
     */
    public int getEndTime() {
        
        return endTime;
    }

    /**
     * @return the prefix
     * Takes 
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the number
     */
    public String getNumber() {
        return number;
    }

    /**
     * @return the instructor
     */
    public String getInstructor() {
        return instructor;
    }

    /**
     * @return the building
     */
    public String getBuilding() {
        return building;
    }

    /**
     * @return the room
     */
    public String getRoom() {
        return room;
    }
    
    /**
     * Returns the 'x' of the schedule block based on the meeting day
     */
    public double getPixelX()
    {
        int offset;
        double x = 0;
        
        if(this.day.compareToIgnoreCase("M")==0)//Monday
        {
            offset = 0;
        }
        else if(this.day.compareToIgnoreCase("T")==0)//Tuesday
        {
            offset = 1;
        }
        else if(this.day.compareToIgnoreCase("W")==0)//Wednesday
        {
            offset = 2;
        }
        else if(this.day.compareToIgnoreCase("H")==0)//Thursday
        {
            offset = 3;
        }
        else//Friday
        {
            offset = 4;
        }
        
        x = 60.5+156*offset;
             
        return x;
    }
    
    /**
     * returns the 'y' of the schedule block - estimated to the nearest 15 minutes
     */
    public int getPixelY()
    {
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
        int pixY = 60 +pixHours + pixMins;
        return pixY;
        
    }
    
    /**
     * Estimated height - to the nearest 15 minutes
     */
    public int getHeight()
    {
        int timeAfter8 = this.endTime-800;//1205 - 800 = 405
        double hoursD = timeAfter8/100;//4
        int hours = (int)hoursD;//truncate
        
        int minute = timeAfter8%100;//5
        double minutesD = minute/15;//0
        int minutes = (int)minutesD;//truncate
        int pixMins = minutes*11;//Adds 11 for every set of 15 minutes
        int pixHours = hours*45; //adds 45 for every hour past 8
        //45*4 = 180
        int height = (pixMins+pixHours+60 - this.getPixelY());
        return height;
    }
    
    /**
     * Check meeting day and time against other meetings in schedule.  
     * Return true if class meeting does not interfere with current schedule
     */
    public boolean checkSchedule(ArrayList <Meeting> meetings)
    {
        //Need to keep an array of all class meetings added to schedule
        
        //Checks the start and end time of one meeting against current meetings in schedule
        //to see if the meeting 
        if(meetings != null)
        {
            for(int i = 0; i < meetings.size(); i++)
            {
                Meeting scheduled = meetings.get(i);
                if(this.startTime >=scheduled.getStartTime() && this.startTime <= scheduled.getEndTime()
                        || this.endTime>=scheduled.getStartTime() && this.endTime >= scheduled.getEndTime())
                {
                    return false;
                }
            }
        }
        else
        {
            return true;
        }
        return true;
    }
    
    
}
