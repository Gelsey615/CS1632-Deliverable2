import static org.junit.Assert.*;
import org.junit.Test;

public class testParseArguments {
	
	@Test
	// Test the parseArguments() in CitySim9004
	// Test passing a positive integer as argument and should get the integer back
	public void testParseArgumentsWithPositiveInt() {
		String[] testArgs = new String[]{"5"};
		int target = 5;        
		int resSeed = CitySim9004.parseArguments(testArgs);
		assertEquals(resSeed, target);
	}
	
	@Test
	// Test the parseArguments() in CitySim9004
	// Test passing a string as argument and should get result seedValue = -1
	public void testParseArgumentsWithString() {
		String[] testArgs = new String[]{"string"};
		int target = -1;        
		int resSeed = CitySim9004.parseArguments(testArgs);
		assertEquals(resSeed, target);
	}

	@Test
	// Test the parseArguments() in CitySim9004
	// Test passing a negative integer as argument and should get result seedValue = -1
	public void testParseArgumentsWithNegativeInt() {
		String[] testArgs = new String[]{"-5"};
		int target = -1;        
		int resSeed = CitySim9004.parseArguments(testArgs);
		assertEquals(resSeed, target);
	}

	@Test
	// Test the parseArguments() in CitySim9004
	// Test passing 3 arguments to the function and should get result seedValue = -1
	public void testParseArgumentsWithMultipleArgs() {
		String[] testArgs = new String[]{"a","1","blah"};
		int target = -1;        
		int resSeed = CitySim9004.parseArguments(testArgs);
		assertEquals(resSeed, target);
	}

}
