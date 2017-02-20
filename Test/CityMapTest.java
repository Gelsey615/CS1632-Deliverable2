import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class CityMapTest {
	@Test
	// Test addLocations() function in City Map class
	// Test will check the array list's size and the name of each location in the list
	public void testAddLocations() {
		CityMap city = new CityMap();
		ArrayList<location> result = city.addLocations();
		int length = result.size();
		assertEquals(length,4);
		assertEquals(result.get(0).getName(),"Presby");
		assertEquals(result.get(1).getName(),"Union");
		assertEquals(result.get(2).getName(),"Hillman");
		assertEquals(result.get(3).getName(),"Sennott");
	}

	@Test
	// Test findLocation() function in City Map class
	// Find the location with name "Union" and 
	// verify that the result location's name attribute is "Union"
	public void testFindLocation() {
		CityMap city = new CityMap();
		String target = "Union";
		location result = city.findLocation(target);
		String resName = result.getName();
		assertEquals(resName,target);
	}

	@Test
	// Test getLocation() function in City Map class
	// Find the location with index "0" and 
	// verify that the result location's name attribute is "Presby".
	public void testGetLocation() {
		CityMap city = new CityMap();
		String target = "Presby";
		location result = city.getLocation(0);
		String resName = result.getName();
		assertEquals(resName,target);
	}
}
