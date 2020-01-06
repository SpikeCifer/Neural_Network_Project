package spots;

public class Rectangle4 extends Spot {

	public Rectangle4(int digits) {
		super(digits);
		this.x = genPrice(5,11,digits);
		this.y = genPrice(5,11,digits);
	}

}
