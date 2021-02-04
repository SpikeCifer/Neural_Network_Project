package neural_network;

import java.util.ArrayList;
import neurons.Neuron;
import neurons.NeuronFactory;
import secondaryMachines.RoundMachine;
import writer_reader.Writer;

public class LVQEngine {
	private int M; //Number of competitive Neurons
	private int maxSeasons; //Max number of Seasons
	private ArrayList<Neuron> neuronsList; //Array List with the neurons created
	private ArrayList<double[]> examplesList; //ArrayList with all the examples
	private RoundMachine m = new RoundMachine();
	private double minFault = 999999;
	
	public LVQEngine(int neuronNumber, int seasons, ArrayList<double[]> examples) {
		this.M = neuronNumber;
		this.maxSeasons = seasons;
		this.examplesList = examples;
	}
	
	public void showNeurons() {
		for (Neuron n : neuronsList) {
			System.out.println(n.getX()+","+n.getY());
		}
		System.out.println();
		return;
	}
	
	private double findTeamFault() {
		double totalSum = 0;
		
		for(double [] example: examplesList) {
			//Find the center of each team
			int min = findMin(example); 
			Neuron center = neuronsList.get(min);
			
			//Set new team Fault
			double sum = center.getFault() + calcDistance(example,center);
			center.setFault(sum);
		}
		
		for(Neuron n: neuronsList) {
			totalSum+=n.getFault();
		}
		
		return totalSum;
	}	
	
	public double calcDistance(double[] example, Neuron n) {
		double xDef = n.getX()-example[0];		
		double yDef = n.getY()-example[1];
		
		xDef = Math.pow(xDef,2);
		yDef = Math.pow(yDef,2);
		double sum = xDef + yDef;
		
		double result = Math.sqrt(sum);
		result = m.round(result);
		return result;
	}
	
	public int findMin(double[] example) {
		int min=0;
		double minDistance = 99999;
		double distance;
		
		for (Neuron neuron: neuronsList) { //Calculate distances of neurons
			distance = calcDistance(example,neuron);
			
			if (distance < minDistance) {
				minDistance = distance;
				min = neuronsList.indexOf(neuron);
			}	
		}		
		return min;
	}
	
	public boolean terminate(int seasons) {
		int c1=0;
		
		for (Neuron neuron: neuronsList) {
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
		if(c1 == M || seasons == maxSeasons) return true;
		return false;
	}
	
	public void updateNeuron(Neuron n, double[] example, double changeRate) {
		double changepart = changeRate*(example[0] - n.getX());
		double res = n.getX() + changepart;
		res = m.round(res);
		n.setX(res);
		
		changepart = changeRate*(example[1] - n.getY());
		res = n.getY() + changepart;
		res = m.round(res);
		n.setY(res);
		return;
	}
	
	public void execLVQ() {
		NeuronFactory n = new NeuronFactory();
		this.neuronsList = n.getNuerons(this.examplesList, this.M);
		Writer w = new Writer();
		
		int min = -2;
		int s = 0;
		double changeRate = 0.1;
		
		do {	
			for(double [] example: examplesList) {
				//First find the winner neuron AKA the neuron with the smallest distance from the example's spot
				min = findMin(example); 
				Neuron winner = neuronsList.get(min);
				
				//Update the winner neuron while keeping the rest, the same
				updateNeuron(winner,example,changeRate);			
				winner.updateQueue();
			}
			changeRate = 0.95*changeRate;
			s++; //Increase season counter after completing a full set, this will be used for a max number of processes so that we don't run the program forever
		} while(!terminate(s));
		
		double fault = findTeamFault();
		if (fault < minFault) {
			System.out.println("Changed");
			minFault = fault;
			w.writeNeurons(neuronsList);
		}	
		return;
	}

	
}
