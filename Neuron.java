package competitive_Neural_Network;

public class Neuron { //This class will create the Neurons
	private double weightX;
	private double weightY;
	
	public Neuron(){
		return;
	}
	
	public Neuron(double X, double Y) {
		this.weightX = X;
		this.weightY = Y;
	}
	
	public double getX() {
		return this.weightX;
	}
	
	public double getY() {
		return this.weightY;
	}
}
