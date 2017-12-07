import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class testPlayer {
	public static void main (String[]args) throws IOException {
		JFrame myFrame = new JFrame("GETOUTTAHERE");
		Game game = new Game();
		myFrame.add(game);
		myFrame.setSize(1200,1000);
		myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
		JButton moveForward = new JButton();
		moveForward.setText("More Forward");
	}
}
