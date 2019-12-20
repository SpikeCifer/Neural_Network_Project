package gui_output;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JPanel;

public class Point extends JPanel {
		public void paintComponent(Graphics g) {
		    super.paintComponent(g);

		    Graphics2D g2d = (Graphics2D) g;

		    g2d.setColor(Color.black);

		    for (int i = 0; i <= 600; i++) {
		    	Dimension size = getSize();
		    	int w = size.width;
		    	int h = size.height;
		    	
		    	Random r = new Random();
		    	int x = Math.abs(r.nextInt()) % w;
		    	int y = Math.abs(r.nextInt()) % h;
		    	g2d.drawLine(x, y, x, y);
		    }
		}
}
