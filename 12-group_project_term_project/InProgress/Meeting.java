/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Meghan
 */
public class Meeting {
    
    private String day;
    private int startTime;//1-24
    private int endTime;
    
    public Meeting(String day, int startTime, int endTime)
    {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * @return the day
     */
    public String getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * @return the startTime
     */
    public int getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    public int getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
    
    /**
     * returns the dimension of top side of javascript block
     * @param startTime
     * @param endTime 
     */
    public int getPixelHeightTop(int startTime, int endTime)
    {
     
        return 0;
    }
    
    /**
     * returns the dimension of bottom side of javascript block
     * @param startTime 
     * @param endTime 
     */
    public int getPixelHeightBottom(int startTime, int endTime)
    {
        
        return 0;
    }
    
    
    /**
     * returns the dimension of left side of javascript block
     * @param startTime
     * @param endTime 
     */
    public int getPixelWidthLeft(String day)
    {
        
        return 0;
    }
    
    /**
     * returns the dimension of right side of javascript block
     * @param day 
     */
    public int getPixelWidthRight(String day)
    {
     
        return 0;
    }
    
    /**
     * Check meeting day and time against other meetings in schedule.  
     * Return true if class meeting does not interfere with current schedule
     */
    public boolean checkSchedule(Meeting [] meetings)
    {
        //Need to keep an array of all class meetings added to schedule
        
        //Checks the start and end time of one meeting against current meetings in schedule
        //to see if the meeting 
        for(int i = 0; i < meetings.length; i++)
        {
            Meeting scheduled = meetings[i];
            if(this.startTime >scheduled.getStartTime() && this.startTime < scheduled.getEndTime()
                    || this.endTime>scheduled.getStartTime() && this.endTime > scheduled.getEndTime())
            {
                return false;
            }
        }
        
        return true;
    }
    
    
}
