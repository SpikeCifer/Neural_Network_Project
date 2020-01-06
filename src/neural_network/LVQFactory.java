package neural_network;

import java.util.ArrayList;
import java.util.Scanner;
import writer_reader.FileParser;

public class LVQFactory {
	Scanner input = new Scanner(System.in);
	
	public double[] parseExample(String line) {
		String[] coordinates = line.split(",");
		double x = Double.parseDouble(coordinates[0]);
		double y = Double.parseDouble(coordinates[1]);
		
		double [] example = {x,y};
		
		return example;
	}
	
	//This method prepares the list with all the examples
	public ArrayList<double[]> createExamplesList() {
		ArrayList<double[]> examples = new ArrayList<double[]>();
		
		FileParser f = new FileParser();
		Scanner reader = f.readExamplesFile(); //The parser will be reading from our file with examples
		
		while (reader.hasNextLine()) {
			String line = reader.nextLine();
			examples.add(parseExample(line));
		}
		
		return examples;
	}
	//Initialize the engine with M number of Neurons S max seasons and examplesList the list with examples
	public LVQEngine initLVQ(){
		ArrayList<double[]> examplesList = createExamplesList();
		
		System.out.println("How many neurons do you want?");
		int M = input.nextInt();
		
		System.out.println("What should the max season number be?");
		int S = input.nextInt();
		
		LVQEngine L = new LVQEngine(M, S, examplesList);
		return L;
	}

}
