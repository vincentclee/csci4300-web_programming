package creditcard;


import org.junit.Test;

import junit.framework.TestCase;

public class CustomerAccountTest extends TestCase {

	@Test
	public void testConstructor() {
	  CustomerAccount instance1 = new CustomerAccount (1, "Gordon Gecko", "1 Wall Street, NYC",
			  10000000);
	  assertEquals("instance 1 id",1,instance1.getAccountNo());
	  assertEquals("instance 1 customer name","Gordon Gecko",instance1.getCustName());
	  assertEquals("instance 1 customer address","1 Wall Street, NYC",instance1.getCustAddress());
	  assertEquals("instance 1 image URL",null,instance1.getImageUrl());
	  assertEquals("instance 1 error msg","",instance1.getErrorMessage());
	  assertEquals("instance 1 unpaid balance",0.0,instance1.getUnpaidBalance(),0.001);
	  assertEquals("instance 1 credit limit",10000000.0,instance1.getCreditLimit(),0.001);
	  
	  //Account with default credit limit
	  CustomerAccount instance2 = new CustomerAccount (2, "Fred Freekowtski", "22 Slum St");
	  assertEquals("instance 2 id",2,instance2.getAccountNo());
	  assertEquals("instance 2 customer name","Fred Freekowtski",instance2.getCustName());
	  assertEquals("instance 2 customer address","22 Slum St",instance2.getCustAddress());
	  assertEquals("instance 2 image URL",null,instance2.getImageUrl());
	  assertEquals("instance 2 error msg","",instance1.getErrorMessage());
	  assertEquals("instance 2 unpaid balance",0.0,instance2.getUnpaidBalance(),0.001);
	  assertEquals("instance 2 credit limit",1000.0,instance2.getCreditLimit(),0.001);
	}

	 /**
	  * Test that adding a purchase increases the unpaid balance, UNLESS the purchase
	  * would put the unpaid balance above the credit limit. Also test the error conditions
	  */
	  @Test
	  public void testAddPurchase() {
		  CustomerAccount instance = new CustomerAccount (2, "Fred Freekowtski", "22 Slum St");
		  boolean addPurchaseResult1 = instance.addPurchase(null);
		  assertEquals("null purchase result", true, addPurchaseResult1);
		  assertEquals("null purchase unpaid balance",0.00, instance.getUnpaidBalance(),0.001);
		  assertEquals("null purchase error message","", instance.getErrorMessage());
		  
		  boolean addPurchaseResult2 = instance.addPurchase("");
		  assertEquals("empty purchase result", false, addPurchaseResult2);
		  assertEquals("empty purchase unpaid balance",0.00, instance.getUnpaidBalance(),0.001);
		  assertEquals("empty purchase error message","Please enter a purchase amount", instance.getErrorMessage());
		/*
		  Add this later when we can handle Exceptions
		 
		  boolean addPurchaseResult3 = instance.addPurchase("$25.00");
		  assertEquals("non-numeric purchase result", false, addPurchaseResult3);
		  assertEquals("non-numeric purchase unpaid balance",0.00, instance.getUnpaidBalance(),0.001);
		  assertEquals("non-numeric purchase error message","Purchase amount must be numeric", instance.getErrorMessage());
		  */
		  boolean addPurchaseResult4 = instance.addPurchase("-25");
		  assertEquals("negative purchase result", false, addPurchaseResult4);
		  assertEquals("negative purchase unpaid balance",0.00, instance.getUnpaidBalance(),0.001);
		  assertEquals("negative purchase error message","Purchase amount must be positive", instance.getErrorMessage());
	
		  boolean addPurchaseResult5 = instance.addPurchase("300");
		  assertEquals("first purchase result", true, addPurchaseResult5);
		  assertEquals("first purchase unpaid balance",300.00, instance.getUnpaidBalance());
		  assertEquals("first purchase error message","", instance.getErrorMessage());
		  
		  boolean addPurchaseResult6 = instance.addPurchase("500");
		  assertEquals("second purchase result", true, addPurchaseResult6);
		  assertEquals("second purchase unpaid balance",800.00, instance.getUnpaidBalance());
		  assertEquals("second purchase error message","", instance.getErrorMessage());
		  
		  boolean addPurchaseResult7 = instance.addPurchase("300");
		  assertEquals("third purchase result", false, addPurchaseResult7);
		  assertEquals("third purchase unpaid balance",800.00, instance.getUnpaidBalance());
		  assertEquals("third purchase error message","Amount exceeds your credit limit, sorry", instance.getErrorMessage());
	  }
}
