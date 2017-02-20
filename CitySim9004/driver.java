import java.util.Random;

public class driver {

	private int id;
	private CityMap city;
	private int sennott_count;
	private Random randomObj;

	/*
	 * Constructor
	 * @parameter city: Object that contains the city map
	 * @parameter id: id of the driver (0-4)
	 * @parameter randObj: for generating random number
	 */
	public driver(CityMap city, int id, Random randObj) {
		this.city  = city;
		this.id = id;
		this.sennott_count = 0;
		this.randomObj = randObj;
	}

	/*
	 * Function to get random index smaller than the max value
	 * @parameter max: max value(exclusive) for random number generator
	 * @return index randomly generated
	 */
	public int getRandomIndex(int max) {
		int index = 0;

		index = randomObj.nextInt(max);

		return index;
	}
	
	/*
	 * Function to advance from current location to next one
	 * @parameter currLoc: the current location of the driver
	 * @return the next location of the driver
	 */ 
	public location advance(location currLoc){
		int index = 0;
		String selectedPath;
	    String nextLocName;
		location nextLoc;

		// Generate random number for which path to choose
		index = getRandomIndex(2);
		selectedPath = currLoc.getPath(index);
		nextLocName = currLoc.getNextLoc(index);
		if(!nextLocName.equals("Philadelphia") && !nextLocName.equals("Cleveland"))
			nextLoc = city.findLocation(nextLocName);
		else
			nextLoc = null;

		// Display driver route
		System.out.println(toString(currLoc.getName(), nextLocName, selectedPath));
		return nextLoc;
	}

	/*
	 * Function to get the driver ID
	 * @return driver ID
	 */
	public int getDriverId() {
		return this.id;
	}

	/*
	 * Function to get the driver's starting location
	 * @return the starting location
	 */
	public location getStartLoc() {
		location startLoc = null;
		int index = 0;

		// get random number to choose starting location within the city
		index = getRandomIndex(4);
		startLoc = city.getLocation(index);

		return startLoc;
	}
	
	/*
	 * Function to get how many times a driver passed Sennott
	 * @return sennott_count 
	 */
	public int getSennottCount() {
	    return this.sennott_count;	
	}
	
	/*
	 * function to increase sennott_count
	 */
	public void increaseSennottCount(){
		this.sennott_count++;
	}
		
	/*
	 * Function to traverse the map
	 */
	public void traverse() {
		location currentLocation;
		location nextLocation;
		currentLocation = getStartLoc();
		if(currentLocation.getName().equals("Sennott"))
			increaseSennottCount();
		
		boolean cont = true;
		// Loop to traverse city until reaching outside of city
		while(cont) {
			// Move to next location
			nextLocation = advance(currentLocation);
			
			if(nextLocation==null)
				cont = false;
			else{
				currentLocation = nextLocation;
				if(currentLocation.getName().equals("Sennott"))
					increaseSennottCount();
			}		
		}

	}

	/*
	 * Function print the completed route for a driver
	 * @return output of driver's current route
	 */
	public String toString(String previous, String next, String path) {
		String outputStr = "";
		int id = getDriverId();

		
		// Driver x heading from a to b via c.
		if(!next.equals("Philadelphia") && !next.equals("Cleveland"))
			outputStr = "Driver " + id + " heading from " + 
					previous + " to " + next + " via " + path;
		else
			outputStr = "Driver " + id + " heading from " + 
					previous + " to Outside City via " + path +
					"\nDriver " + id + " has gone to "+ next + "!";
		return outputStr;
	}
	
	/*
	 * Function to print relevant information according to sennott_count
	 */
	public void printSennottCount(){
		int id = getDriverId();
		int sc = getSennottCount();
		System.out.println("Driver "+id+" met with Professor Laboon "+sc+" time(s).");
		if(sc == 0)
			System.out.println("That student missed out!");
		if(sc >= 3)
			System.out.println("Wow, that driver needed lots of CS help!");
	}
}
