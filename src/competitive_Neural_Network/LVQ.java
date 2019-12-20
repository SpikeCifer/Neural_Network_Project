package competitive_Neural_Network;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LVQ { //This class will execute the LVQ algorithm
	private int M = 4; //Number of teams as well as the number of neurons
	private int maxSeasons = 10; //Max number of going through all examples
	
	private ArrayList<Neuron> neurons = new ArrayList<Neuron>(); //Array List with the neurons created
	private ArrayList<double[]> examples = new ArrayList<double[]>(); //ArrayList with all the examples
	
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
			position = r.nextInt(range); //get a random line
			double [] l = examples.get(position);
			
			double x = l[0];
			double y = l[1];
			
			Neuron n = new Neuron(x,y);
			neurons.add(n);
		}
		
		return;
	}
	
	public void showNeurons() {
		for (Neuron n : neurons) {
			System.out.println(n.getX()+","+n.getY());
		}
		return;
	}
	
	public double round(double number) {
		number = number*10000;
		number = (int) number;
		number = number/10000;
		return number;
	}
	
	public double calcDistance(double[] example, Neuron n) {
		double xDef = n.getX()-example[0];		
		double yDef = n.getY()-example[1];
		
		xDef = Math.pow(xDef,2);
		yDef = Math.pow(yDef,2);
		double sum = xDef + yDef;
		
		double result = Math.sqrt(sum);
		return round(result);
	}
	
	public int findMin(double[] example) {
		int d=0;
		int min=0;
		double minDistance = 99999;
		double distance;
		for (Neuron neuron: neurons) { //Calculate distances of neurons
			distance = calcDistance(example,neuron);
			if (distance < minDistance) {
				minDistance = distance;
				min = d;
			}	
			
			d++;	
		}
		return min;
	}
	
	public boolean terminate(int seasons) {
		int c1=0;
		
		for (Neuron neuron: neurons) {
			double X = neuron.getQueue().element()[0];
			double Y = neuron.getQueue().element()[1];
			
			int c2 = 0;
			for (double [] value: neuron.getQueue()) {
				if (value[0] == X && value[1] == Y) {
					c2++;
				}
			}
			if (c2==3) c1++;
		}
		
		if(c1==M) return true;
		if (seasons==maxSeasons) return true;
		return false;
	}
	
	public void updateNeuron(Neuron n, double[] example, double changeRate) {
		double res = n.getX() + changeRate*(example[0] - n.getX());
		n.setX(round(res));
		res = n.getY() + changeRate*(example[0] - n.getY());
		n.setY(round(res));
		return;
	}
	
	public void execLVQ() {
		initLVQ();
		int min = -2;
		int s = 0;
		double changeRate = 0.1;
		showNeurons();
		System.out.println();
		
		do{			
			for(double [] example: examples) {
				min = findMin(example); //First find the winner neuron AKA the neuron with the smallest distance from the example's spot
				Neuron winner = neurons.get(min);
				updateNeuron(winner,example,changeRate);			
				winner.updateQueue();
			}
			s++; //Increase season counter after completing a full set, this will be used for a max number of processes so that we don't run the program forever
			changeRate = 0.95*changeRate;
		}while(!terminate(s));
		showNeurons();
		//TODO: Find the team fault
		return;
	}
}