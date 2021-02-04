package neurons;

import java.util.ArrayList;
import java.util.Random;

public class NeuronFactory{
	private static int X_DIMENSION = 0;
	private static int Y_DIMENSION = 1;
	
	public ArrayList<Neuron> getNuerons(ArrayList<double[]> examplesList, int M){
		ArrayList<Neuron> neurons = new ArrayList<Neuron>();
		Random r = new Random();
		int range = examplesList.size(); //the range of random number it can get
		
		for(int i = 0; i < M; i++){
			double [] example = examplesList.get(r.nextInt(range));			
			Neuron n = new Neuron(example[X_DIMENSION],example[Y_DIMENSION]);
			neurons.add(n);
		}
		
		return neurons;
	}
}
