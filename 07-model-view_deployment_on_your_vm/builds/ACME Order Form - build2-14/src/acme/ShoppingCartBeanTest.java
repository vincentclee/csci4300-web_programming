package acme;

import junit.framework.TestCase;

public class ShoppingCartBeanTest extends TestCase {
	public void testConstructor() {
		new ShoppingCartBean();
	}
	
	public void testAddItems() {
		ShoppingCartBean instance1 = new ShoppingCartBean();
		instance1.setItemID(0);
		instance1.setQuantity("3");
		instance1.getCart();
		
		LineItem testItem = instance1.getCart().get(0);
		
		assertEquals("Instance 1 LineItem 1 id", 0, testItem.getItemID());
		assertEquals("Instance 1 LineItem 1 quantity", 3, testItem.getQuantity());
		assertEquals("Instance 1 LineItem 1 description", "Rocket-powered Roller Skates", testItem.getDescription());
		
		instance1.setItemID(1);
		instance1.setQuantity("4");
		assertEquals("Instance 1 LineItem 2 id", 1, instance1.getCart().get(1).getItemID());
		assertEquals("Instance 1 LineItem 2 quantity", 4, instance1.getCart().get(1).getQuantity());
		assertEquals("Instance 1 LineItem 2 description", "Exploding tennis balls, case", instance1.getCart().get(1).getDescription());
		
		instance1.setItemID(2);
		instance1.setQuantity("5");
		assertEquals("Instance 1 LineItem 3 id", 2, instance1.getCart().get(2).getItemID());
		assertEquals("Instance 1 LineItem 3 quantity", 5, instance1.getCart().get(2).getQuantity());
		assertEquals("Instance 1 LineItem 3 description", "Dehydrated boulder", instance1.getCart().get(2).getDescription());
		
		instance1.setItemID(3);
		instance1.setQuantity("6");
		assertEquals("Instance 1 LineItem 4 id", 3, instance1.getCart().get(3).getItemID());
		assertEquals("Instance 1 LineItem 4 quantity", 6, instance1.getCart().get(3).getQuantity());
		assertEquals("Instance 1 LineItem 4 description", "Earthquake Pill, bottle of 12", instance1.getCart().get(3).getDescription());
		
		instance1.setItemID(4);
		instance1.setQuantity("7");
		assertEquals("Instance 1 LineItem 5 id", 4, instance1.getCart().get(4).getItemID());
		assertEquals("Instance 1 LineItem 5 quantity", 7, instance1.getCart().get(4).getQuantity());
		assertEquals("Instance 1 LineItem 5 description", "Batman Outfit", instance1.getCart().get(4).getDescription());
		
		instance1.setItemID(5);
		instance1.setQuantity("8");
		assertEquals("Instance 1 LineItem 6 id", 5, instance1.getCart().get(5).getItemID());
		assertEquals("Instance 1 LineItem 6 quantity", 8, instance1.getCart().get(5).getQuantity());
		assertEquals("Instance 1 LineItem 6 description", "Catapult", instance1.getCart().get(5).getDescription());
	}
}
