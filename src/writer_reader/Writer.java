package writer_reader;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import neurons.Neuron;
import spots.Spot;

public class Writer {
	public void writeSpots(ArrayList<Spot> spots) {
		PrintWriter writer;
		try {
			writer = new PrintWriter("Spots.txt", "UTF-8");
			for (Spot s1 : spots) {
				writer.println(s1.getX() + "," + s1.getY());
			}
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Spots.txt File not Found");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.out.println("This type of Encoding is not supported");
			e.printStackTrace();
		}
		return;
	}
	
	public void writeNeurons(ArrayList<Neuron> Neurons) {
		PrintWriter writer;
		try {
			writer = new PrintWriter("Neurons.txt", "UTF-8");
			for (Neuron n : Neurons) {
				writer.println(n.getX() + "," + n.getY());
			}
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Spots.txt File not Found");
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			System.out.println("This type of Encoding is not supported");
			e.printStackTrace();
		}
		return;
	}
}
