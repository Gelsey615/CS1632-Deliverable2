import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Assert;

public class locationTest {
	@Test
	// Test the getName() function of the location object
	// Create a test location object and try extracting its name and verify the result.
	public void testGetLocationName() {
		location testLocation = new location("testLocation", new String[]{"Fourth Ave.","Bill St."}, new String[]{"testDest1","testDest2"});
		String target = "testLocation";
		String result = testLocation.getName();
		assertEquals(result, target);
	}

	@Test
	// Test the getNextLoc() function of the location object
	// Create a test location object and get one of its neighbors by index and verify the result.
	public void testGetNextLocationByIndex() {
		location testLocation = new location("testLocation", new String[]{"Fourth Ave.","Bill St."}, new String[]{"testDest1","testDest2"});
		String target = "testDest1";
		String result = testLocation.getNextLoc(0);
		Assert.assertEquals(result, target);
	}

	@Test
	// Test the getPath() function of the location object
	// Create a test location object and get one of its paths by index and verify the result.
	public void testGetPathByIndex() {
		location testLocation = new location("testLocation", new String[]{"Fourth Ave.","Bill St."}, new String[]{"testDest1","testDest2"});
		String target = "Bill St.";
		String result = testLocation.getPath(1);
		assertEquals(result, target);
	}
}
