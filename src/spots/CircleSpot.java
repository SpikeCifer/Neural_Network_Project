package spots;

public class CircleSpot extends Spot {
	
	public CircleSpot(int digits) {
		super(digits);
		
		do {
			super.x = genPrice(-3,3,digits);
			super.y = genPrice(-3,3,digits);	
		} while(x * x + y * y > 0.3 * 0.3 ); //Keep producing until spot is inside given circle
	}

}
