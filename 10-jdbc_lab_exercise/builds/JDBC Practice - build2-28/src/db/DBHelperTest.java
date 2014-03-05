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

		albumList = instance.getAlbumList(0);
		assertEquals("Initial album list size for Band 1", 0, albumList.size());
		
		//Add Albums to "The Beatles"
		instance.addAlbum("Yellow Submarine", 0);
		albumList = instance.getAlbumList(0);
    	assertEquals("Album list size after one addition", 1, albumList.size());
    	assertEquals("First album after 1 addition", "Yellow Submarine", albumList.get(0));
    	
    	instance.addAlbum("Revolver", 0);
    	albumList = instance.getAlbumList(0);
    	assertEquals("Album list size after another addition", 2, albumList.size());
    	assertEquals("First album after another addition", "Revolver", albumList.get(1));
    	
    	instance.addAlbum("Sgt. Pepper Lonely Hearts Club Band", 0);
    	albumList = instance.getAlbumList(0);
    	assertEquals("Album list size after another addition", 3, albumList.size());
    	assertEquals("First album after another addition", "Sgt. Pepper Lonely Hearts Club Band", albumList.get(2));
    	
    	instance.addAlbum("Introducing... The Beatles", 0);
    	albumList = instance.getAlbumList(0);
    	assertEquals("Album list size after another addition", 4, albumList.size());
    	assertEquals("First album after another addition", "Introducing... The Beatles", albumList.get(3));
    	
    	instance.addAlbum("Abbey Road", 0);
    	albumList = instance.getAlbumList(0);
    	assertEquals("Album list size after another addition", 5, albumList.size());
    	assertEquals("First album after another addition", "Abbey Road", albumList.get(4));
    	
    	
    	//Add Albums to "Rolling Stones"
    	instance.addAlbum("Steel Wheels", 1);
		albumList = instance.getAlbumList(1);
    	assertEquals("Album list size after one addition", 1, albumList.size());
    	assertEquals("First album after 1 addition", "Steel Wheels", albumList.get(0));
    	
    	instance.addAlbum("Voodoo Lounge", 1);
		albumList = instance.getAlbumList(1);
    	assertEquals("Album list size after another addition", 2, albumList.size());
    	assertEquals("First album after 1 addition", "Voodoo Lounge", albumList.get(1));
    	
    	instance.addAlbum("Bridges to Babylon", 1);
		albumList = instance.getAlbumList(1);
    	assertEquals("Album list size after another addition", 3, albumList.size());
    	assertEquals("First album after 1 addition", "Bridges to Babylon", albumList.get(2));
    	
    	instance.addAlbum("A Bigger Bang", 1);
		albumList = instance.getAlbumList(1);
    	assertEquals("Album list size after another addition", 4, albumList.size());
    	assertEquals("First album after 1 addition", "A Bigger Bang", albumList.get(3));
    	
    	
    	//Add Albums to "AC/DC"
    	instance.addAlbum("Highway to Hell", 2);
		albumList = instance.getAlbumList(2);
    	assertEquals("Album list size after one addition", 1, albumList.size());
    	assertEquals("First album after 1 addition", "Highway to Hell", albumList.get(0));
    	
    	instance.addAlbum("Black Ice", 2);
		albumList = instance.getAlbumList(2);
    	assertEquals("Album list size after another addition", 2, albumList.size());
    	assertEquals("First album after 1 addition", "Black Ice", albumList.get(1));
    	
    	instance.addAlbum("Stiff Upper Lip", 2);
		albumList = instance.getAlbumList(2);
    	assertEquals("Album list size after another addition", 3, albumList.size());
    	assertEquals("First album after 1 addition", "Stiff Upper Lip", albumList.get(2));
    	
    	instance.addAlbum("Let There Be Rock", 2);
		albumList = instance.getAlbumList(2);
    	assertEquals("Album list size after another addition", 4, albumList.size());
    	assertEquals("First album after 1 addition", "Let There Be Rock", albumList.get(3));
    	
    	
    	//Add Albums to "Led Zeppelin"
    	instance.addAlbum("Led Zeppelin", 3);
		albumList = instance.getAlbumList(3);
    	assertEquals("Album list size after one addition", 1, albumList.size());
    	assertEquals("First album after 1 addition", "Led Zeppelin", albumList.get(0));
    	
    	instance.addAlbum("Led Zeppelin II", 3);
		albumList = instance.getAlbumList(3);
    	assertEquals("Album list size after another addition", 2, albumList.size());
    	assertEquals("First album after 1 addition", "Led Zeppelin II", albumList.get(1));
    	
    	instance.addAlbum("Led Zeppelin III", 3);
		albumList = instance.getAlbumList(3);
    	assertEquals("Album list size after another addition", 3, albumList.size());
    	assertEquals("First album after 1 addition", "Led Zeppelin III", albumList.get(2));
    	
    	instance.addAlbum("Led Zeppelin IV", 3);
		albumList = instance.getAlbumList(3);
    	assertEquals("Album list size after another addition", 4, albumList.size());
    	assertEquals("First album after 1 addition", "Led Zeppelin IV", albumList.get(3));
    	
    	
    	//Add Albums to "Metallica"
    	instance.addAlbum("Death Magnetic", 4);
		albumList = instance.getAlbumList(4);
    	assertEquals("Album list size after one addition", 1, albumList.size());
    	assertEquals("First album after 1 addition", "Death Magnetic", albumList.get(0));
    	
    	instance.addAlbum("...And Justice for All", 4);
		albumList = instance.getAlbumList(4);
    	assertEquals("Album list size after another addition", 2, albumList.size());
    	assertEquals("First album after 1 addition", "...And Justice for All", albumList.get(1));
    	
    	instance.addAlbum("Ride the Lightning", 4);
		albumList = instance.getAlbumList(4);
    	assertEquals("Album list size after another addition", 3, albumList.size());
    	assertEquals("First album after 1 addition", "Ride the Lightning", albumList.get(2));
    	
    	instance.addAlbum("St. Anger", 4);
		albumList = instance.getAlbumList(4);
    	assertEquals("Album list size after another addition", 4, albumList.size());
    	assertEquals("First album after 1 addition", "St. Anger", albumList.get(3));
	}
}