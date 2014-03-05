package helpers;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringReverserTest {

	@Test
	public void test() {
		assertEquals("Reverse of 'hello'","olleh",StringReverser.reverseIt("hello"));
		assertEquals("Reverse of 'Octopus'","supotcO",StringReverser.reverseIt("Octopus"));
		assertEquals("Reverse of '654321'","123456",StringReverser.reverseIt("654321"));
		assertEquals("Reverse of 'racecar'","racecar",StringReverser.reverseIt("racecar"));
		assertEquals("Reverse of 'radar'","radar",StringReverser.reverseIt("radar"));
	}

}
