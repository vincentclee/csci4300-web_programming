package creditcard;

import static org.junit.Assert.*;

import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;

public class PurchaseTest extends TestCase{

	@Test
	public void testPurchase() {
		Date date = new Date();
		
		Purchase instance = new Purchase(20.00, date, 1);
		assertEquals("Get amount", 20.00, instance.getAmount());
		assertEquals("Get id", 1, instance.getId());
		
		Purchase instance2 = new Purchase(200.00, date, 2);
		assertEquals("Get amount", 200.00, instance2.getAmount());
		assertEquals("Get id", 2, instance2.getId());
	}

	

}
