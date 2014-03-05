package csci4300;

import java.util.ArrayList;

import junit.framework.TestCase;

public class StudentTest extends TestCase {

	private String aboutFred = "I love my life here in the Stone Age. Yabba-dabba-doo!";
	private String fredURL   = "http://userserve-ak.last.fm/serve/_/33397865/Fred+Flintstone+FredFlintstone.jpg";
	//Fred Flintstone is a creation of Hanna-Barbera Productions
	
	/**
	 * Verifies that a newly created Student has the 
	 * supplied name, decscription, and  image URL and an empty list
	 * of activities
	 */
	public void testDetailedConstructor() {
		
		Student fred = new Student ("Fred Flintstone",aboutFred,fredURL);
		ArrayList<String> newStudentActivities = fred.getActivityList();
		assertEquals("Student name","Fred Flintstone",fred.getStudentName());
		assertEquals("Student description",aboutFred,fred.getDescription());
		assertEquals("Fred's image",fredURL, fred.getImageURL());
		assertTrue("Student activity list should be empty",newStudentActivities.isEmpty());
	}
	
	/**
	 * Verifies creating a Student with the no-Arg constructor and 
	 * populating it via setter methods
	 */
	public void testNoArgConstructor() {
		
		Student fred = new Student ();
		fred.setStudentName("Fred Flintstone");
		fred.setDescription(aboutFred);
		fred.setImageURL(fredURL);
		ArrayList<String> newStudentActivities = fred.getActivityList();
		assertEquals("Student name","Fred Flintstone",fred.getStudentName());
		assertEquals("Student description",aboutFred,fred.getDescription());
		assertEquals("Fred's image",fredURL, fred.getImageURL());
		assertTrue("Student activity list should be empty",newStudentActivities.isEmpty());
	}
	/**
	 * Verifies that new activities are correctly added to the activity list
	 */
	public void testAddActivities(){
		Student fred = new Student ("Fred Flintstone",aboutFred,fredURL);
		ArrayList<String> fredActivities = null;
		
		fred.setNewActivity("Dinosaur wrangling");
		fredActivities = fred.getActivityList();
		assertEquals("Length of activity list after adding one activity",1,fredActivities.size());
		assertEquals("First activity after adding one activity","Dinosaur wrangling",fredActivities.get(0));

		fred.setNewActivity("Bone bowling");
		fredActivities = fred.getActivityList();
		assertEquals("Length of activity list after adding two activities",2,fredActivities.size());
		assertEquals("First activity after adding two activities","Dinosaur wrangling",fredActivities.get(0));
		assertEquals("Second activity after adding two activities","Bone bowling",fredActivities.get(1));
		
		fred.setNewActivity("Pterodactyl hunting");
		fredActivities = fred.getActivityList();
		assertEquals("Length of activity list after adding three activities",3,fredActivities.size());
		assertEquals("First activity after adding three activities","Dinosaur wrangling",fredActivities.get(0));
		assertEquals("Second activity after adding three activities","Bone bowling",fredActivities.get(1));
		assertEquals("Third activity after adding three activities","Pterodactyl hunting",fredActivities.get(2));
	}
	
	/**
	 * Verifies the English sentence listing the student's activities.
	 */
	public void testActivityStatement(){
		Student fred = new Student ("Fred Flintstone",aboutFred);
		assertEquals("Activities statement with 0 activities",
				"I am a complete nerd without any activities.",
				fred.getActivitiesStatement());
		
		fred.setNewActivity("badminton");
		assertEquals("Activities statement with 1 activity",
				"My favorite activity is badminton.",
				fred.getActivitiesStatement());
		
		fred.setNewActivity("swing dancing");
		assertEquals("Activities statement with 2 activities",
				"My favorite activities are badminton and swing dancing.",
				fred.getActivitiesStatement());
		
		fred.setNewActivity("skydiving");
		assertEquals("Activities statement with 3 activities",
				"My favorite activities are badminton, swing dancing, and skydiving.",
				fred.getActivitiesStatement());
		
		fred.setNewActivity("volunteering with Habitat for Humanity");
		assertEquals("Activities statement with 4 activities",
				"My favorite activities are badminton, swing dancing, skydiving, "+
		        "and volunteering with Habitat for Humanity.",
				fred.getActivitiesStatement());
	}
}
