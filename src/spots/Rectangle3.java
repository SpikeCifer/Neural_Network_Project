package spots;

public class Rectangle3 extends Spot {

	public Rectangle3(int digits) {
		super(digits);
		this.x = genPrice(5,11,digits);
		this.y = genPrice(-11,-5,digits);
	}

}
