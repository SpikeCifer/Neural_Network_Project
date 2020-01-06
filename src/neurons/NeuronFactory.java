package neurons;

import java.util.ArrayList;
import java.util.Random;

public class NeuronFactory{
	
	public ArrayList<Neuron> getNuerons(ArrayList<double[]> examplesList, int M){
		ArrayList<Neuron> neurons = new ArrayList<Neuron>();
		int position; //The number of the random example we will use for our neurons
		Random r = new Random();
		int range = examplesList.size(); //the range of random number it can get
		
		for(int i=0; i<M; i++){
			position = r.nextInt(range); //get a random line from our text with examples
			double [] l = examplesList.get(position);
			
			double x = l[0];
			double y = l[1];
			
			Neuron n = new Neuron(x,y);
			neurons.add(n);
		}
		
		return neurons;
	}
}
