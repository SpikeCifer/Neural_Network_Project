package spots;

public class Rectangle2 extends Spot {

	public Rectangle2(int digits) {
		super(digits);
		this.x = genPrice(-11,-5,digits);
		this.y = genPrice(-11,-5,digits);
	}

}
