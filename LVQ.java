package competitive_Neural_Network;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LVQ { //This class will execute the LVQ algorithm
	private int M = 4; //Number of teams as well as the number of neurons
	private int maxSeasons = 10;
	private double changeRate = 0.1; //The change rate
	
	private ArrayList<Neuron> neurons = new ArrayList<Neuron>(); //Array List with the neurons created
	private ArrayList<double[]> examples = new ArrayList<double[]>();
	
	public double[] createExample(String line) {
		String[] coordinates = line.split(",");
		double x = Double.parseDouble(coordinates[0]);
		double y = Double.parseDouble(coordinates[1]);
		double [] example = {x,y};
		return example;
	}
	
	public Scanner readFile() { //Creates file reader
		try {
			File f = new File("Spots.txt");
			Scanner reader = new Scanner(f);
			return reader;
		
		}catch(FileNotFoundException e) {
			System.out.println("The file you requested was not found");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void initLVQ() {	
		int position;
		Scanner reader = readFile(); //The parser will be reading from our file with examples
		Random r = new Random();
		
		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			examples.add(createExample(line));
		}
		
		int range = examples.size();
		
		for(int i=0; i<M; i++){
			position = r.nextInt(range);
			double [] l = examples.get(position);
			double x = l[0];
			double y = l[1];
			Neuron n = new Neuron(x,y);
			neurons.add(n);
		}
		
		return;
		/*
		System.out.println("Each and every neuron should"
				+ "calculate it's center's distance from the input"
				+ "change it's value according to a formula");
		*/
	}
	
	public double calcDistance(double[] example, Neuron n) {
		double xDistance = Math.pow(n.getX()-example[0],2);
		double yDistance = Math.pow(n.getY()-example[1],2);
		double sum = xDistance + yDistance;
		double result = Math.sqrt(sum);
		return result;
	}
	
	public boolean terminate(int seasons, int repeats) {
		if (seasons>maxSeasons) return true;
		return false;
	}
	
	public void execLVQ() {
		initLVQ();
		int minNeuronPointer = -2;
		int s = 0;
		int t = 0;
		double distance;
		int d;
		
		do{
			t = 0;
			for(double [] example: examples) { //Read lines from file
				d=0;
				
				double minDistance = 99999;
				
				for (Neuron neuron: neurons) { //Calculate distances of neurons
					distance = calcDistance(example,neuron);
					
					if (distance < minDistance) {
						minDistance = distance;
						minNeuronPointer = d;
					}	
					
					d++;	
				}

				
				t++; //Increase repeat counter after 1 (we will need to store 3 values for each neuron
			}
			
			s++; //Increase season counter after completing a full set, this will be used for a max number of processes so that we don't run the program forever
		
		}while(terminate(s,t)); // if none of the values of all neuron have changed for repeat numbers t,t-1,t-2 exit
		System.out.println(s+" "+t);
		return;
	}
}