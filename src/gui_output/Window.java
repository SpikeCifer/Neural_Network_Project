package gui_output;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;

public class Window extends JFrame{
	
	private JLabel item1;
	
	public Window() {
		super("The title bar");
		setLayout(new FlowLayout());
		item1 = new JLabel("This is a sentence");
	}
	public void createWindow() {
		JFrame frame = new JFrame("Final Output");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close Frame when Exit
		frame.pack(); //Size the frame
		frame.setVisible(true); //show the frame
		return;
	}
}
