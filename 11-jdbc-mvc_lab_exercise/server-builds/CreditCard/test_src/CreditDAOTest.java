/**
 * Tests the CreditDAO class, which manages DB access for the Credit Card project
 * @author Vincent Lee
 * @author Meghan Redwine
 */

package creditcard;

import java.util.ArrayList;
import org.junit.Test;
import junit.framework.TestCase;

public class CreditDAOTest extends TestCase {
	
	@Test
	/**
	 * Tests that an object can be created
	 */
	public void testConstructor() {
		CreditDAO instance = new CreditDAO();
		assertNotNull("newly created CreditDAO", instance);
	}
	
	/**
	 * Tests creating accounts
	 */
	@Test
	public void testCreate(){
		CreditDAO instance = new CreditDAO();
		
		//Clear the Customer table of all entries.
		instance.clearPurchases();
		instance.clearCustomers();
		
		//add first customer
		instance.addCustomer("Gordon Gecko", "1 Wall St, NYC", null, 10000000.0);
		ArrayList<CustomerAccount> acctList = instance.getCustomerList();
		assertEquals("number of customers after one addition", 1, acctList.size());
		CustomerAccount acct0 = acctList.get(0);
		assertEquals("First cust name after one addition", "Gordon Gecko", acct0.getCustName());
		assertEquals("First cust address after one addition", "1 Wall St, NYC", acct0.getCustAddr());
		assertEquals("First cust image url after one addition", null, acct0.getImageURL());
		assertEquals("First cust unpaid balance after one addition", 0.0, acct0.getUnpaidBalance(), 0.001);
		assertEquals("First cust credit limit after one addition", 10000000.0, acct0.getCreditLimit(), 0.001);
		
		//add second customer
		instance.addCustomer("Fred Freekowtski", "22 Slum St, Oakland CA", "http://ecx.images-amazon.com/images/I/61zenAO2uOL._SL500_SS500_.jpg", 50.0);
		acctList = instance.getCustomerList();
		assertEquals("number of customers after two additions", 2, acctList.size());
	    acct0 = acctList.get(0);
		assertEquals("First cust name after two additions", "Gordon Gecko", acct0.getCustName());
		assertEquals("First cust address after two additions", "1 Wall St, NYC", acct0.getCustAddr());
		assertEquals("First cust image url after two additions", null, acct0.getImageURL());
		assertEquals("First cust unpaid balance after two additions", 0.0, acct0.getUnpaidBalance(), 0.001);
		assertEquals("First cust credit limit after two additions", 10000000.0, acct0.getCreditLimit(), 0.001);
		assertEquals("number of customers after two additions", 2, acctList.size());
		
	    CustomerAccount acct1 = acctList.get(1);
		assertEquals("Second cust name after two additions", "Fred Freekowtski", acct1.getCustName());
		assertEquals("Second cust address after two additions", "22 Slum St, Oakland CA", acct1.getCustAddr());
		assertEquals("Second cust image url after two additions", "http://ecx.images-amazon.com/images/I/61zenAO2uOL._SL500_SS500_.jpg", acct1.getImageURL());
		assertEquals("Second cust unpaid balance after two additions", 0.0, acct0.getUnpaidBalance(), 0.001);
		assertEquals("Second cust credit limit after two additions", 50.0, acct1.getCreditLimit(), 0.001);
		
		//add third customer
		instance.addCustomer("Kevin O'Leary", "Montreal, Quebec, CA", "http://oi47.tinypic.com/miezig.jpg", 300000000.0);
		acctList = instance.getCustomerList();
		assertEquals("number of customers after three additions", 3, acctList.size());
		CustomerAccount acct2 = acctList.get(2);
		assertEquals("Third cust name after three additions", "Kevin O'Leary", acct2.getCustName());
		assertEquals("Third cust address after three additions", "Montreal, Quebec, CA", acct2.getCustAddr());
		assertEquals("Third cust image url after three additions", "http://oi47.tinypic.com/miezig.jpg", acct2.getImageURL());
		assertEquals("Third cust unpaid balance after three additions", 0.0, acct2.getUnpaidBalance(), 0.001);
		assertEquals("Third cust credit limit after three additions", 300000000.0, acct2.getCreditLimit(), 0.001);
		assertEquals("number of customers after three additions", 3, acctList.size());
		
		//add fourth customer
		instance.addCustomer("Mark Cuban", "Pittsburgh, Pennsylvania", "http://media.zenfs.com/en_ca/News/AccessHollywood/174036.jpg", 2300000000.0);
		acctList = instance.getCustomerList();
		assertEquals("number of customers after four additions", 4, acctList.size());
		CustomerAccount acct3 = acctList.get(3);
		assertEquals("Third cust name after four additions", "Mark Cuban", acct3.getCustName());
		assertEquals("Third cust address after four additions", "Pittsburgh, Pennsylvania", acct3.getCustAddr());
		assertEquals("Third cust image url after four additions", "http://media.zenfs.com/en_ca/News/AccessHollywood/174036.jpg", acct3.getImageURL());
		assertEquals("Third cust unpaid balance after four additions", 0.0, acct3.getUnpaidBalance(), 0.001);
		assertEquals("Third cust credit limit after four additions", 2300000000.0, acct3.getCreditLimit(), 0.001);
		assertEquals("number of customers after four additions", 4, acctList.size());
	}
	
