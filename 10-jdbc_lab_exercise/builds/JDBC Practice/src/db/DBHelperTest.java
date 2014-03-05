/**
 * @author Vincent Lee
 * @author Meghan Redwine
 */

package db;

import java.util.ArrayList;
import org.junit.Test;
import junit.framework.TestCase;

public class DBHelperTest extends TestCase {

	@Test
	/**
	 * Test that we can create a DBHelper object
	 */
	public void testConstructor() {
		DBHelper instance = new DBHelper();
		assertNotNull("Could not create DBHelper", instance);
	}
	
	@Test
	/**
	 * Test adding Bands
	 */
	public void testBand() {
		ArrayList<Band> bandList = null;
		Band band = null;
	
		DBHelper instance = new DBHelper();
		instance.clearAlbums();
		instance.clearBands();
		
		bandList = instance.getBandList();
		assertEquals("Initial band list size", 0, bandList.size());
		
		instance.addBand("The Beatles");
		bandList = instance.getBandList();
		assertEquals("Band list size after adding The Beatles", 1, bandList.size());
		band = bandList.get(0);
		assertEquals("Band name after adding The Beatles", "The Beatles", band.getBandName());
		
		instance.addBand("Rolling Stones");
		bandList = instance.getBandList();
		assertEquals("Band list size after adding Rolling Stones", 2, bandList.size());
		band = bandList.get(1);
		assertEquals("Band name after adding Rolling Stones", "Rolling Stones", band.getBandName());
		
		instance.addBand("AC/DC");
		bandList = instance.getBandList();
		assertEquals("Band list size after adding AC/DC", 3, bandList.size());
		band = bandList.get(2);
		assertEquals("Band name after adding AC/DC", "AC/DC", band.getBandName());
		
		instance.addBand("Led Zeppelin");
		bandList = instance.getBandList();
		assertEquals("Band list size after adding Led Zeppelin", 4, bandList.size());
		band = bandList.get(3);
		assertEquals("Band name after adding Led Zeppelin", "Led Zeppelin", band.getBandName());
		
		instance.addBand("Metallica");
		bandList = instance.getBandList();
		assertEquals("Band list size after adding Metallica", 5, bandList.size());
		band = bandList.get(4);
		assertEquals("Band name after adding Metallica", "Metallica", band.getBandName());
	}
	
	@Test
	/**
	 * Test adding Albums to a specific Band
	 */
	public void testAlbums() {
		ArrayList<String> albumList = null;
		
		DBHelper instance = new DBHelper();

		
//		albumList = instance.getAlbumList(0);
//		assertEquals("Initial album list size for Band 1", 0, albumList.size());
		
		//Add Albums to "The Beatles"
		instance.addAlbum("Yellow Submarine", 0);
		albumList = instance.getAlbumList(0);
    	assertEquals("Album list size after one addition", 1, albumList.size());
    	assertEquals("First album after 1 addition", "Yellow Submarine", albumList.get(0));
    	
    	instance.addAlbum("Revolver", 0);
//    	albumList = instance.getAlbumList(0);
//    	assertEquals("Album list size after another addition", 2, albumList.size());
//    	assertEquals("First album after another addition", "Revolver", albumList.get(1));
    	
    	instance.addAlbum("Sgt. Pepper Lonely Hearts Club Band", 0);
//    	albumList = instance.getAlbumList(0);
//    	assertEquals("Album list size after another addition", 3, albumList.size());
//    	assertEquals("First album after another addition", "Sgt. Pepper Lonely Hearts Club Band", albumList.get(2));
    	
    	instance.addAlbum("Introducing... The Beatles", 0);
//    	albumList = instance.getAlbumList(0);
//    	assertEquals("Album list size after another addition", 4, albumList.size());
//    	assertEquals("First album after another addition", "Introducing... The Beatles", albumList.get(3));
    	
    	instance.addAlbum("Abbey Road", 0);
//    	albumList = instance.getAlbumList(0);
//    	assertEquals("Album list size after another addition", 5, albumList.size());
//    	assertEquals("First album after another addition", "Abbey Road", albumList.get(4));
		
    	
    	
    	//Add Albums to "Rolling Stones"
    	instance.addAlbum("Steel Wheels", 1);
    	instance.addAlbum("Voodoo Lounge", 1);
    	instance.addAlbum("Bridges to Babylon", 1);
    	instance.addAlbum("A Bigger Bang", 1);
    	
	}
	/*
	:Rolling Stones:
	Steel Wheels (1989)
	Voodoo Lounge (1994)
	Bridges to Babylon (1997)
	A Bigger Bang (2005)
	*/
	
	
	
	/*
    :The Beatles:
    Please Please Me (1963)
    With The Beatles (1963)
    Beatlemania! With The Beatles (1963)
    Introducing… The Beatles (1964)
    Meet The Beatles! (1964)
    Twist and Shout (1964)
    The Beatles’ Second Album (1964)
    The Beatles’ Long Tall Sally (1964)
    A Hard Day’s Night (1964- US Version)
    A Hard Day’s Night (1964- UK Version)
    Something New (1964)
    Beatles for Sale (1964)
    Beatles ’65 (1964)
    Beatles VI (1965)
    Help! (1965- UK Version)
    Help! (1965- US Version)
    Rubber Soul (1965- UK Version)
    Rubber Soul (1965- US Version)
    Yesterday and Today (1966)
    Revolver (1966- UK Version)
    Revolver (1966- US Version)
    Sgt. Pepper’s Lonely Hearts Club Band (1967)
    Magical Mystery Tour (1967)
    The Beatles (1968)
    Yellow Submarine (1969)
    Abbey Road (1969)
    Let it Be (1970)
*/
    
}
