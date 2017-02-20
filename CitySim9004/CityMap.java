import java.util.ArrayList;
public class CityMap {
	private ArrayList<location> locs;

	public CityMap() {
		// Build the map of the city
		this.locs = addLocations();
	}

	/*
	 * @return the Array List containing all of the locations
	 */
	public ArrayList<location> addLocations() {
		ArrayList<location> locations = new ArrayList<location>();
		locations.add(new location("Presby", new String[]{"Fourth Ave.","Bill St."}, new String[]{"Union","Sennott"}));
		locations.add(new location("Union",  new String[]{"Fourth Ave.","Phil St."}, new String[]{"Philadelphia","Hillman"}));
		locations.add(new location("Hillman",  new String[]{"Fifth Ave.","Phil St."}, new String[]{"Sennott", "Union"}));
		locations.add(new location("Sennott",  new String[]{"Fifth Ave.","Bill St."}, new String[]{"Cleveland","Presby"}));

		return locations;
	}

	/*
	 * Find the location object by name
	 * @parameter target: the name of the location to find
	 * @return the location object with the specified name
	 */
	public location findLocation(String target) {
		location next = null;

		for (int i = 0; i < this.locs.size(); i++){
			if(locs.get(i).getName().equals(target)){
				next = locs.get(i);
				break;
			}
		}

		return next;
	}

	/*
	 * Get requested location by index
	 * @parameter index of requested location
	 * @return the requested location object
	 */ 
	public location getLocation(int index) {
		return locs.get(index);
	}
}
