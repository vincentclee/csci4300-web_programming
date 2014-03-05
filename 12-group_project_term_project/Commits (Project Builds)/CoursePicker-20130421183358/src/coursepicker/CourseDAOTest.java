package coursepicker;


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
		instance.getCourseOfferingsTree(1);

		
		
		
	}

}
