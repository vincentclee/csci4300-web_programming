package coursepicker;


import org.junit.Test;
import junit.framework.TestCase;

public class CourseDAOTest extends TestCase {

	/**
	 * @author Vincent Lee
	 */
	@Test
	public void testConstructor() {
		CourseDAO instance = new CourseDAO();
		assertNotNull("newly created classUpdater", instance);
	}
	
	/**
	 * @author Vincent Lee
	 */
	@Test
	public void testListing() {
		CourseDAO instance = new CourseDAO();
		instance.getCourseOfferingsTree(8);

		
		
		
	}

}
