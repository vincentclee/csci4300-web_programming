import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;


public class LineItemTest extends TestCase {

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	public void testConstructor() {
		LineItem instance1 = new LineItem(0, 3);
		assertEquals("Instance 1 id", 0, instance1.getID());
		
	}

}
