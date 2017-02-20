/*
 * Xinyue Guo
 * CS 1632
 * Deliverable 2
 * CitySim9004.java
 */

import java.util.Random;

public class CitySim9004 {
  
  public static void main(String[] args) {
    final int NUM_DRIVERS = 5;      
    int seedValue = 0;               
    Random randomObj = new Random(); 
    
    // Parse command line arguments to get seed value for random number generator
    seedValue = parseArguments(args);
    //if seedValue is -1, which indicates error, stops the program.
    if(seedValue == -1)
    	return;
    
    randomObj.setSeed(seedValue);
 
    CityMap city = new CityMap();
    
    // Drivers 0-4 will iterate traverse the city one by one
    for(int driverId = 0; driverId < NUM_DRIVERS; driverId++) {
      driver driver = new driver(city, driverId, randomObj);
      
      driver.traverse();
      
      driver.printSennottCount();
      
      // Print separator string to separate output
      System.out.println("-----");
    }
  } 
  
  /*
   * Function to parse the command line arguments
   * @parameter arguments: command line arguments
   * @return the seed value or '-1' to indicate an error
   */
  public static int parseArguments(String[] arguments) {
    int seed = -1;
    
    if (arguments.length == 1) {
      try {
        if(Integer.parseInt(arguments[0]) <= 0) {
        	System.out.println("Argument must be a positive integer.");
        }
        else{
        	seed = Integer.parseInt(arguments[0]);
        }
      } catch (NumberFormatException e) {
        System.out.println("Argument must be an integer.");
      }
    }
    else {
      System.out.println("Invalid arguments!");
      System.out.println("Usage: java CitySim9000 <seed value>");
    }
    
    return seed;
  }
}
