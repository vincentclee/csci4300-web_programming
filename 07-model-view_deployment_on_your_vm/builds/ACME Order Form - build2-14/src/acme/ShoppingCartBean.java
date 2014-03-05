package acme;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ShoppingCartBean {
	ArrayList<LineItem> cart;
	private int itemID;
	private String errorMessage;
	
	/**
	 * Default Constructor
	 */
	public ShoppingCartBean() {
		cart = new ArrayList<LineItem>();
		itemID = 0;
		errorMessage = "";
	}
	
	/**
	 * This method sets a number corresponding to the item requested.
	 * @param itemID
	 */
	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
	
	/**
	 * Appends a new LineItem constructed from
	 * itemID and quantity to cart.
	 * Takes in String and parses to double to deal with erroneous input like letters
	 * @param quantity number of the item desired.
	 */
	public void setQuantity(String quantityAmt) {
		int quantity = 0;
		
		//Try-Catch block catches letters, symbols, etc., and automatically exits method via return.
		try {
			//If quantity is 0 or any negative number exit setQuantity method via return.
			if (Integer.parseInt(quantityAmt) <= 0) {
				errorMessage = "Error: Quantity can not be 0 or negative.";
				return;
			} else { //Set quantity.
				quantity = Integer.parseInt(quantityAmt);
				errorMessage = "";
			}
		} catch(Exception e) {
			errorMessage = "Error: Quantity invalid.";
			return;
		}
		//Boolean itemFound is for searching the array of current items in cart.
		//If item is not found, success is false, therefore creating a new LineItem()
		boolean itemFound = false;
		//Iterates over items in cart.
		for (int i = 0; i < cart.size(); i++) {
			//If the item is found, set the quantity of the current quantity plus input quantity.
			//Set itemFound to true and return, no need to go further.
			if (cart.get(i).getItemID() == itemID) {
				cart.get(i).setQuantity(cart.get(i).getQuantity() + quantity);
				itemFound = true;
				//Reorder list
				cartReorder();
				return;
			}
		}
		if (!itemFound) {
			cart.add(new LineItem(itemID, quantity));
			//Reorder list
			cartReorder();
		}
	}
	
	/**
	 * This method re-orders the ArrayList based on itemID.
	 * Only reorder if list has two or more items.
	 * Foer example: 1 4 2 5 becomes 1 2 4 5
	 */
	public void cartReorder() {
		if (cart.size() > 1) {
	        Collections.sort(cart, new Comparator<LineItem>(){
	            public int compare(LineItem l1, LineItem l2) {
	                return Integer.valueOf(l1.getItemID()).compareTo(Integer.valueOf(l2.getItemID()));
	            }
	        });

	        //Prints out list in order.
	        for (int i = 0; i < cart.size(); i++) {
				System.out.print("id" + cart.get(i).getItemID() + ":");
				System.out.print(cart.get(i).getDescription() + ":");
				System.out.println("qty" + cart.get(i).getQuantity());
			}
			System.out.println();
		}
	}
	
	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}
	
	/**
	 * @return the cart
	 */
	public ArrayList<LineItem> getCart() {
		return cart;
	}
}
