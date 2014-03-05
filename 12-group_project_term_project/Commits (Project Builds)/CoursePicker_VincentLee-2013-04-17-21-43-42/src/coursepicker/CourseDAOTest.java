package coursepicker;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Test;
import junit.framework.TestCase;

public class CourseDAOTest extends TestCase {

	@Test
	public void testConstructor() {
		CourseDAO instance = new CourseDAO();
		assertNotNull("newly created classUpdater", instance);
	}
	
	@Test
	public void testListing() {
		CourseDAO instance = new CourseDAO();
		instance.getCourseOfferingsTree(19);

		
		
		
	}

}
