package creditcard;

import java.util.Date;

public class Purchase {
	
	public double amount;
	public Date date;
	public int id;
	
	/**
	 * 
	 * Constructor - sets purchase amount, date, and id
	 */
	public Purchase(double amt, Date date, int id)
	{
		this.amount = amt;
		this.date = date;
		this.id = id;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	
	
	

	

}
