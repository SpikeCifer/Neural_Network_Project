package gui_output;

import java.util.ArrayList;
import java.util.Scanner;

import secondaryMachines.RoundMachine;
import writer_reader.FileParser;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;


public class Window extends Application{
	private ArrayList<Line> axis = new ArrayList<Line>();
	private ArrayList<Label> labelsList = new ArrayList<Label>();
	private RoundMachine m = new RoundMachine();
	
	private int width = 1200; //The width of the window
	private int height = 1000; //The height of the window
	
	private int relX = width/2; //Trying to get the center of the screen on width dimension
	private int relY = height/2; //Trying to get the center of the screen on height dimension
	private int zoom = (width*height)/(3*10000);
	
	public void initWindow(String[] args) {
		launch(args);
	}

	public double[] parse(String line) {
		String[] coordinates = line.split(",");
		double x = Double.parseDouble(coordinates[0]);
		double y = Double.parseDouble(coordinates[1]);
		
		double [] example = {x,y};
		
		return example;
	}
	
	public void createAxisLines(){ //The two Axis lines of the window
		Line axisX = new Line();
		axisX.setStartX(0.0);
		axisX.setStartY(relY);
		axisX.setEndX(width);
		axisX.setEndY(relY);
		axis.add(axisX);
		
		Line axisY = new Line();
		axisY.setStartX(relX);
		axisY.setStartY(0);
		axisY.setEndX(relX);
		axisY.setEndY(height);
		axis.add(axisY);
		return;
	}
	
	private void createAxisPoints() {
		//Point 0.0
		Label point0 = new Label("0");
		point0.relocate(relX, relY);
		
		for (int i = 0; i<2;i++){
			for(int j=0; j<10; j++) {
				if (i==0 && j==0) continue;
				
				//Negative Y Axis
				Label pointY = new Label("-"+i+","+j);
				pointY.relocate(relX+2, relY + zoom*(i*10+j));
				labelsList.add(pointY);
				
				//Positive Y
				pointY = new Label(i+","+j);
				pointY.relocate(relX+2, relY-zoom*(i*10+j));
				labelsList.add(pointY);
				
				//Positive X Axis
				Label pointX = new Label(+i+","+j);
				pointX.relocate(relX+(zoom)*(i*10+j), relY+2);
				labelsList.add(pointX);
				
				//Negative X Axis
				pointX = new Label("-"+i+","+j);
				pointX.relocate(relX-(zoom)*(i*10+j), relY+2);
				labelsList.add(pointX);
			}
		}
	}
	
	
	private void createExamplePoints(Scanner reader) {
		while (reader.hasNextLine()){
			Label l = new Label("+");
			l.setTextFill(Color.RED);
			String line = reader.nextLine();
			
			double[] coordinates = parse(line);
			coordinates[0] = coordinates[0]*zoom*10;
			coordinates[1] = coordinates[1]*zoom*10;
			double reloX = relX + coordinates[0];
			double reloY = relY - coordinates[1];
			
			l.relocate(reloX,reloY);
			
			labelsList.add(l);
		}
		return;
	}
	
	private void createNeuronPoints(Scanner reader) {
		while(reader.hasNextLine()) {
			Label l = new Label("*");
			l.setTextFill(Color.BLUE);
			String line = reader.nextLine();
			
			double[] coordinates = parse(line);
			coordinates[0] = coordinates[0]*zoom*10;
			coordinates[1] = coordinates[1]*zoom*10;
			
			double reloX = relX + coordinates[0];
			double reloY = relY - coordinates[1];
			reloX = m.round(reloX);
			reloY = m.round(reloY);
		
			l.relocate(reloX,reloY);
			labelsList.add(l);
		}
		return;
	}
	
	public Scene handleScene() {
		Pane root = new Pane();
		Scene scene = new Scene(root);
		FileParser f = new FileParser();
		
		createAxisLines();
		createAxisPoints();
		
		Scanner reader = f.readExamplesFile(); 
		createExamplePoints(reader);
		
		reader = f.readNeuronsFile();
		createNeuronPoints(reader);
		
		root.getChildren().addAll(axis);
		root.getChildren().addAll(labelsList);
		
		return scene;
	}

	public void start(Stage stage) throws Exception {
		stage.setTitle("Neural Network's Result");
		stage.setWidth(width);
		stage.setHeight(height);
		
		Scene scene = handleScene();
	    stage.setScene(scene);
	    
	    stage.show();
	}
}

		