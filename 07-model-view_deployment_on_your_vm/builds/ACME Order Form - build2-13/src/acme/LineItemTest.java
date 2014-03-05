package acme;

import junit.framework.TestCase;

public class LineItemTest extends TestCase {
	
	public void testConstructor() {
		LineItem instance1 = new LineItem(0, 3);
		assertEquals("Instance 1 id", 0, instance1.getItemID());
		assertEquals("Instance 1 description", "Rocket-powered Roller Skates", instance1.getDescription());
	}

}
