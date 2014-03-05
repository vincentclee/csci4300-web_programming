/**
 * Tests the AuctionHelper class, which manages DB access for the Auction Project project
 * @author Vincent Lee
 */

package helper;

import junit.framework.TestCase;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuctionHelperTest extends TestCase {
	/**
	 * Tests that an object can be created
	 */
	@Test
	public void test1Constructor() {
		AuctionHelper instance = new AuctionHelper();
		assertNotNull("newly created AuctionHelper", instance);
		
		//Clear the Items & Categories & Users table of all entries.
		instance.clearItems();
		instance.clearCategories();
		instance.clearUsers();
	}
	
	/**
	 * Tests that clears the database
	 */
	@Test
	public void test2ClearDatabase() {
		AuctionHelper instance = new AuctionHelper();
		
		//Clear the Items & Categories & Users table of all entries.
		instance.clearItems();
		instance.clearCategories();
		instance.clearUsers();
	}
	
	/**
	 * Tests creating users, authenticating users, changing users passwords
	 */
	@Test
	public void test3Users() {
		AuctionHelper instance = new AuctionHelper();
		
		//Add 3 administrators to database
		assertEquals("Adding first administrator", true, instance.addUser("admin", "gtxtitan"));
		assertEquals("Adding second administrator", true, instance.addUser("drdan", "javasecure"));
		assertEquals("Adding third administrator", true, instance.addUser("ismailcembudak", "humancomputerinteraction"));
		
		//Attempt to login administrators
		assertEquals("First administrator login", true, instance.validateUser("admin", "gtxtitan"));
		assertEquals("Second administrator login", true, instance.validateUser("drdan", "javasecure"));
		assertEquals("Thrid administrator login", true, instance.validateUser("ismailcembudak", "humancomputerinteraction"));
		
		//Attempt to change passwords
		assertEquals("First administrator password change", true, instance.changePassword("admin", "gtxtitan", "gtxTitan"));
		assertEquals("Second administrator password change", true, instance.changePassword("drdan", "javasecure", "javaSecure"));
		assertEquals("Thrid administrator password change", true, instance.changePassword("ismailcembudak", "humancomputerinteraction", "humanComputerInteraction"));
	}
	
	/**
	 * Tests creating categories, with items
	 */
	@Test
	public void test4CategoriesItems() {
		AuctionHelper instance = new AuctionHelper();
		
		//Add 3 categories to the database	
		assertEquals("Adding first category", true, instance.addCategory("Dance Lessons"));
		assertEquals("Adding second category", true, instance.addCategory("Costumes"));
		assertEquals("Adding third category", true, instance.addCategory("Dance DVD's/Blu-ray's"));
		
		
		//Add items to first category
		assertEquals("Adding first item to first category", true, instance.addItem("Lindy Hop dance lessons", 
				"Lindy Hop Lessons from Rachel", 
				"http://i50.tinypic.com/35lw4ef.jpg", 
				"Learn the exciting \"Lindy Hop\" style of swing dancing at Rachel's Dance Studio. Package of 6 one-hour lessons for a couple.", 
				"Classes meet Tuesday nights from 7 to 8 pm. New classes start monthly. Must be used by Jan 1, 2014.", 100.0, 7, 0));
		assertEquals("Adding second item to first category", true, instance.addItem("Texas Swing dance lessons", 
				"Texas Swing lessons from Holly", 
				"http://activerain.com/image_store/uploads/6/1/3/1/3/ar126504149331316.jpg", 
				"To share and promote swing dancing in the UT Austin community by providing lessons and dances in a relaxed, social environment. To create a community of students interested not just in preserving traditional jazz and vernacular jazz dancing, but in putting their own stamp on it. Package of 6 one-hour lessons for a individual.", 
				"Classes meet Wednesday nights from 8 to 9 pm. New classes start monthly. Must be used by Jan 1, 2014.", 150.0, 3, 0));
		assertEquals("Adding third item to first category", true, instance.addItem("Indian classical dance lessons", 
				"Indian Classical Dance Lessons by Ismailcem Budak Arpinar", 
				"http://upload.wikimedia.org/wikipedia/commons/0/00/Sharmila_Sharma_et_Rajendra_Kumar_Gangani_2.jpg", 
				"Learn the exciting Indian classical dance rooted in Natya, the sacred Hindu musical theatre styles, dating back to the Natya Shastra of Bharata Muni (400 BC). Package of 6 one-hour lessons for a individual", 
				"Classes meet Thursday nights from 7 to 8 pm. New classes start monthly. Must be used by Jan 1, 2014.", 70.0, 5, 0));
		assertEquals("Adding fourth item to first category", true, instance.addItem("Twerking dance lessons", 
				"Twerking Dance Lessons presented by Miley Cyrus", 
				"http://assets.nydailynews.com/polopoly_fs/1.1297172.1364061380!/img/httpImage/image.jpg_gen/derivatives/landscape_635/miley24f-3-web.jpg", 
				"Learn the exciting dance form \"twerking\" presented by herself, Miley Cyrus as seen on her youtube video in which Cyrus is wearing a one-piece gray outfit with a portrait of a unicorn on the hood, dances furiously to the song \"Wop\" by J. Dash. Package of 6 one-hour lessons for a individual.", 
				"Classes meet Monday nights from 7 to 8 pm. New classes start monthly. Must be used by Jan 1, 2014.", 500.0, 5, 0));
		
		//Add items to second category
		assertEquals("Adding first item to second category", true, instance.addItem("Womens dress, size 8", 
				"Womens dress, size 8", 
				"http://www.wall321.com/thumbnails/detail/20121122/brunettes%20women%20dress%20katy%20perry%20singers%202609x3919%20wallpaper_www.wall321.com_28.jpg", 
				"Skin-tight rubber dress, which is designed to show off the natual curves of a fit woman.", 
				"Ship within 24 hours.", 200.0, 1, 1));
		assertEquals("Adding second item to second category", true, instance.addItem("Authentic Muslim Turban", 
				"Authentic Indian Turban made in India", 
				"http://images.esellerpro.com/2477/I/441/082/HAT-TURBAN-V1-RED-01.jpg", 
				"A traditional Muslim headdress consisting of a long scarf ussing 100% cotton, wound around a small cap or directly around the head.", 
				"Ship within 24 hours.", 50.0, 3, 1));
		assertEquals("Adding third item to second category", true, instance.addItem("Unicorn Onesie", 
				"Unicorn Onesie, size 5", 
				"http://i.ebayimg.com/t/Unisex-Kigurumi-Pajamas-Adult-Anime-Cosplay-Costume-Onesie-Blue-Unicorn-S-M-L-XL-/00/s/MTIwMFg4MDA=/$T2eC16hHJGwE9n)yVT-qBQnZtt,W6g~~60_57.JPG", 
				"Unicorn Footed Pajamas features: 100% polar fleece, preshrunk, fully machine washable. See size chart for full sizing details, Get Yours today.", 
				"Ship within 24 hours.", 35.0, 7, 1));
		
		//Add items to third category
		assertEquals("Adding first item to third category", true, instance.addItem("Dance with Julianne: Just Dance!", 
				"Dance with Julianne: Just Dance! (2010) DVD", 
				"http://ecx.images-amazon.com/images/I/817tfI39gWL._SL1500_.jpg", 
				"Get a lean, toned dancer's physique! No partner needed. Two-time Dancing with the Stars champion Julianne Hough is ready to share her secret for staying fit: Just Dance! Julianne will lead you through three upbeat routines-no partner needed. You'll kick and you'll shake all the while toning your abs, legs, butt, arms-everything! Each fat-burning move is specially designed to keep your heart rate up and help you dance your way into fabulous shape!", 
				"Ship within 24 hours.", 12.95, 5, 2));
		assertEquals("Adding second item to third category", true, instance.addItem("Hip Hop Abs Extreme DVD Workout", 
				"Hip Hop Abs Extreme DVD Workout - Extreme Cardio, Abs & Dance Blu-Ray 1080p", 
				"http://ecx.images-amazon.com/images/I/51vUbdgdCDL.jpg", 
				"Shaun's ramped up the intensity for these two brand-new workouts (Extreme Cardio & Extreme Abs) to give you even more amazing results. Burn fat and sculpt your abs-without ever getting on the floor. His signature dance moves will get you into the best shape of your life. Consult your physician and follow all safety instructions before beginning any exercise program.", 
				"Ship within 24 hours.", 29.95, 1, 2));
		assertEquals("Adding third item to third category", true, instance.addItem("The Basics and Beyond (2007)", 
				"Dance Lessons 101: The Basics and Beyond (2007) DVD", 
				"http://ecx.images-amazon.com/images/I/51pLSvrKxCL.jpg", 
				"Dance Lessons 101 is the best starting point for Ballroom, Country, Swing, and Latin Dancing. This DVD is proof you can learn to dance without live lessons! You will be dancing the Slow Dance, Waltz, Swing, Salsa, Two-Step, Cha-Cha, Hustle, and West Coast Swing in a matter of minutes.", 
				"Ship within 24 hours.", 49.95, 7, 2));
	}
	
	/**
	 * Tests bidding on a few items.
	 */
	@Test
	public void test5Bidding() {
		AuctionHelper instance = new AuctionHelper();
		
		assertEquals("Test bid on a Item 1 in Category 1", true, instance.placeBid(1, 1, 100.0, "Rick Ross", "rickross@universalmusicgroup.com"));
		assertEquals("Test bid on a Item 2 in Category 2", true, instance.placeBid(2, 2, 66.0, "Selena Gomez", "messagemebaby@gmail.com"));
		assertEquals("Test bid on a Item 3 in Category 3", true, instance.placeBid(3, 3, 85.0, "Molly Bowman", "mollybowman@plus.com"));
	}
}






