import java.util.HashMap;

/**
 * @author razdanr
 *Class to generate events
 *on the map(world)
 */
public class EventGenerator {
	
	private HashMap<Location, Event> eventMap=new HashMap<>();
	/**
	 * To generate random new Events associated
	 * with its location
	 */
	public void generateEvent() {
		Event e=new Event();
		Location l=new Location();
		l.generateLocation();
		eventMap.put(l,e);
	}

	/**
	 * Get Event and its location as key using Hashmap
	 * @return maps of all events
	 */
	public HashMap<Location, Event> getEventMap() {
		return eventMap;
	}
}
