import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author razdanr
 *This class is to denote
 *a unique event for a given location.
 */

public class Event {

	private final int id;
	private ArrayList<Double> ticketPrice=new ArrayList<>(); //list of ticket price for an event.

	static AtomicInteger nextID=new AtomicInteger();

	public Event() {
		//To generate unique id for each event
		this.id = nextID.incrementAndGet();

		//Assuming each event has 3 ticket prices
		for(int i=0;i<3;i++){
			Ticket t= new Ticket();
			this.ticketPrice.add(t.getPrice());
		}
		//sort and return the list with lower value at index 0
		Collections.sort(this.ticketPrice);
	}

	/**
	 * Get event ID
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Get list of ticket price for each event
	 * @return ticketPrice
	 */
	public ArrayList<Double> getTicketPrice() {
		return ticketPrice;
	}

}
