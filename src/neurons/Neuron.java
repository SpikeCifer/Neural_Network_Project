package neurons;
import java.util.Queue;
import java.util.LinkedList;
public class Neuron { //This class will create the Neurons
	private double weightX;
	private double weightY;
	private Queue<double[]> prevValues = new LinkedList<>(); //This Queue will hold up to 3 values of the neuron, if the neuron does not change then terminate
	private double fault;
	
	public Neuron(double X, double Y) {
		this.weightX = X;
		this.weightY = Y;
		double[] value = {X,Y};
		this.prevValues.add(value);
		this.fault = 0; //Initial value = 0
	}
	public void updateQueue() {
		double[] newValues = {this.weightX,this.weightY}; //The latest neuron Value
		
		if (prevValues.size()==3) { //If our queue has reached size of 3 remove the oldest value
			prevValues.poll();	//This pops the oldest value
			prevValues.add(newValues);
		}else {
			prevValues.add(newValues);
		}
	}
	
	public Queue<double[]> getQueue(){
		return this.prevValues;
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
	
	public double getFault() {
		
		return this.fault;
	}
	
	public void setFault(double fault) {
		this.fault = fault;
	}
}
