package helpers;

public class StringReverser {

	public StringReverser()
	{
		
	}
	
	/*
	 * Returns the reverse of 'inputString'
	 */
	public static String reverseIt(String inputString)
	{
		String reverse = "";
		int length = inputString.length();
		for(int i = length-1; i >= 0; i--)
		{
			reverse+=inputString.charAt(i);
		}
		System.out.println("Reverse = " + reverse);
		
		return reverse;
	}
	
}
