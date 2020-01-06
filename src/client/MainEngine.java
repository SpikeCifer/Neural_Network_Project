package client;

import java.util.Scanner;

import gui_output.Window;
import neural_network.*;
import spots.SpotsFactory;

public class MainEngine {
	private int exampleNumber = 600;
	private static Scanner input;
	
	public void createSpotsFile() {
		SpotsFactory sFactory = new SpotsFactory(exampleNumber);
		sFactory.createSpots();
		return;
	}
	
	
	public static void main(String[] args) {
		MainEngine client = new MainEngine();
		System.out.println("Do you want a new file?");
		input = new Scanner(System.in);
		
		String answer = input.next();
		
		if(answer.equals("Y") || answer.equals("y")) {
			client.createSpotsFile();
			System.out.println("Created file with name Spots.txt");
		}

		LVQFactory LFactory = new LVQFactory();
		LVQEngine LEngine = LFactory.initLVQ();
		
		for (int i = 0; i<5;i++) {
			LEngine.execLVQ();
		}
		
		Window w = new Window();
		w.initWindow(args);
		System.out.println("Exiting...");
		
	}
}