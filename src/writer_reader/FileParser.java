package writer_reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileParser {

	public Scanner readExamplesFile() { //Creates file reader
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
	
	public Scanner readNeuronsFile() { //Creates file reader
		try {
			File f = new File("Neurons.txt");
			Scanner reader = new Scanner(f);
			return reader;
		
		}catch(FileNotFoundException e) {
			System.out.println("The file you requested was not found");
			e.printStackTrace();
		}
		return null;
	}
}
