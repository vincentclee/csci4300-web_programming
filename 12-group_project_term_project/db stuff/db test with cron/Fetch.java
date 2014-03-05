import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * Name: Fetch.java
 * Date: September 15, 2012
 * Purpose: A convenience class for reading a URL and returning its contents as a string.
 * 			It hides the complexity of reading from a URL. It should always succeed.
 * @author fred
 * From site: http://cs.uga.edu/~cs1301/
 */
public class Fetch {

	/**
	 * @param urlString A String representation of a valid URL (e.g., "http://www.google.com").
	 * @return	Returns the text content of the Web page indicated by the URL.
	 */
	private static int count = 0;
	public static String fetchURL(String urlString) {

		count++;
		// The content of the web page, built up line by line.
		String returnValue = "";
		if(count > 20)
		{

			System.out.println("fetchURL called more than 20 times.");
			System.out.println("Exiting Program.");
			System.exit(0);

		}
		// Try opening the web page and reading from it.
		try {
			URL url = new URL(urlString);
			URLConnection connection = url.openConnection();
			connection.connect();

			BufferedReader in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));

			//Use a while loop to read the web page, line by line.
			String line = in.readLine();
			while (line != null) {
				//add the new line to the current return value.
				returnValue = returnValue + line + "\n";
				line = in.readLine();
			}
		}

		// If an error (Exception) is encountered, return the message associated with it.
		catch (Exception e) {
			returnValue = "$error$" + e.toString();
		}

		// return the string value, whatever it is.
		return returnValue;
	}

}
