/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Meghan Redwine
 */
public class MeetingTest {
    
    public MeetingTest() {
        
    }
    
    Meeting instance = new Meeting("CSCI", "Web Programming","4300","Everett", 
            "T", "200p", "315p", "1141", "208");
    Meeting instance2 = new Meeting("CSCI", "Intro","1301","Staff", 
            "T", "200p", "315p", "1141", "208");
    Meeting instance3 = new Meeting("CSCI", "Intro","1301","Staff", 
            "M", "1115a", "1205p", "1141", "208");

    /**
     * Test of getDay method, of class Meeting.
     */
    @Test
    public void testGetDay() {
        System.out.println("getDay");
        String expResult = "T";
        String result = instance.getDay();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getStartTime method, of class Meeting.
     */
    @Test
    public void testGetStartTime() {
        System.out.println("getStartTime");
        int expResult = 1400;
        int result = instance.getStartTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEndTime method, of class Meeting.
     */
    @Test
    public void testGetEndTime() {
        System.out.println("getEndTime");
        int expResult = 1515;
        int result = instance.getEndTime();
        assertEquals(expResult, result);
    }
    
    

    /**
     * Test of checkSchedule method, of class Meeting.
     */
    @Test
    public void testCheckSchedule() {
        System.out.println("checkSchedule");
        ArrayList <Meeting> meetings = new ArrayList<Meeting>();
        boolean expResult = true;
        boolean result = instance.checkSchedule(meetings);
        assertEquals(expResult, result);
        
        meetings.add(instance);
        boolean expResult2 = false;
        boolean result2 = instance.checkSchedule(meetings);
        assertEquals(expResult2, result2);
        
    }

    /**
     * Test of getPrefix method, of class Meeting.
     */
    @Test
    public void testGetPrefix() {
        System.out.println("getPrefix");
        java.lang.String expResult = "CSCI";
        java.lang.String result = instance.getPrefix();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, of class Meeting.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        java.lang.String expResult = "Web Programming";
        java.lang.String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumber method, of class Meeting.
     */
    @Test
    public void testGetNumber() {
        System.out.println("getNumber");
        java.lang.String expResult = "4300";
        java.lang.String result = instance.getNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInstructor method, of class Meeting.
     */
    @Test
    public void testGetInstructor() {
        System.out.println("getInstructor");
        java.lang.String expResult = "Everett";
        java.lang.String result = instance.getInstructor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBuilding method, of class Meeting.
     */
    @Test
    public void testGetBuilding() {
        System.out.println("getBuilding");
        java.lang.String expResult = "1141";
        java.lang.String result = instance.getBuilding();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRoom method, of class Meeting.
     */
    @Test
    public void testGetRoom() {
        System.out.println("getRoom");
        java.lang.String expResult = "208";
        java.lang.String result = instance.getRoom();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPixelX method, of class Meeting.
     */
    @Test
    public void testGetPixelX() {
        System.out.println("getPixelX");
        double expResult = 216.5;
        double result = instance.getPixelX();
        assertEquals(expResult, result, 0.0);
        
        double expResult2 = 60.5;
        double result2 = instance3.getPixelX();
        assertEquals(expResult2, result2, 0.0);
    }

    /**
     * Test of getPixelY method, of class Meeting.
     */
    @Test
    public void testGetPixelY() {
        System.out.println("getPixelY");
        int expResult = 330;
        int result = instance.getPixelY();
        assertEquals(expResult, result);
        
        int expResult2 = 206;
        int result2 = instance3.getPixelY();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of getHeight method, of class Meeting.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        int expResult = 56;
        int result = instance.getHeight();
        assertEquals(expResult, result);
        
        int expResult2 = 0;
        int result2 = instance3.getHeight();
        assertEquals(expResult2, result2);
    }
}
