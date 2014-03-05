package acme;

public class LineItem {
	private int itemID;
	private int quantity;
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
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

	public LineItem() {
		itemID = 0;
		quantity = 0;
		description = "";
		
	}

	/**
	 * @return the itemID
	 */
	public int getItemID() {
		return itemID;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
}
