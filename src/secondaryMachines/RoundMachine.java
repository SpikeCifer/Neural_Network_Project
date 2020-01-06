package secondaryMachines;

public class RoundMachine {

	public double round(double y) {
		boolean positive = true;
		
		if(y<0) positive = false;
		y = Math.abs(y);
		y = y*1000;
		
		if(y%10>5) {
			y = y/10;
			y+=1;
		} else{
			y = y/10;	
		}
		y = (int) y;
		y = y/100;
		
		if(!positive) y = -y;
		return y;
	}
}