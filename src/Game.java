import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel{
	//INSTANCE VARIABLES
	private boolean gameEnded;
	private ArrayList<Room> rooms = new ArrayList<Room>();
	private Player ourPlayer;
	private Image img;
	
	public Game () throws IOException {
		//This game has 7 Riddles.
		Riddle riddle1 = new Riddle("K");
		Riddle riddle2 = new Riddle("C");
		Riddle riddle3 = new Riddle("S");
		Riddle riddle4 = new Riddle("R");
		Riddle riddle5 = new Riddle("O");
		Riddle riddle6 = new Riddle("S");
		Riddle riddle7 = new Riddle("C");
		//This game has 7 Items.
		Item item1 = new Item ("K");
		Item item2 = new Item ("C");
		Item item3 = new Item ("S");
		Item item4 = new Item ("R");
		Item item5 = new Item ("O");
		Item item6 = new Item ("S");
		Item item7 = new Item ("C");
		//This game has 7 Rooms.
		rooms.add(new Room (riddle1, item1, ImageIO.read(new File("resources/flower-purple-lical-blosso.jpg"))));
		rooms.add(new Room (riddle2, item2, ImageIO.read(new File("resources/dahlia-red-blossom.jpeg"))));
		rooms.add(new Room (riddle3, item3, ImageIO.read(new File("resources/flower-purple-lical-blosso.jpg"))));
		rooms.add(new Room (riddle4, item4, ImageIO.read(new File("resources/flower-purple-lical-blosso.jpg"))));
		rooms.add(new Room (riddle5, item5, ImageIO.read(new File("resources/flower-purple-lical-blosso.jpg"))));
		rooms.add(new Room (riddle6, item6, ImageIO.read(new File("resources/flower-purple-lical-blosso.jpg"))));
		rooms.add(new Room (riddle7, item7, ImageIO.read(new File("resources/flower-purple-lical-blosso.jpg"))));
		//This game has 1 player.
		ourPlayer = new Player();
		gameEnded = false;
		img = rooms.get(0).getBackground();
	}
	
	//GETTERS
	/**
	 * Checks to see if the game is still playing or not
	 * @return false if the game did not end.
	 */
	public boolean getGameEnded() {
		return gameEnded;
	}
	public ArrayList<Room> getRooms() {
		return rooms;
	}
	public Player getPlayer() {
		return ourPlayer;
	}
	public boolean dead() {
		Player player = new Player();
		return player.getNumOfLives() == 0;
	}
	
	//SETTERS
	public void setGameEnded(boolean ended) {
		gameEnded = ended;
	}
	public void setImage(Image back) {
		img = back;
	}
	
	public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
    }
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(img, 0, 0, null);
	}
	
	/**
	 * Main program that plays the game.
	 * @param args
	 * @throws InterruptedException
	 * @throws IOException 
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		JFrame myFrame = new JFrame("GETOUTTAHERE");
		Game game = new Game();
		myFrame.add(game);
		myFrame.setSize(1200,1000);
		myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		myFrame.setVisible(true);
		JButton moveForward = new JButton();
		moveForward.setText("More Forward");
		
		while (!game.getGameEnded()) {
			game.setImage(game.getRooms().get(1).getBackground());
			if (game.dead()) {
				game.setGameEnded(true);
			}
		}
		
	}

}
