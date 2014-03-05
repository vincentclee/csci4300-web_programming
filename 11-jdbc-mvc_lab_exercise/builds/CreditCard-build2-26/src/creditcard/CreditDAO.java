package creditcard;

import java.util.ArrayList;

/**
 * Handles database access for the Credit Card project
 *
 */
public class CreditDAO {

	//TODO: declare PreparedStatements
	/**
	 * Connect to DB and create PreparedStatements
	 */
	public CreditDAO(){
		//TODO: implement constructor
	}
	/**
	 * Adds a new record to the Customer table
	 */
	public void addCustomer(String custName, String custAddress,
			String imageURL,double creditLimit){
		//TODO: implement addCustomer method
	}
	/**
	 * Returns a list of all Customers in the Customer table, but without embedded
	 * Purchases
	 */
	public ArrayList<CustomerAccount> getCustomerList(){
		//TODO: remove stub return and implement getCustomerList
		return null;
	}
	/**
	 * Returns the Customer with account no 'id', including the list
	 * of Purchases
	 */
	public CustomerAccount getCustomer(int id){
		//TODO: remove stub return and implement getCustomer
				return null;
	}
	/**
	 * Adds a Purchase to 'account' with purchase date the present moment.
	 * If the purchase would put 'account' over its credit limit, does not
	 * add the Purchase but sets the error message of 'account'.
	 */
	public void addPurchase (String merchantName, String merchantCity,
			String merchantState, double purchaseAmount){
		//TODO: add purchase
		
	}
}
