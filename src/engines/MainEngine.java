package engines;

import competitive_Neural_Network.LVQ;
//import gui_output.Window;
import java.util.ArrayList;
//import java.util.Scanner;
import java.util.Scanner;

import spots.Spot;
import writer_reader.Writer;

public class MainEngine {
	private static Scanner input = new Scanner(System.in);
	private int exampleNumber = 50;
	
	public void createSpots() {
		Spot s = new Spot();
		ArrayList<Spot> spots = s.handleSpotCreation(exampleNumber);
		Writer w = new Writer();
		w.writeSpots(spots);
		return;
	}
	
	public static void main(String[] args) {
		MainEngine client = new MainEngine();
		
		for(int i=0;i<5;i++){
			LVQ L = new LVQ();
			
			if(i==0){
				client.createSpots();
				System.out.println("Created file with name Spots.txt");
				L.execLVQ();
				System.out.println("Repeat?");
				String answer = input.next();
				if(answer.equals("n")|| answer.contentEquals("N")) {
					System.out.println("Exiting...");
					return;
				}
			}else{
				System.out.println("\nRepeat "+i);
				L.execLVQ();
			}
		}
			//Window frame = new Window();
			//frame.createWindow();		
		System.out.println("Exiting...");
	}
}