package gui_output;

import javax.swing.JFrame;

public class Window {
	public void createWindow() {
		JFrame frame = new JFrame("Final Output");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close Frame when Exit
		frame.pack(); //Size the frame
		frame.setVisible(true); //show the frame
		return;
	}
}
