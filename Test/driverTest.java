import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;

import org.mockito.*;

public class driverTest {
	
	@Test 
	public void testGetRandomIndex() {
		CityMap city = Mockito.mock(CityMap.class);
		driver testDriver = new driver(city,0, new Random());
		int res = testDriver.getRandomIndex(6);
		boolean verify = false;
		if(res<6 && res>=0)
			verify = true;
		assertTrue(verify);
	}
	
	@Test
	// Given a current location, check advancement is valid
	// Mock the random class and stub the nextInt function
	// Assure the driver advance to a valid next location
	public void testAdvanceWithValidNextLocation() {
		location testCurrLoc = new location("Presby", new String[]{"Fourth Ave.","Bill St."}, new String[]{"Union","Sennott"});
		Random r = Mockito.mock(Random.class);
		driver testDriver = new driver(new CityMap(),0,r);

		Mockito.when(r.nextInt(2)).thenReturn(1);
		location resLoc = testDriver.advance(testCurrLoc);
		String resName = resLoc.name;
		assertEquals(resName, "Sennott");
	}
	
	@Test
	// Given a current place, check advancement to outside city
	// Mock the random class and stub the nextInt function
	// Assure the driver's next location is null since he has gone outside city
	public void testAdvanceWithNullNextLocation() {
		location testCurrLoc = new location("Union",  new String[]{"Fourth Ave.","Phil St."}, new String[]{"Philadelphia","Hillman"});
		Random r = Mockito.mock(Random.class);
		driver testDriver = new driver(new CityMap(),0,r);
		
		Mockito.when(r.nextInt(2)).thenReturn(0);
		location resLoc = testDriver.advance(testCurrLoc);
		assertEquals(resLoc, null);
	}
	
	@Test
	// Generate a valid random starting location
	// Mock the random class and stub the nextInt function
	// Verify 
	public void testGetStartingLocation() {
		Random r = Mockito.mock(Random.class);
		driver testDriver = new driver(new CityMap(),0,r);
		
		Mockito.when(r.nextInt(4)).thenReturn(1);
		location resLock = testDriver.getStartLoc();
		String resName = resLock.name;
		assertEquals(resName,"Union");
	}
	
	@Test
	public void testGetDriverId(){
		CityMap city = Mockito.mock(CityMap.class);
		Random r = Mockito.mock(Random.class);
		driver testDriver = new driver(city,6,r);
		int i = testDriver.getDriverId();
		assertEquals(i, 6);
	}
	
	@Test
	public void testGetSennottCount(){
		CityMap city = Mockito.mock(CityMap.class);
		Random r = Mockito.mock(Random.class);
		driver testDriver = new driver(city,0,r);
		int sc = testDriver.getSennottCount();
		assertEquals(sc, 0);
	}
	
	@Test
	public void testIncreaseSennottCount(){
		CityMap city = Mockito.mock(CityMap.class);
		Random r = Mockito.mock(Random.class);
		driver testDriver = new driver(city,0,r);
		testDriver.increaseSennottCount();
		testDriver.increaseSennottCount();
		int sc = testDriver.getSennottCount();
		assertEquals(sc, 2);
	}
	
	@Test
	public void testTraverse(){
	    ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		
		Random r = Mockito.mock(Random.class);
		driver testDriver = new driver(new CityMap(),0,r);
		
		Mockito.when(r.nextInt(4)).thenReturn(1);
		Mockito.when(r.nextInt(2)).thenReturn(0);
		testDriver.traverse();
		
		final String res = output.toString();
		String target = "Driver 0 heading from Union to Outside City via Fourth Ave.\n" + 
						"Driver 0 has gone to Philadelphia!\n";
		assertEquals(target,res);
	}
	
	@Test 
	public void testToStringWithinCity(){
		CityMap city = Mockito.mock(CityMap.class);
		Random r = Mockito.mock(Random.class);
		driver testDriver = new driver(city,0,r);
		String res = testDriver.toString("Union", "Hillman", "Phil St.");
		String target = "Driver 0 heading from Union to Hillman via Phil St.";
		assertEquals(res, target);
	}
	
	@Test 
	public void testToStringOutsideCity(){
		CityMap city = Mockito.mock(CityMap.class);
		Random r = Mockito.mock(Random.class);
		driver testDriver = new driver(city,0,r);
		String res = testDriver.toString("Union", "Philadelphia", "Fourth Ave.");
		String target = "Driver 0 heading from Union to Outside City via Fourth Ave.\n" + 
						"Driver 0 has gone to Philadelphia!";
		assertEquals(res, target);
	}
	
	@Test
	public void testPrintSennottCount0(){
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		
		CityMap city = Mockito.mock(CityMap.class);
		Random r = Mockito.mock(Random.class);
		driver testDriver = new driver(city,0,r);
		testDriver.printSennottCount();
		
		final String res = output.toString();
		String target = "Driver 0 met with Professor Laboon 0 time(s).\n"+
						"That student missed out!\n";
		assertEquals(res, target);
	}
	
	@Test
	public void testPrintSennottCount1(){
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		
		CityMap city = Mockito.mock(CityMap.class);
		Random r = Mockito.mock(Random.class);
		driver testDriver = new driver(city,0,r);
		testDriver.increaseSennottCount();
		testDriver.printSennottCount();
		
		final String res = output.toString();
		String target = "Driver 0 met with Professor Laboon 1 time(s).\n";
		assertEquals(res, target);
	}
	
	@Test
	public void testPrintSennottCount3(){
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		
		CityMap city = Mockito.mock(CityMap.class);
		Random r = Mockito.mock(Random.class);
		driver testDriver = new driver(city,0,r);
		testDriver.increaseSennottCount();
		testDriver.increaseSennottCount();
		testDriver.increaseSennottCount();
		testDriver.printSennottCount();
		
		final String res = output.toString();
		String target = "Driver 0 met with Professor Laboon 3 time(s).\n"+
						"Wow, that driver needed lots of CS help!\n";
		assertEquals(res, target);
	}
}
