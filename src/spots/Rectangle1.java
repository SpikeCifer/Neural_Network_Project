package spots;

public class Rectangle1 extends Spot{

	public Rectangle1(int digits) {
		super(digits);
		this.x = genPrice(-11,-5,digits);
		this.y = genPrice(5,11,digits);
	}

}
