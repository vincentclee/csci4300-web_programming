package creditcard;

public class CustomerAccount {

	public int accountNo;
	private String custName;
	private String custAddress;
	private double unpaidBalance; //possibly negative
	private double creditLimit;
	private String imageUrl; //relative ro Web URL
	public static final double DEFAULT_CREDIT_LIMIT = 1000.0;
	public static final double MAX_CREDIT_LIMIT = 10000000.0;
	
	
	public CustomerAccount(int accountNo, String custName, String custAddress, double creditLimit){
		this.accountNo = accountNo;
		this.custName = custName;
		this.custAddress = custAddress;
		this.creditLimit = creditLimit;
		
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
	 * @return the custAddress
	 */
	public String getCustAddress() {
		return custAddress;
	}
	/**
	 * @param custAddress the custAddress to set
	 */
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
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
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}
	/**
	 * @param imageUrl the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	
}
