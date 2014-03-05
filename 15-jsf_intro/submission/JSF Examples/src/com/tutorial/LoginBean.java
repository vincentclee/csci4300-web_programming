package com.tutorial;

/**
 * The Login Bean class handles user name and password
 * @author Vincent Lee
 * @author Meghan Redwine
 */
public class LoginBean {
	String name;
	ComplexPassword password;
	
	public LoginBean() {
		super();
		password = new ComplexPassword();
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the password
	 */
	public ComplexPassword getPassword() {
		return password;
	}
	
	/**
	 * @param password the password to set
	 */
	public void setPassword(ComplexPassword password) {
		this.password = password;
	}
	
	public static class ComplexPassword {
		String inputText;
		long convertedID;
		
		/**
		 * @return the convertedID
		 */
		public long getConvertedID() {
			return convertedID;
		}
		
		/**
		 * @param convertedText the convertedText to set
		 */
		public void setConvertedID(long convertedText) {
			this.convertedID = convertedText;
		}
		
		/**
		 * @return the inputText
		 */
		public String getInputText() {
			return inputText;
		}
		
		/**
		 * @param inputText the inputText to set
		 */
		public void setInputText(String inputText) {
			this.inputText = inputText;
		}
	}
}
