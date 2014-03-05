/**
 * @author Vincent Lee
 * @author Meghan Redwine
 */

package db;

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
}