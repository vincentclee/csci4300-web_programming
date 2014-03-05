/**
 * @author Vincent Lee
 * @author Meghan Redwine
 */

package db;

import java.util.ArrayList;
import junit.framework.TestCase;
import org.junit.Test;

public class BandTest extends TestCase {
	
    @Test
    /**
     * Tests all methods of class Band by constructor injection
     */
	public void testConstructor() {
		Band instance1 = new Band(1, "The Beatles");
		assertEquals("Band 1 Id", 1, instance1.getBandId());
		assertEquals("band 1 Name","The Beatles", instance1.getBandName());
		
		Band instance2 = new Band(2, "Rolling Stones");
		assertEquals("Band 2 Id", 2, instance2.getBandId());
		assertEquals("Band 2 Name","Rolling Stones", instance2.getBandName());
		
		Band instance3 = new Band(3, "AC/DC");
		assertEquals("Band 3 Id", 3, instance3.getBandId());
		assertEquals("Band 3 Name","AC/DC", instance3.getBandName());
		
		Band instance4 = new Band(4, "Led Zeppelin");
		assertEquals("Band 4 Id", 4, instance4.getBandId());
		assertEquals("Band 4 Name","Led Zeppelin", instance4.getBandName());
	}
    
    @Test
    /**
     * Test adding albums linked to a particular band.
     */
	public void testAddAlbum() {
    	Band instance = new Band(5,"The Beatles");
    	ArrayList<String> albums = instance.getAlbumList();
    	assertEquals("Initial album list size", 0, albums.size());
    	
    	instance.addAlbum("Yellow Submarine");
    	albums = instance.getAlbumList();
    	assertEquals("Album list size after one addition", 1, albums.size());
    	assertEquals("First album after 1 addition", "Yellow Submarine", albums.get(0));
    	
    	instance.addAlbum("Revolver");
    	albums = instance.getAlbumList();
    	assertEquals("Album list size after another addition", 2, albums.size());
    	assertEquals("First album after another addition", "Revolver", albums.get(1));
    	
    	instance.addAlbum("Sgt. Pepper Lonely Hearts Club Band");
    	albums = instance.getAlbumList();
    	assertEquals("Album list size after another addition", 3, albums.size());
    	assertEquals("First album after another addition", "Sgt. Pepper Lonely Hearts Club Band", albums.get(2));
    	
    	instance.addAlbum("Introducing... The Beatles");
    	albums = instance.getAlbumList();
    	assertEquals("Album list size after another addition", 4, albums.size());
    	assertEquals("First album after another addition", "Introducing... The Beatles", albums.get(3));
    	
    	instance.addAlbum("Abbey Road");
    	albums = instance.getAlbumList();
    	assertEquals("Album list size after another addition", 5, albums.size());
    	assertEquals("First album after another addition", "Abbey Road", albums.get(4));
    }
    
/*
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