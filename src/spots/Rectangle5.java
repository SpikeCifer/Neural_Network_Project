package spots;

public class Rectangle5 extends Spot {
	public Rectangle5(int digits) {
		super(digits);
		this.x = genPrice(-10,10,digits);
		this.y = genPrice(-10,10,digits);
	}
}
