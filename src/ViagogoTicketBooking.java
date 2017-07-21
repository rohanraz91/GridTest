import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.util.TreeMap;

public class ViagogoTicketBooking {

	private static HashMap<Location, Event> worldEvents; //To store events on their given location
	private static Map<Integer, Event> userDistanceMap;  //To store distance of each event
	private static Map<Integer, Event> sortedDistanceMap;//To sort the nearest distance
	private static Location userLocation;				 //To store the coordinates X and Y

	/**
	 * @param eventGenerator
	 * This method is used to 
	 * populate the world with Events
	 * which is initially set to 50
	 */
	public static void populateMap(EventGenerator eventGenerator){

		//To generate 50 events as an assumption
		for(int i =0;i<50;i++){
			eventGenerator.generateEvent();	
		}

		worldEvents=eventGenerator.getEventMap();
	}

	/**
	 * This method will be
	 * used to take user input.
	 */
	public static void userInput(){

		userLocation=new Location();

		Scanner sc=new Scanner(System.in);

		String input;
		boolean checker=true;

		//Loop until valid input provided by user
		//check for exception and prompt user to enter valid coordinates
		try{
			while(checker){

				System.out.println("Please Input Coordinates:");
				input=sc.nextLine();

				//split by ',' to get x and y values
				String[] value=input.split(",");

				//Coordinate x from the user
				userLocation.setX(Integer.parseInt(value[0]));
				//Coordinate y from the user
				userLocation.setY(Integer.parseInt(value[1]));

				//check if x and y coordinates are between -10 and 10
				if((userLocation.getX() <= 10 && userLocation.getX() >= -10) && (userLocation.getY()<=10 && userLocation.getY() >= -10)){
					checker=false;
				}
				else{
					System.out.println("Please Input Coordinates between (-10,10)");
				}
			}
		}
		catch(NumberFormatException e){
			System.out.println("Please Enter Correct Coordinates in the form x,y for e.g->5,6");
			userInput();
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Please Enter Correct Coordinates in the form x,y for e.g->5,6");
			userInput();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		sc.close();
	}

	/**
	 * To find Manhattan distances of 
	 * events from user location
	 */
	public static void getDistance(){

		userDistanceMap=new HashMap<>();

		int distance=0;
		for(Location l: worldEvents.keySet()){
			distance=Math.abs(l.getX()-userLocation.getX()) + Math.abs(l.getY()-userLocation.getY());
			userDistanceMap.put(distance, worldEvents.get(l));
		}
		//Manhattan distance of events from user defined location are arranged in ascending order.
		sortedDistanceMap=new TreeMap<Integer,Event>(userDistanceMap);
	}

	/**
	 * This method will print
	 * the final output
	 */
	public static void printOutput(){

		System.out.println("Closest Events to ("+userLocation.getX()+","+userLocation.getY()+"):");

		//The counter is set to get the 5 nearest events from user defined location
		int numResults=0;
		for (Map.Entry<Integer, Event> sorted : sortedDistanceMap.entrySet()) {
			numResults++;
			System.out.print("Event ");
			System.out.printf("%03d", sorted.getValue().getId());
			System.out.print("- $");
			System.out.printf("%05.2f",sorted.getValue().getTicketPrice().get(0));
			System.out.println(", Distance "+sorted.getKey());
			if(numResults==5){
				break;
			}
		}
	}

	/**
	 * @param args
	 * The main method will be utilized
	 * to generate the logic
	 */
	public static void main(String[] args) {

		try{
			//Generate Random Events
			//This is done from Administrator side
			EventGenerator eventGenerator=new EventGenerator();
			populateMap(eventGenerator);

			//Take user input for Coordinates
			userInput();
			//Calculate the nearest events
			getDistance();

			printOutput();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
