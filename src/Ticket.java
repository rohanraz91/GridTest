import java.text.DecimalFormat;
import java.util.Random;

/**
 * @author razdanr
 *This class generates tickets
 *with different price.
 */
public class Ticket {

	private Double price;

	/**
	 * The constructor will
	 * set the random price
	 * of the ticket
	 */
	public Ticket(){
		Random rn=new Random();
		double amount=rn.nextDouble()*100+1;
		DecimalFormat df=new DecimalFormat("#.00");
		price=Double.parseDouble(df.format(amount));
	}

	/**
	 * Get price of each ticket
	 * @return priice
	 */
	public Double getPrice() {
		return price;
	}

}
