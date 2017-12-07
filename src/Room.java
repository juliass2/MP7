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
	 * Whether the room is locked or not.
	 */
	private boolean unlocked;
	
	/**
	 * Which letter from CSROCKS this room has.
	 */
	private Item roomsItem;
	
	/**
	 * Background of room.
	 */
	private Image background;
	
	//CONSTRUCTOR
	/**
	 * Constructor for making a room.
	 * @param inputRiddle the room's riddle
	 * @param inputItem the room's letter from CSROCKS
	 * @throws IOException 
	 */
	public Room(Riddle inputRiddle, Item inputItem, BufferedImage back) throws IOException {
		roomsRiddle = inputRiddle;
		unlocked = false;
		roomsItem = inputItem;
		background = back;
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
		return unlocked;
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
	
	//METHODS
	/**
	 * Allows player to try and solve room's puzzle.
	 * @param playerGuess the player's inputed guess.
	 * @return whether the player is correct or not.
	 */
	public boolean solvePuzzle(String playerGuess) {
		return false;
	}
}
