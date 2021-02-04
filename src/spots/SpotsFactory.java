package spots;

import java.util.ArrayList;
import writer_reader.Writer;

public class SpotsFactory {
	private int exampleNumber;
	
	/* [-1.1,-0.5] x [0.5,1.1],  
	 * [-1.1,-0.5] x [-1.1,-0.5]
	 * [0.5,1.1] x [-1.1,-0.5]
	 * [0.5,1.1] x [0.5,1.1],
	 * [-1.0,1.0] x [-1.0,1.0].
	 */
	
	public SpotsFactory(int Number) {
		this.exampleNumber = Number;
	}
	
	public ArrayList<Spot> handleSpotCreation(int E){
		ArrayList<Spot> spots = new ArrayList<Spot>();
		//System.out.println("How accurate do you want each spot coordinate to be? (in digits)");
		int digits = 2;//input.nextInt();
		int i;
	
		for(i=0;i<E;i++) {
			// TODO:
			// 1. Replace with switch block (it's a factory and only in one place)
			// 2. Remove extra Rectangle Classes, as the only difference can be parametrized
			
			if (i<100) {
				spots.add(new CircleSpot(digits)); //Create spots inside circle with (0,0) as center and radius = 0.3
			}else if (i<200) {
				spots.add(new Rectangle1(digits)); //Create spots inside a [-1.1,-0.5] x [0.5,1.1], square
			}else if (i<300) {
				spots.add(new Rectangle2(digits)); //Create spots inside a [-1.1,-0.5] x [-1.1,-0.5] square
			}else if (i<400) {
				spots.add(new Rectangle3(digits)); //Create spots inside a [0.5,1.1] x [-1.1,-0.5] square
			}else if (i<500) {
				spots.add(new Rectangle4(digits)); //Create spots inside a  [0.5,1.1] x [0.5,1.1] square
			}else if (i<600) {
				spots.add(new Rectangle5(digits)); //Create spots inside a  [-1,1] x [-1,1] square
			}
			
		}
		
		return spots;
	}
	
	public void createSpots() {
		ArrayList<Spot> spots = handleSpotCreation(exampleNumber);
		Writer w = new Writer();
		w.writeSpots(spots);
		return;
	}
}
