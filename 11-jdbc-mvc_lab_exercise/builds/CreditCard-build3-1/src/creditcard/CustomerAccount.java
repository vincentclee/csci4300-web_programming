/**
 * CustomerAccount tracks the unpaid balance as the customer makes purchases.
 * Implements a Bean interface.
 * @author Vincent Lee
 * @author Meghan Redwine
 */

package creditcard;

import java.util.ArrayList;

public class CustomerAccount {
	/** Unique account number */
	public int accountNo;
	/** Customer name */
	private String custName;
	/** Customer address*/
	private String custAddr;
	/** Unpaid balance, can be negative */
	private double unpaidBalance;
	/** 
	 * Credit limit; purchases that would make the
	 * unpaid balance exceed this limit are rejected 
	 */
	private double creditLimit;
	/** URL for customer image, either relative or on the Web */
	private String imageURL;
	/** DEFAULT INITIAL CREDIT LIMIT FOR NEW ACCOUNT */
	public static final double DEFAULT_CREDIT_LIMIT = 1000.0;
	/** MAXIMUM CREDIT LIMIT FOR ANY ACCOUNT */
	public static final double MAX_CREDIT_LIMIT = 10000000.0;
	/** Error message to be displayed in case of user error */
	private String errorMessage;
	/** ArrayList of purchases for this account */
	private ArrayList<Purchase> purchases;

	/**
	 * Creates a new account.
	 * @param accountNo account number for new account
	 * @param custName new account customer name
	 * @param custAddr new account customer address
	 * @param creditLimit new account credit limit
	 * @param unpaidBalance new account customer unpaidBalance
	 * @param imageURL new account customer imageURL
	 * @param purchases new account purchases
	 */
	public CustomerAccount(int accountNo, String custName, String custAddr, double creditLimit, double unpaidBalance, String imageURL, ArrayList<Purchase> purchases) {
		this.accountNo = accountNo;
		this.custName = custName;
		this.custAddr = custAddr;
		this.creditLimit = creditLimit;
		this.imageURL = imageURL;
		this.unpaidBalance = unpaidBalance;
		this.errorMessage = "";
		this.purchases = purchases;
	}
	
	/**
	 * Creates a new account.
	 * @param accountNo account number for new account
	 * @param custName new account customer name
	 * @param custAddr new account customer address
	 * @param creditLimit new account credit limit
	 * @param unpaidBalance new account customer unpaidBalance
	 * @param imageURL new account customer imageURL
	 */
	public CustomerAccount(int accountNo, String custName, String custAddr, double creditLimit, double unpaidBalance, String imageURL) {
		this.accountNo = accountNo;
		this.custName = custName;
		this.custAddr = custAddr;
		this.creditLimit = creditLimit;
		this.imageURL = imageURL;
		this.unpaidBalance = unpaidBalance;
		this.errorMessage = "";
	}
	
	/**
	 * Creates a new account with zero balance and no image.
	 * @param accountNo account number for new account
	 * @param custName new account customer name
	 * @param custAddr new account customer address
	 * @param creditLimit new account credit limit
	 */
	public CustomerAccount(int accountNo, String custName, String custAddr, double creditLimit) {
		this.accountNo = accountNo;
		this.custName = custName;
		this.custAddr = custAddr;
		this.creditLimit = creditLimit;
		this.imageURL = null;
		this.unpaidBalance = 0;
		this.errorMessage = "";
	}

	/**
	 * Creates a new account with zero balance, no image, and the default credit limit
	 * @param newAccounto accountNo for new account
	 * @param newCustName new account customer name
	 * @param newCustAddr new account customer address
	 */
	public CustomerAccount(int accountNo, String custName, String custAddr) {
		this(accountNo, custName, custAddr, DEFAULT_CREDIT_LIMIT);
		errorMessage = "";
	}

	/**
	 * Default Constructor following the rule: Bean classes must have a no-arg constructor
	 */
	public CustomerAccount() {
		creditLimit = DEFAULT_CREDIT_LIMIT;
		errorMessage = "";
	}
	
	/**
	 * Adds 'purchaseAmount' to 'unpaidBalance'.
	 * Detects over credit limit errors and reports.
	 * Takes in String and parses to double to deal with erroneous input like letters
	 * purchaseAmount = Amount of a new purchase to be added to this account
	 * If the transaction was completed, true is returned.
	 */
	public boolean addPurchase(String purchaseAmt) {
		double purchaseAmount;
	
		try {
			purchaseAmount = Double.parseDouble(purchaseAmt);
//			Date date = new Date();
//			int id = purchases.size();
//			Purchase purchase = new Purchase(purchaseAmount, date, id);
//			purchases.add(purchase);
		} catch(Exception e) {
			purchaseAmount = 0;
			errorMessage = "Error: Purchase amount must be numeric";
			return false;
		}
		if (purchaseAmount+unpaidBalance > creditLimit) {
			errorMessage = "Error: Amount exceeds your credit limit, sorry";
		} else if (purchaseAmount < 0.00) {
			errorMessage = "Error: Purchase amount must be positive";
		} else if (purchaseAmount == 0) {
			errorMessage = "Error: Please enter a purchase amount";
		}
		else {
			unpaidBalance += purchaseAmount;
			errorMessage = "";
			return true;
		}
		return false;
	}
	
	/**
	 * @return the purchases
	 */
	public ArrayList<Purchase> getPurchases() {
		return purchases;
	}

	/**
	 * @param purchases the purchases to set
	 */
	public void setPurchases(ArrayList<Purchase> purchases) {
		this.purchases = purchases;
	}

	/**
	 * The method getErrorMessage returns an error message
	 * @return errorMessage which contains a String message
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	
	/**
	 * Adds 'purchaseAmount to 'unpaidBalance', or sets 'error' if 
	 * the purchase would result in 'unpaidBalance' exceeding credit limit.
	 * @param purchaseAmount The double amount in dollars.
	 */
	public void setPurchaseAmount(String purchaseAmount) {
		addPurchase(purchaseAmount);
		System.out.println("Customer account: adding purchase $" + purchaseAmount);
	}
	
	/**
	 * @return the accountNo
	 */
	public int getAccountNo() {
		return accountNo;
	}
	
	/**
	 * @param accountNo the accountNo to set
	 */
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
		System.out.println("Customer account: setting account number to " + accountNo);
	}
	
	/**
	 * @return the custName
	 */
	public String getCustName() {
		return custName;
	}
	
	/**
	 * @param custName the custName to set
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	/**
	 * @return the custAddr
	 */
	public String getCustAddr() {
		return custAddr;
	}
	
	/**
	 * @param custAddr the custAddr to set
	 */
	public void setCustAddr(String custAddr) {
		this.custAddr = custAddr;
	}
	
	/**
	 * @return the unpaidBalance
	 */
	public double getUnpaidBalance() {
		return unpaidBalance;
	}
	
	/**
	 * @param unpaidBalance the unpaidBalance to set
	 */
	public void setUnpaidBalance(double unpaidBalance) {
		this.unpaidBalance = unpaidBalance;
	}
	
	/**
	 * @return the creditLimit
	 */
	public double getCreditLimit() {
		return creditLimit;
	}
	
	/**
	 * @param creditLimit the creditLimit to set
	 */
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}
	
	/**
	 * @return the imageURL
	 */
	public String getImageURL() {
		return imageURL;
	}
	
	/**
	 * @param imageURL the imageUrl to set
	 */
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
}
