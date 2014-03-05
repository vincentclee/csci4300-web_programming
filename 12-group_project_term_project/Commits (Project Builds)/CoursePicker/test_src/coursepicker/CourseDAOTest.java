package coursepicker;

import java.util.LinkedHashMap;
import java.util.List;
import org.junit.Test;
import junit.framework.TestCase;

/**
 * Tests the CourseDAO class, which manages DB access for the Course Picker project
 * @author Vincent Lee
 */
public class CourseDAOTest extends TestCase {
	/**
	 * Tests that an CourseDAO object can be created
	 * @author Vincent Lee
	 */
	@Test
	public void testConstructor() {
		CourseDAO instance = new CourseDAO();
		assertNotNull("newly created CourseDAO", instance);
	}
	
	/**
	 * Tests that courses can be returned based on all 19 requirement areas.
	 * @author Vincent Lee
	 */
	@Test
	public void testListingCourses() {
		CourseDAO instance = new CourseDAO();
		LinkedHashMap<String, List<String>> map;
		
		//Classes for that are in requirement area number 1
		map = new LinkedHashMap<String, List<String>>(); //Clears the map by creating a new object. 
		map = instance.getCourseOfferingsTree(1); //Get data from CourseDAO()
		assertEquals("Getting LinkedHashMap for requirement area number 1.", false, map.isEmpty()); //Check if the map is empty.
		
		//Classes for that are in requirement area number 2
		map = new LinkedHashMap<String, List<String>>();
		map = instance.getCourseOfferingsTree(2);
		assertEquals("Getting LinkedHashMap for requirement area number 2.", false, map.isEmpty());
		
		//Classes for that are in requirement area number 3
		map = new LinkedHashMap<String, List<String>>();
		map = instance.getCourseOfferingsTree(3);
		assertEquals("Getting LinkedHashMap for requirement area number 3.", false, map.isEmpty());
		
		//Classes for that are in requirement area number 4
		map = new LinkedHashMap<String, List<String>>();
		map = instance.getCourseOfferingsTree(4);
		assertEquals("Getting LinkedHashMap for requirement area number 4.", false, map.isEmpty());
		
		//Classes for that are in requirement area number 5
		map = new LinkedHashMap<String, List<String>>();
		map = instance.getCourseOfferingsTree(5);
		assertEquals("Getting LinkedHashMap for requirement area number 5.", false, map.isEmpty());
		
		//Classes for that are in requirement area number 6
		map = new LinkedHashMap<String, List<String>>();
		map = instance.getCourseOfferingsTree(6);
		assertEquals("Getting LinkedHashMap for requirement area number 6.", false, map.isEmpty());
		
		//Classes for that are in requirement area number 7
		map = new LinkedHashMap<String, List<String>>();
		map = instance.getCourseOfferingsTree(7);
		assertEquals("Getting LinkedHashMap for requirement area number 7.", false, map.isEmpty());
		
		//Classes for that are in requirement area number 8
		map = new LinkedHashMap<String, List<String>>();
		map = instance.getCourseOfferingsTree(8);
		assertEquals("Getting LinkedHashMap for requirement area number 8.", false, map.isEmpty());
		
		//Classes for that are in requirement area number 9
		map = new LinkedHashMap<String, List<String>>();
		map = instance.getCourseOfferingsTree(9);
		assertEquals("Getting LinkedHashMap for requirement area number 9.", false, map.isEmpty());
		
		//Classes for that are in requirement area number 10
		map = new LinkedHashMap<String, List<String>>();
		map = instance.getCourseOfferingsTree(10);
		assertEquals("Getting LinkedHashMap for requirement area number 10.", false, map.isEmpty());
		
		//Classes for that are in requirement area number 11
		map = new LinkedHashMap<String, List<String>>();
		map = instance.getCourseOfferingsTree(11);
		assertEquals("Getting LinkedHashMap for requirement area number 11.", false, map.isEmpty());
		
		//Classes for that are in requirement area number 12
		map = new LinkedHashMap<String, List<String>>();
		map = instance.getCourseOfferingsTree(12);
		assertEquals("Getting LinkedHashMap for requirement area number 12.", false, map.isEmpty());
		
		//Classes for that are in requirement area number 13
		map = new LinkedHashMap<String, List<String>>();
		map = instance.getCourseOfferingsTree(13);
		assertEquals("Getting LinkedHashMap for requirement area number 13.", false, map.isEmpty());
		
		//Classes for that are in requirement area number 14
		map = new LinkedHashMap<String, List<String>>();
		map = instance.getCourseOfferingsTree(14);
		assertEquals("Getting LinkedHashMap for requirement area number 14.", false, map.isEmpty());
		
		//Classes for that are in requirement area number 15
		map = new LinkedHashMap<String, List<String>>();
		map = instance.getCourseOfferingsTree(15);
		assertEquals("Getting LinkedHashMap for requirement area number 15.", false, map.isEmpty());
		
		//Classes for that are in requirement area number 16
		map = new LinkedHashMap<String, List<String>>();
		map = instance.getCourseOfferingsTree(16);
		assertEquals("Getting LinkedHashMap for requirement area number 16.", false, map.isEmpty());
		
		//Classes for that are in requirement area number 17
		map = new LinkedHashMap<String, List<String>>();
		map = instance.getCourseOfferingsTree(17);
		assertEquals("Getting LinkedHashMap for requirement area number 17.", false, map.isEmpty());
		
		//Classes for that are in requirement area number 18
		map = new LinkedHashMap<String, List<String>>();
		map = instance.getCourseOfferingsTree(18);
		assertEquals("Getting LinkedHashMap for requirement area number 18.", false, map.isEmpty());
		
		//Classes for that are in requirement area number 19
		map = new LinkedHashMap<String, List<String>>();
		map = instance.getCourseOfferingsTree(19);
		assertEquals("Getting LinkedHashMap for requirement area number 19.", false, map.isEmpty());
	}
}