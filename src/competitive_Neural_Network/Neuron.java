package competitive_Neural_Network;
import java.util.Queue;
import java.util.LinkedList;
public class Neuron { //This class will create the Neurons
	private double weightX;
	private double weightY;
	private Queue<double[]> prevValues = new LinkedList<>();
	
	public Neuron(){
		return;
	}
	
	public Neuron(double X, double Y) {
		this.weightX = X;
		this.weightY = Y;
		double[] value = {X,Y};
		this.prevValues.add(value);
	}
	
	public double getX() {
		return this.weightX;
	}
	
	public double getY() {
		return this.weightY;
	}
	
	public void setX(double x) {
		this.weightX = x;
	}
	
	public void setY(double y) {
		this.weightY = y;
	}
	
	public void updateQueue() {
		double[] newValues = {this.weightX,this.weightY}; //The latest neuron Value
		
		if (prevValues.size()==3) { //If our queue has reached size of 3 remove the oldest value
			prevValues.poll();
			prevValues.add(newValues);
		}else {
			prevValues.add(newValues);
		}
	}
	
	public Queue<double[]> getQueue(){
		return this.prevValues;
	}
}
