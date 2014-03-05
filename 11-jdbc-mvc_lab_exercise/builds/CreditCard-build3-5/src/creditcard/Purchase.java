/**
 * Purchase class will be a data transfer object representing purchases.
 * @author Vincent Lee
 * @author Meghan Redwine
 */

package creditcard;

import java.sql.Timestamp;

public class Purchase {
	private String merchantName, merchantCity, merchantState;
	private Timestamp purchaseDate;
	private double purchaseAmount;
	
	/**
	 * Constructor which sets everything.
	 * @param merchantName
	 * @param merchantCity
	 * @param merchantState
	 * @param purchaseDate
	 * @param purchaseAmount
	 */
	public Purchase(String merchantName, String merchantCity, String merchantState, Timestamp purchaseDate, double purchaseAmount) {
		this.merchantName = merchantName;
		this.merchantCity = merchantCity;
		this.merchantState = merchantState;
		this.purchaseDate = purchaseDate;
		this.purchaseAmount = purchaseAmount;
	}

	/**
	 * @return the merchantName
	 */
	public String getMerchantName() {
		return merchantName;
	}

	/**
	 * @return the merchantCity
	 */
	public String getMerchantCity() {
		return merchantCity;
	}

	/**
	 * @return the merchantState
	 */
	public String getMerchantState() {
		return merchantState;
	}

	/**
	 * @return the purchaseDate
	 */
	public Timestamp getPurchaseDate() {
		return purchaseDate;
	}

	/**
	 * @return the purchaseAmount
	 */
	public double getPurchaseAmount() {
		return purchaseAmount;
	}
}
