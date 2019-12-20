package engines;

import competitive_Neural_Network.LVQ;
import gui_output.Window;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

import spots.Spot;

public class MainEngine {
	private Scanner input;
	
	public void createSpots() {
		Spot s = new Spot();
		ArrayList<Spot> spots = s.handleSpotCreation();
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
	
	public int handleMenu() {
		input = new Scanner(System.in);
		
		System.out.println("1.Create a text file with coordinates of random spots or \n"
				+ "2.Use an already existing text file of spots and organize them \n"
				+ "And organize them");
		System.out.println("To exit just enter 3");
		System.out.println("What would you like to do?");
		
		int opt = input.nextInt();
		return opt;
	}
	
	public static void main(String[] args) {
		MainEngine client = new MainEngine();
		int opt = 0;
		
		System.out.println("Hello and Welcome to this Neural Networks Project");
		System.out.println("In this project you can do one of the following things");
		
		opt = client.handleMenu();
		
		switch (opt){
			case 1: 
				client.createSpots();
				System.out.println("Created file with name Spots.txt");
				LVQ L = new LVQ();
				L.execLVQ();
				Window frame = new Window();
				frame.createWindow();
				break;
			case 2:
				System.out.println("Select file");
				break;
			case 3:
				System.out.println("Exiting...");
				return;
		}
		
		System.out.println("Exiting...");
	}
}