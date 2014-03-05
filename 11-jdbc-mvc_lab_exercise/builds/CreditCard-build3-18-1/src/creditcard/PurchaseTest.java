/**
 * Test code for Credit Card project testing Purchase
 * @author Vincent Lee
 * @author Meghan Redwine
 */

package creditcard;


import junit.framework.TestCase;
import org.junit.Test;
import java.sql.Timestamp;

public class PurchaseTest extends TestCase {

	/**
	  * Test that adding a purchases
	  */
	@Test
	public void testPurchase() {
		//Test add purchase 1
		Purchase instance = new Purchase("Apple Inc.", "Cupertino", "CA", new Timestamp(System.currentTimeMillis()), 2799.00);
		assertEquals("first add purchase merchant name", "Apple Inc.", instance.getMerchantName());
		assertEquals("first add purchase merchant city", "Cupertino", instance.getMerchantCity());
		assertEquals("first add state", "CA", instance.getMerchantState());
		assertEquals("first add purchase amount", 2799.00, instance.getPurchaseAmount());
		
		//Test add purchase 2
		Purchase instance1 = new Purchase("Amazon.com, Inc.", "Seattle", "WA", new java.sql.Timestamp(System.currentTimeMillis()), 35000.95);
		assertEquals("second add purchase merchant name", "Amazon.com, Inc.", instance1.getMerchantName());
		assertEquals("second add purchase merchant city", "Seattle", instance1.getMerchantCity());
		assertEquals("second add state", "WA", instance1.getMerchantState());
		assertEquals("second add purchase amount", 35000.95, instance1.getPurchaseAmount());
		
		//Test add purchase 3
		Purchase instance2 = new Purchase("Office Depot Inc.", "Boca Raton", "FL", new java.sql.Timestamp(System.currentTimeMillis()), 9950.45);
		assertEquals("third add purchase merchant name", "Office Depot Inc.", instance2.getMerchantName());
		assertEquals("third add purchase merchant city", "Boca Raton", instance2.getMerchantCity());
		assertEquals("third add state", "FL", instance2.getMerchantState());
		assertEquals("third add purchase amount", 9950.45, instance2.getPurchaseAmount());
		
		//Test add purchase 4
		Purchase instance3 = new Purchase("McDonald's Corporation", "Oak Brook", "IL", new java.sql.Timestamp(System.currentTimeMillis()), 3.07);
		assertEquals("fourth add purchase merchant name", "McDonald's Corporation", instance3.getMerchantName());
		assertEquals("fourth add purchase merchant city", "Oak Brook", instance3.getMerchantCity());
		assertEquals("fourth add state", "IL", instance3.getMerchantState());
		assertEquals("fourth add purchase amount", 3.07, instance3.getPurchaseAmount());
		
		//Test add purchase 5
		Purchase instance4 = new Purchase("Wendy's", "Dublin", "OH", new java.sql.Timestamp(System.currentTimeMillis()), 1.89);
		assertEquals("fifth add purchase merchant name", "Wendy's", instance4.getMerchantName());
		assertEquals("fifth add purchase merchant city", "Dublin", instance4.getMerchantCity());
		assertEquals("fifth add state", "OH", instance4.getMerchantState());
		assertEquals("fifth add purchase amount", 1.89, instance4.getPurchaseAmount());
		
		//Test add purchase 6
		Purchase instance5 = new Purchase("Chick-fil-A", "College Park", "GA", new java.sql.Timestamp(System.currentTimeMillis()), 4.53);
		assertEquals("sixth add purchase merchant name", "Chick-fil-A", instance5.getMerchantName());
		assertEquals("sixth add purchase merchant city", "College Park", instance5.getMerchantCity());
		assertEquals("sixth add state", "GA", instance5.getMerchantState());
		assertEquals("sixth add purchase amount", 4.53, instance5.getPurchaseAmount());
	}
}
