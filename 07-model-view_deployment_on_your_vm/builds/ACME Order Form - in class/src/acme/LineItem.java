package acme;

public class LineItem {
	private int itemID;
	private int quantity;
	private String description;
	static String[] itemDescription = {"Rocket-powered Roller Skates",
		"Exploding tennis balls, case", "Dehydrated boulder", "Earthquake Pill, bottle of 12", "Batman Outfit", "Catapult"};
	
	/**
	 * Creates a LineItem with the given itemID and quantity,
	 * and a description corresponding to the itemID.
	 * @param itemID
	 * @param quantity
	 */
	public LineItem(int itemID, int quantity) {
		this.itemID = itemID;
		this.quantity = quantity;
		description = itemDescription[itemID];
	}


	/**
	 * @return the itemID
	 */
	public int getItemID() {
		return itemID;
	}
	/**
	 * @param itemID the itemID to set
	 */
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
