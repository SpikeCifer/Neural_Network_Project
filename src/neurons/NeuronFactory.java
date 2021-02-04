package neurons;

import java.util.ArrayList;
import java.util.Random;

public class NeuronFactory{
	
	public ArrayList<Neuron> getNuerons(ArrayList<double[]> examplesList, int M){
		ArrayList<Neuron> neurons = new ArrayList<Neuron>();
		Random r = new Random();
		int range = examplesList.size(); //the range of random number it can get
		
		for(int i = 0; i < M; i++){
			double [] l = examplesList.get(r.nextInt(range));			
			Neuron n = new Neuron(l[0],l[1]);
			neurons.add(n);
		}
		
		return neurons;
	}
}
