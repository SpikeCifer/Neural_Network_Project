package spots;
import java.util.Random;
import java.util.ArrayList;
import java.lang.Math;

public class Spot 
{
	private String type;
	private double x;
	private double y;
	
	Random coordinator = new Random();
	
	/* min is the minimun number we can have in integer
	 * max is the maximum number we can have in integer
	 * n is the number of decimals we want
	 */
	
	public double genPrice(int min, int max, int n) { // n is the number of digits in the number
		int range = max - min;
		if (n == 0) return (coordinator.nextInt(range)+1)+min;
		return ((coordinator.nextInt(range * (int)Math.pow(10,n-1))+1)+ (min* (int)Math.pow(10,n-1)))/Math.pow(10,n);
	}
	
	public Spot() {
		return;
	}
	
	public Spot(int type)
	{
		
		switch (type){
			case 1:
				this.type = "Circle Spot";
				do {
					this.x = genPrice(-3,3,4);
					this.y = genPrice(-3,3,4);	
				} while(x * x + y * y > 0.3 * 0.3 ); //Keep producing until spot is inside given circle
				break;
			case 2:
				this.type = "Square1 Spot";
				this.x = genPrice(-11,-5,4);
				this.y = genPrice(5,11,4);
				break;
			case 3:
				this.type = "Square2 Spot";
				this.x = genPrice(-11,-5,4);
				this.y = genPrice(-11,-5,4);
				break;
			case 4:
				this.type = "Square3 Spot";
				this.x = genPrice(5,11,4);
				this.y = genPrice(-11,-5,4);
				break;
			case 5:
				this.type = "Square4 Spot";
				this.x = genPrice(5,11,4);
				this.y = genPrice(5,11,4);
				break;
			case 6:
				this.type = "Square5 Spot";
				this.x = genPrice(-10,10,4);
				this.y = genPrice(-10,10,4);
				break;
		}
		
	}

	public ArrayList<Spot> handleSpotCreation()
	{
		ArrayList<Spot> spots = new ArrayList<Spot>();
		int i;
		
		for(i=0;i<600;i++) {
			if (i<100) {
				spots.add(new Spot(1)); //Create spots inside circle with (0,0) as center and radius = 0.3
			}else if (i<200) {
				spots.add(new Spot(2)); //Create spots inside a [-1.1,-0.5] x [0.5,1.1], square
			}else if (i<300) {
				spots.add(new Spot(3)); //Create spots inside a [-1.1,-0.5] x [-1.1,-0.5] square
			}else if (i<400) {
				spots.add(new Spot(4)); //Create spots inside a [0.5,1.1] x [-1.1,-0.5] square
			}else if (i<500) {
				spots.add(new Spot(5)); //Create spots inside a  [0.5,1.1] x [0.5,1.1] square
			}else {
				spots.add(new Spot(6)); //Create spots inside a  [-1,1] x [-1,1] square
			}
		}
		return spots;
		
	}
	
	public double getX() 
	{
		return this.x;
	}
	
	public double getY() 
	{
		return this.y;
	}
	
	public String getType() {
		return this.type;
	}
}
