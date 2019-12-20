package gui_output;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window{
	public void createWindow() {
		System.out.println("Creating window");
		 Point point = new Point();
		    JFrame frame = new JFrame("Final_Output");
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.add(point);
		    frame.setSize(400, 400);
		    frame.setLocationRelativeTo(null);
		    frame.setVisible(true);
	}
}
