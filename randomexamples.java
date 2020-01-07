import java.util.*;

public class randomexamples {

	Random rand = new Random();

	public  double random1(){
		return (-2.0) + Math.random() * ((2.0) - (-2.0));
	}
	public  double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	
	public  int random1(int p){
		int value  = rand.nextInt(101);
		if (value<=p) {
			return 1;
		}
		return 0;
	}
	
	public int randomcenter(int size ) {
		Random r = new Random();
		int result = r.nextInt(size-0) + 0;
		return result ;
	}
	
	

}
