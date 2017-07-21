import java.util.Random;

/**
 * 
 * @author razdanr
 *This class denotes a
 *unique location on map(world)
 */
public class Location {

	private int x;
	private int y;

	/**
	 * This method generates random
	 * location and set the X and Y
	 * Coordinates
	 */
	public void generateLocation(){
		Random rn=new Random();
		int lower=-10;
		int upper=11;
		this.x=rn.nextInt(upper-lower)+lower;;
		this.y=rn.nextInt(upper-lower)+lower;;
	}

	/**
	 * get X coordinate
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * get Y coordinate
	 * @return y
	 */
	public int getY() {
		return y;
	}

	/**
	 * set X coordinate
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * set Y coordinate
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}	

}
