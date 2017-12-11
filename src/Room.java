import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Room {
	//INSTANCE VARIABLES
	/**
	 * Room's riddle player needs to solve.
	 */
	private Riddle roomsRiddle;
	
	/**
	 * Whether the next room is locked or not.
	 */
	private boolean nextUnlocked;
	
	/**
	 * Which letter from CSROCKS this room has.
	 */
	private Item roomsItem;
	
	/**
	 * Background of room.
	 */
	private Image background;
	
	/**
	 * Room's number. The order in which it's answer appears in the FINAL answer.
	 */
	private int roomNumber;
	
	/**
	 * Total rooms made.
	 */
	static private int roomsMade = 0;
	
	//CONSTRUCTOR
	/**
	 * Constructor for making a room.
	 * @param inputRiddle the room's riddle
	 * @param inputItem the room's letter from CSROCKS
	 * @throws IOException 
	 */
	public Room(Riddle inputRiddle, Item inputItem, BufferedImage back) throws IOException {
		roomsRiddle = inputRiddle;
		nextUnlocked = false;
		roomsItem = inputItem;
		background = back;
		roomNumber = ++roomsMade;
	}
	
	//GETTERS
	/**
	 * get's this room's background.
	 * @return this room's background.
	 */
	public Image getBackground() {
		return background;
	}
	
	/**
	 * allows player to find out if the next room is locked or not.
	 * @return true if it is unlocked, false if it is locked.
	 */
	public boolean isUnlocked() {
		return nextUnlocked;
	}
	
	/**
	 * allows player to look at the riddle.
	 * @return the riddle.
	 */
	public Riddle readRiddle() {
		return roomsRiddle;
	}
	
	/**
	 * allows program to get the room's item.
	 * @return the room's item.
	 */
	public Item getItem() {
		return roomsItem;
	}
	
	//SETTERS
	/**
	 * allows program to set whether the next room is accessible or not.
	 * @param b true if the next room is unlocked/accessible, false otherwise.
	 */
	public void setUnlocked(boolean b) {
		nextUnlocked = b;
	}
	
	/**
	 * allows program to get the room's number.
	 * @return the room's number.
	 */
	public int getRoomNumber() {
		return roomNumber;
	}
	
	//METHODS
	/**
	 * Allows player to try and solve room's puzzle.
	 * @param playerGuess the player's inputed guess.
	 * @return whether the player is correct or not.
	 */
	public boolean solvePuzzle(String playerGuess) {
		if (playerGuess.equals(roomsRiddle.getSolution())) {
			return true;
		} else {
			Player player = new Player();
			player.loseLife();
			return false;
		}
	}
}
