package spots;
import java.util.Random;
import java.lang.Math;

public class Spot 
{
	//private String type;
	public double x;
	public double y;
	private Random coordinator = new Random();
	
	/* min is the minimun number we can have in integer
	 * max is the maximum number we can have in integer
	 * n is the number of decimals we want
	 */
	
	public double genPrice(int min, int max, int n) { // n is the number of digits in the number
		int range = max - min; //This shows the distance between max and min ;
		
		if (n == 0) {
			double number = coordinator.nextInt(range)+1;
			return number + min;
		}else {
			int base = (int) Math.pow(10,n-1); //This is the multiplying base AKA the digits handler
			double number = coordinator.nextInt(range * base) + (min * base);
			number = number/Math.pow(10,n);
			return number;
		}
	}

	public Spot(int digits){
	}
	
	public double getX() 
	{
		return this.x;
	}
	
	public double getY() 
	{
		return this.y;
	}
}
