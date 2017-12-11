import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JFrame {
	//INSTANCE VARIABLES made changes
	/**
	 * Whether the game has ended or not.
	 */
	private boolean gameEnded;
	
	/**
	 * A collection of the rooms the player can traverse through.
	 */
	private ArrayList<Room> rooms = new ArrayList<Room>();
	
	/**
	 * The player playing the game.
	 */
	private Player ourPlayer;
	
	/**
	 * The current background image of the room the player is in.
	 */
	private Image img;
	
	/**
	 * Panel in which appears on the JFrame.
	 */
	JPanel testPanel = new JPanel() {
		public void paintComponent(java.awt.Graphics g) {
			super.paintComponent(g);
			BufferedImage image = (BufferedImage)img;
			g.drawImage(image, 0, 0, 737, 700, this);
		}
	};
	
	/**
	 * Game constructor.
	 * @throws IOException
	 */
	public Game () throws IOException {
		super();
		/*
		 * Setting up the game's variables and content.
		 */
		//This game has 7 Riddles.
		Riddle riddle1 = new Riddle("K");
		Riddle riddle2 = new Riddle("C");
		Riddle riddle3 = new Riddle("S");
		Riddle riddle4 = new Riddle("R");
		Riddle riddle5 = new Riddle("O");
		Riddle riddle6 = new Riddle("S");
		Riddle riddle7 = new Riddle("C");
		Riddle riddle8 = new Riddle("CSROCKS");
		//This game has 7 Items.
		Item item1 = new Item ("K");
		Item item2 = new Item ("C");
		Item item3 = new Item ("S");
		Item item4 = new Item ("R");
		Item item5 = new Item ("O");
		Item item6 = new Item ("S");
		Item item7 = new Item ("C");
		//This game has 8 Rooms and 2 lose/win screens.
		Room room2C = new Room (riddle2, item2, ImageIO.read(new File("resources/Room2C.jpg")));
		Room room3S = new Room (riddle3, item3, ImageIO.read(new File("resources/Room3S.jpg")));
		Room room4R = new Room (riddle4, item4, ImageIO.read(new File("resources/Room4R.jpg")));
		Room room5O = new Room (riddle5, item5, ImageIO.read(new File("resources/Room5O.jpg")));
		Room room7C = new Room (riddle7, item7, ImageIO.read(new File("resources/Room7C.jpg")));
		Room room1K = new Room (riddle1, item1, ImageIO.read(new File("resources/Room1K.jpg")));
		Room room6S = new Room (riddle6, item6, ImageIO.read(new File("resources/Room6S.jpg")));
		Room room8CSROCKS = new Room (riddle8, null, ImageIO.read(new File("resources/Room8CSROCKS.jpg")));
		Room winScreen = new Room(null, null, ImageIO.read(new File("resources/Winner.jpg")));
		Room loseScreen = new Room(null, null, ImageIO.read(new File("resources/Over.jpg")));
		
		rooms.add(room1K);
		rooms.add(room2C);
		rooms.add(room3S);
		rooms.add(room4R);
		rooms.add(room5O);
		rooms.add(room6S);
		rooms.add(room7C);
		rooms.add(room8CSROCKS);
		rooms.add(winScreen);
		rooms.add(loseScreen);
		
		//This game has 1 player.
		ourPlayer = new Player();
		//gameEnded is set to false: as in it is still playing
		gameEnded = false;
		//Sets our first background as first room's background.
		img = rooms.get(0).getBackground();
		Audio backgr = new Audio("/BGM.wav");
		backgr.loop();
		
/*
* -------------------------------------------------------------------------------------------------------------
* Making displays on screen.
* -------------------------------------------------------------------------------------------------------------
*/
		//Making our display on our control panel. smaller size.
		JLabel panelDisplay = new JLabel("");
		panelDisplay.setMaximumSize(new Dimension(270, 70));
		panelDisplay.setOpaque(true);
		panelDisplay.setBackground(Color.black);
		panelDisplay.setBounds(40, 50, 270, 70);
		panelDisplay.setForeground(Color.green);
		panelDisplay.setFont(new Font("Arial", Font.PLAIN, 45));
		
		testPanel.add(panelDisplay);
		
		//Showing room number
		JLabel roomLabel = new JLabel("ROOM: " + rooms.get(0).getRoomNumber());
		roomLabel.setMaximumSize(new Dimension(122,30));
		roomLabel.setOpaque(true);
		roomLabel.setBackground(Color.black);
		roomLabel.setBounds(122+480, 0, 150, 30);
		roomLabel.setForeground(Color.green);
		roomLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		testPanel.add(roomLabel);
		
		//General Information output
		JLabel general = new JLabel("");
		general.setMaximumSize(new Dimension(480,30));
		general.setOpaque(true);
		general.setBackground(Color.black);
		general.setBounds(0, 0, 480, 30);
		general.setForeground(Color.green);
		general.setFont(new Font("Arial", Font.PLAIN, 30));
		
		testPanel.add(general);
		
		//Lives Display
		JLabel lives = new JLabel("LIVES: " + ourPlayer.getNumOfLives());
		lives.setMaximumSize(new Dimension(110,30));
		lives.setOpaque(true);
		lives.setBackground(Color.black);
		lives.setBounds(480, 0, 122, 30);
		lives.setForeground(Color.green);
		lives.setFont(new Font("Arial", Font.PLAIN, 30));
		
		testPanel.add(lives);
		
		//IMPORTANT INFORMATION
		JLabel howTo = new JLabel(" The solution is 1 letter of the alphabet.");
		howTo.setMaximumSize(new Dimension(491,30));
		howTo.setOpaque(true);
		howTo.setBackground(Color.black);
		howTo.setBounds(260, 650, 491, 30);
		howTo.setForeground(Color.green);
		howTo.setFont(new Font("Arial", Font.PLAIN, 20));
		
		testPanel.add(howTo);
		
/*
* -------------------------------------------------------------------------------------------------------------
* Making buttons on screen. 
* -------------------------------------------------------------------------------------------------------------
*/
		//Making the letter buttons for the button panel.
		int x = 29;
		int y = 135;
		int currentLetter = 'A';
		for (int height = 0; height < 5; height++) {
			for (int width = 0; width < 6; width++) {
				if (currentLetter > 'Z') {
					break;
				}
				JButton button = new JButton(Character.toString((char)currentLetter));
				button.setBounds(x, y, 49, 52);
				button.setFont(new Font("Arial", Font.PLAIN, 15));
				
				//Giving LETTER button functionality
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String currentDisplay = panelDisplay.getText() + button.getText();
						panelDisplay.setText(currentDisplay);
					}
				});
				
				testPanel.add(button);
				currentLetter += 1;
				x += 49;
			}
			if (currentLetter > 'Z') {
				break;
			}
			x = 29;
			y += 52;
		}
		//Making the delete and enter button on the button panel.
		JButton delete = new JButton("DELETE");
		delete.setBounds(x, y, 98, 52);
		delete.setFont(new Font("Arial", Font.PLAIN, 12));
		
		//Giving DELETE button functionality
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelDisplay.setText("");
			}
		});
		
		JButton enter = new JButton("ENTER");
		enter.setBounds(x+98, y, 98, 52);
		enter.setFont(new Font("Arial", Font.PLAIN, 15));
		
		//Giving ENTER button functionality
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Room currentRoom = rooms.get(ourPlayer.getLocation());
				if (currentRoom.solvePuzzle(panelDisplay.getText())) {
					Audio right = new Audio("/Correct.wav");
					right.play();
					currentRoom.setUnlocked(true);
					if (currentRoom.getRoomNumber() == 8) {
						backgr.stop();
						ourPlayer.setLocation(8);
						roomLabel.setText("");
						general.setText("");
						panelDisplay.setText("");
						Audio win = new Audio("/Congratulations.wav");
						win.play();
						img = rooms.get(ourPlayer.getLocation()).getBackground();
						repaint();
					} else {
						general.setText("You unlocked the next room.");
					}
				} else {
					general.setText("That is incorrect.");
					ourPlayer.loseLife();
					Audio wrong = new Audio("/Gun.wav");
					wrong.play();
					lives.setText("LIVES: " + ourPlayer.getNumOfLives());
					if (dead()) {
						backgr.stop();
						ourPlayer.setLocation(9);
						roomLabel.setText("");
						general.setText("");
						panelDisplay.setText("");
						Audio dead = new Audio("/Dead.wav");
						dead.play();
						img = rooms.get(ourPlayer.getLocation()).getBackground();
						repaint();
					}
				}
			}
		});
		
		testPanel.add(delete);
		testPanel.add(enter);
		
		//Making the move forward and move backward buttons.
		JButton forward = new JButton("Next Room");
		forward.setBounds(131, 640, 128, 40);
		forward.setFont(new Font("Arial", Font.PLAIN, 10));
		
		//Giving FORWARD button functionality
		forward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int currentLocation = ourPlayer.getLocation();
				if (currentLocation < rooms.size() && rooms.get(ourPlayer.getLocation()).isUnlocked()) {
					ourPlayer.setLocation(currentLocation + 1);
					roomLabel.setText("ROOM: " + rooms.get(ourPlayer.getLocation()).getRoomNumber());
					general.setText("");
					panelDisplay.setText("");
					if (rooms.get(ourPlayer.getLocation()).getRoomNumber() == 8) {
						howTo.setText(" The solution is a string of letters.");
					}
					img = rooms.get(ourPlayer.getLocation()).getBackground();
					repaint();
				} else if (!rooms.get(ourPlayer.getLocation()).isUnlocked()) {
					general.setText("The door is locked.");
				}
			}
		});
				
		JButton backward = new JButton("Previous Room");
		backward.setBounds(0, 640, 128, 40);
		backward.setFont(new Font("Arial", Font.PLAIN, 10));
		
		//Giving BACKWARD button functionality
		backward.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ourPlayer.getLocation() == 0) {
					general.setText("You are in the first room.");
				} else {
					ourPlayer.setLocation(ourPlayer.getLocation() - 1);
					general.setText("");
					panelDisplay.setText("");
					roomLabel.setText("ROOM: " + rooms.get(ourPlayer.getLocation()).getRoomNumber());
					img = rooms.get(ourPlayer.getLocation()).getBackground();
					repaint();
				}
			}
		});
		
		testPanel.add(forward);
		testPanel.add(backward);
		
		testPanel.setLayout(null);
		add(testPanel);
	}
	
	//GETTERS---------------------------------------------------------------------------------------------
	/**
	 * Checks to see if the game is still playing or not
	 * @return false if the game did not end.
	 */
	public boolean getGameEnded() {
		return gameEnded;
	}
	/**
	 * Gets the list of rooms.
	 * @return an arraylist of rooms.
	 */
	public ArrayList<Room> getRooms() {
		return rooms;
	}
	/**
	 * Gets the player of the game.
	 * @return the player of the game.
	 */
	public Player getPlayer() {
		return ourPlayer;
	}
	
	//SETTERS---------------------------------------------------------------------------------------------
	/**
	 * Allows the program to finish the game.
	 * @param ended whether the game should end or not.
	 */
	public void setGameEnded(boolean ended) {
		gameEnded = ended;
	}
	
	/**
	 * Allows the program to change the background image.
	 * @param back the current background image we are switching to.
	 */
	public void setImage(Image back) {
		img = back;
	}
	
	//OTHER METHODS---------------------------------------------------------------------------------------------
	/**
	 * Tells the program whether the player is dead or not.
	 * @return
	 */
	public boolean dead() {
		return ourPlayer.getNumOfLives() == 0;
	}
	
	/**
	 * paint method.
	 */
	public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
    }
	
	/**
	 * Main program that plays the game.
	 * @param args
	 * @throws InterruptedException
	 * @throws IOException 
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		//MAKING A GAME AND SETTING UP ITS FRAME
		Game game = new Game();
		game.setTitle("RIDDLE ESCAPE");
		game.setSize(742, 715);
		game.setLocationRelativeTo(null);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setResizable(false);
		game.setVisible(true);
		//game.setIconImage(ImageIO.read(new File("resources/start.jpg")));
	}
}
