public class location {
	String name;
	String[] paths;
	String[] neighbors;

	/*
	 * Constructor
	 */
	public location(String name, String[] streets, String[] neighbors) {
		this.name = name;
		this.paths = streets;
		this.neighbors = neighbors;
	}

	/*
	 * Get the name of the location
	 * @return the location name
	 */ 
	public String getName() {
		return this.name; 
	}
	
	/*
	 * Get the selected path by index
	 * @parameter index: the index of the selected path
	 * @return the path the the specified index
	 */ 
	public String getPath(int index) {
		return this.paths[index]; 
	}

	/*
	 * Get the next location by index
	 * @parameter index: the index of the next location
	 * @return the next location with the specified index
	 */ 
	public String getNextLoc(int index) {
		return this.neighbors[index]; 
	}

}