	/**
	 * Tests adding purchases
	 */
	@Test
	public void testPurchases() {
		
		CreditDAO instance = new CreditDAO();
		
		//Add purchases to Customer 1
		CustomerAccount account = instance.getCustomer(1);
		assertEquals("Initial purchases list size for Purchase Customer 1", 0, account.getPurchases().size());
				
		instance.addPurchase("Apple Inc.", "Cupertino", "CA", 2799.00, 1);
		account = instance.getCustomer(1);
		assertEquals("Purchase list size after one addition", 1, account.getPurchases().size());
		assertEquals("First purchase merchant name", "Apple Inc.", account.getPurchases().get(0).getMerchantName());
		assertEquals("First purchase merchant city", "Cupertino", account.getPurchases().get(0).getMerchantCity());
		assertEquals("First purchase merchant state", "CA", account.getPurchases().get(0).getMerchantState());
		assertEquals("First purchase amount", 2799.00, account.getPurchases().get(0).getPurchaseAmount());
		
		instance.addPurchase("Amazon.com, Inc.", "Seattle", "WA", 35000.95, 1);
		account = instance.getCustomer(1);
		assertEquals("Purchase list size after another addition", 2, account.getPurchases().size());
		assertEquals("Another purchase merchant name", "Amazon.com, Inc.", account.getPurchases().get(1).getMerchantName());
		assertEquals("Another purchase merchant city", "Seattle", account.getPurchases().get(1).getMerchantCity());
		assertEquals("Another purchase merchant state", "WA", account.getPurchases().get(1).getMerchantState());
		assertEquals("Another purchase amount", 35000.95, account.getPurchases().get(1).getPurchaseAmount());
		
		instance.addPurchase("Office Depot Inc.", "Boca Raton", "FL", 9950.45, 1);
		account = instance.getCustomer(1);
		assertEquals("Purchase list size after another addition", 3, account.getPurchases().size());
		assertEquals("Another purchase merchant name", "Office Depot Inc.", account.getPurchases().get(2).getMerchantName());
		assertEquals("Another purchase merchant city", "Boca Raton", account.getPurchases().get(2).getMerchantCity());
		assertEquals("Another purchase merchant state", "FL", account.getPurchases().get(2).getMerchantState());
		assertEquals("Another purchase amount", 9950.45, account.getPurchases().get(2).getPurchaseAmount());
		
		//Add purchases to Customer 2
		CustomerAccount account1 = instance.getCustomer(2);
		assertEquals("Initial purchases list size for Purchase Customer 2", 0, account1.getPurchases().size());
				
		instance.addPurchase("McDonald's Corporation", "Oak Brook", "IL", 3.07, 2);
		account1 = instance.getCustomer(2);
		assertEquals("Purchase list size after one addition", 1, account1.getPurchases().size());
		assertEquals("First purchase merchant name", "McDonald's Corporation", account1.getPurchases().get(0).getMerchantName());
		assertEquals("First purchase merchant city", "Oak Brook", account1.getPurchases().get(0).getMerchantCity());
		assertEquals("First purchase merchant state", "IL", account1.getPurchases().get(0).getMerchantState());
		assertEquals("First purchase amount", 3.07, account1.getPurchases().get(0).getPurchaseAmount());
		
		instance.addPurchase("Wendy's", "Dublin", "OH", 1.89, 2);
		account1 = instance.getCustomer(2);
		assertEquals("Purchase list size after another addition", 2, account1.getPurchases().size());
		assertEquals("Another purchase merchant name", "Wendy's", account1.getPurchases().get(1).getMerchantName());
		assertEquals("Another purchase merchant city", "Dublin", account1.getPurchases().get(1).getMerchantCity());
		assertEquals("Another purchase merchant state", "OH", account1.getPurchases().get(1).getMerchantState());
		assertEquals("Another purchase amount", 1.89, account1.getPurchases().get(1).getPurchaseAmount());
		
		instance.addPurchase("Chick-fil-A", "College Park", "GA", 4.53, 2);
		account1 = instance.getCustomer(2);
		assertEquals("Purchase list size after another addition", 3, account1.getPurchases().size());
		assertEquals("Another purchase merchant name", "Chick-fil-A", account1.getPurchases().get(2).getMerchantName());
		assertEquals("Another purchase merchant city", "College Park", account1.getPurchases().get(2).getMerchantCity());
		assertEquals("Another purchase merchant state", "GA", account1.getPurchases().get(2).getMerchantState());
		assertEquals("Another purchase amount", 4.53, account1.getPurchases().get(2).getPurchaseAmount());
		
		//Add purchases to Customer 3
		CustomerAccount account2 = instance.getCustomer(3);
		assertEquals("Initial purchases list size for Purchase Customer 3", 0, account2.getPurchases().size());
		
		instance.addPurchase("Automobili Lamborghini S.p.A.", "Sant'Agata Bolognese", "--", 441600.0, 3);
		account2 = instance.getCustomer(3);
		assertEquals("Purchase list size after one addition", 1, account2.getPurchases().size());
		assertEquals("First purchase merchant name", "Automobili Lamborghini S.p.A.", account2.getPurchases().get(0).getMerchantName());
		assertEquals("First purchase merchant city", "Sant'Agata Bolognese", account2.getPurchases().get(0).getMerchantCity());
		assertEquals("First purchase merchant state", "--", account2.getPurchases().get(0).getMerchantState());
		assertEquals("First purchase amount", 441600.0, account2.getPurchases().get(0).getPurchaseAmount());
		
		instance.addPurchase("Gulfstream Aerospace", "Savannah", "GA", 64500000.0, 3);
		account2 = instance.getCustomer(3);
		assertEquals("Purchase list size after another addition", 2, account2.getPurchases().size());
		assertEquals("Another purchase merchant name", "Gulfstream Aerospace", account2.getPurchases().get(1).getMerchantName());
		assertEquals("Another purchase merchant city", "Savannah", account2.getPurchases().get(1).getMerchantCity());
		assertEquals("Another purchase merchant state", "GA", account2.getPurchases().get(1).getMerchantState());
		assertEquals("Another purchase amount", 64500000.0, account2.getPurchases().get(1).getPurchaseAmount());
		
		instance.addPurchase("Ferrari S.p.A.", "Maranello", "--", 659330.0, 3);
		account2 = instance.getCustomer(3);
		assertEquals("Purchase list size after another addition", 3, account2.getPurchases().size());
		assertEquals("Another purchase merchant name", "Ferrari S.p.A.", account2.getPurchases().get(2).getMerchantName());
		assertEquals("Another purchase merchant city", "Maranello", account2.getPurchases().get(2).getMerchantCity());
		assertEquals("Another purchase merchant state", "--", account2.getPurchases().get(2).getMerchantState());
		assertEquals("Another purchase amount", 659330.0, account2.getPurchases().get(2).getPurchaseAmount());
		
		//Add purchases to Customer 4
		CustomerAccount account3 = instance.getCustomer(4);
		assertEquals("Initial purchases list size for Purchase Customer 4", 0, account3.getPurchases().size());
		
		instance.addPurchase("Gulfstream Aerospace", "Savannah", "GA", 40000000.0, 4);
		account3 = instance.getCustomer(4);
		assertEquals("Purchase list size after one addition", 1, account3.getPurchases().size());
		assertEquals("First purchase merchant name", "Gulfstream Aerospace", account3.getPurchases().get(0).getMerchantName());
		assertEquals("First purchase merchant city", "Savannah", account3.getPurchases().get(0).getMerchantCity());
		assertEquals("First purchase merchant state", "GA", account3.getPurchases().get(0).getMerchantState());
		assertEquals("First purchase amount", 40000000.0, account3.getPurchases().get(0).getPurchaseAmount());
		
		instance.addPurchase("NBA Dallas Mavericks", "Dallas", "TX", 285000000.0, 4);
		account3 = instance.getCustomer(4);
		assertEquals("Purchase list size after another addition", 2, account3.getPurchases().size());
		assertEquals("Another purchase merchant name", "NBA Dallas Mavericks", account3.getPurchases().get(1).getMerchantName());
		assertEquals("Another purchase merchant city", "Dallas", account3.getPurchases().get(1).getMerchantCity());
		assertEquals("Another purchase merchant state", "TX", account3.getPurchases().get(1).getMerchantState());
		assertEquals("Another purchase amount", 285000000.0, account3.getPurchases().get(1).getPurchaseAmount());
	}
}
