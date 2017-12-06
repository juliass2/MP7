import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Game extends JPanel{
	//INSTANCE VARIABLES
	private boolean gameEnded;
	private ArrayList<Room> rooms;
	private Player ourPlayer;
	
	public Game () {
		//This game has 7 Riddles.
		Riddle riddle1 = new Riddle("");
		Riddle riddle2 = new Riddle("");
		Riddle riddle3 = new Riddle("");
		Riddle riddle4 = new Riddle("");
		Riddle riddle5 = new Riddle("");
		Riddle riddle6 = new Riddle("");
		Riddle riddle7 = new Riddle("");
		//This game has 7 Items.
		Item item1 = new Item ("", "");
		Item item2 = new Item ("", "");
		Item item3 = new Item ("", "");
		Item item4 = new Item ("", "");
		Item item5 = new Item ("", "");
		Item item6 = new Item ("", "");
		Item item7 = new Item ("", "");
		//This game has 7 Rooms.
		rooms.add(new Room (riddle1, item1));
		rooms.add(new Room (riddle2, item2));
		rooms.add(new Room (riddle3, item3));
		rooms.add(new Room (riddle4, item4));
		rooms.add(new Room (riddle5, item5));
		rooms.add(new Room (riddle6, item6));
		rooms.add(new Room (riddle7, item7));
		//This game has 1 player.
		ourPlayer = new Player();
		gameEnded = false;
	}
	
	/**
	 * Checks to see if the game is still playing or not
	 * @return false if the game did not end.
	 */
	public boolean getGameEnded() {
		return gameEnded;
	}
	
	public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
    }
	
	/**
	 * Main program that plays the game.
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		JFrame myFrame = new JFrame("GETOUTTAHERE");
		Game game = new Game();
		myFrame.add(game);
		myFrame.setSize(900,800);
		myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
	}

}
