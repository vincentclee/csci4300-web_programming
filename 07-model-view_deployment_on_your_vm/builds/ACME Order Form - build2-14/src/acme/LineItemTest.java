package acme;

import junit.framework.TestCase;

public class LineItemTest extends TestCase {
	
	public void testConstructor() {
		LineItem instance0 = new LineItem(0, 535);
		assertEquals("Instance 0 id", 0, instance0.getItemID());
		assertEquals("Instance 0 quantity", 535, instance0.getQuantity());
		assertEquals("Instance 0 description", "Rocket-powered Roller Skates", instance0.getDescription());
		
		LineItem instance1 = new LineItem(1, 663);
		assertEquals("Instance 1 id", 1, instance1.getItemID());
		assertEquals("Instance 1 quantity", 663, instance1.getQuantity());
		assertEquals("Instance 1 description", "Exploding tennis balls, case", instance1.getDescription());
		
		LineItem instance2 = new LineItem(2, 2342);
		assertEquals("Instance 2 id", 2, instance2.getItemID());
		assertEquals("Instance 2 quantity", 2342, instance2.getQuantity());
		assertEquals("Instance 2 description", "Dehydrated boulder", instance2.getDescription());
		
		LineItem instance3 = new LineItem(3, 11);
		assertEquals("Instance 3 id", 3, instance3.getItemID());
		assertEquals("Instance 3 quantity", 11, instance3.getQuantity());
		assertEquals("Instance 3 description", "Earthquake Pill, bottle of 12", instance3.getDescription());
		
		LineItem instance4 = new LineItem(4, 86);
		assertEquals("Instance 4 id", 4, instance4.getItemID());
		assertEquals("Instance 4 quantity", 86, instance4.getQuantity());
		assertEquals("Instance 4 description", "Batman Outfit", instance4.getDescription());
		
		LineItem instance5 = new LineItem(5, 23);
		assertEquals("Instance 5 id", 5, instance5.getItemID());
		assertEquals("Instance 5 quantity", 23, instance5.getQuantity());
		assertEquals("Instance 5 description", "Catapult", instance5.getDescription());
	}

}
