package amosov4;

import java.awt.EventQueue;
import javax.swing.JFrame;


public class Task4Test 
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(() ->
		{
			
			JFrame frame_main = new mainFrame();
			frame_main.setTitle("Welcome");
			frame_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame_main.setVisible(true);
		});
	}
}
