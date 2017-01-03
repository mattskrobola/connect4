package Game;


import java.awt.image.BufferStrategy;
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;



	public class Window extends Canvas{
		public Window(int width, int height, String title, Connectfour game){
			JFrame frame = new JFrame(title);
			
			frame.setPreferredSize(new Dimension(width, height));
			frame.setMaximumSize(new Dimension(width, height));
			frame.setMinimumSize(new Dimension(width, height));
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // need this to close
			frame.setResizable(false); // can we rezize are window
			frame.setLocationRelativeTo(null); // this is not needed but our window would start at top left but now it starts int he middle
			frame.add(game); // adding game class into frame
			frame.setVisible(true); // visible
			game.start();
		}
	}