import java.io.IOException;
import java.util.ArrayList;

public class Player {
	//INSTANCE VARIABLES
	/**
	 * Number of lives the player has throughout the game.
	 */
	private int numOfLives;

	/**
	 * The different letters of CSROCKS the player has.
	 */
	private ArrayList<Item> items;
	
	/**
	 * Location of the player
	 */
	private int location;

	/**
	 * Movement
	 */
	public final String[] MOVEMENTS = { new String("forward"), new String("back") };
	
	/** total number of rooms */
	public final int NUM_OF_ROOMS = 8;

	// CONSTRUCTORS
	/**
	 * Constructing a basic player.
	 */
	public Player() {
		numOfLives = 5;
		items = new ArrayList<Item>();
		location = 0;
	}

	// GETTERS
	/**
	 * Look at the remaining lives.
	 * 
	 * @return number of lives remaining.
	 */
	public int getNumOfLives() {
		return numOfLives;
	}

	/**
	 * Getter method for items ArrayList.
	 * 
	 * @return items arrayList
	 */
	public ArrayList<Item> getItems() {
		return items;
	}
	
	/**
	 * Getter method to return where the player is located
	 * 
	 * @return the room number the player is in
	 */
	public int getLocation() {
		return location;
	}

	//SETTERS
	/**
	 * Sets the player's current location to new value.
	 * @param x the new location we are setting location to.
	 */
	public void setLocation(int x) {
		location = x;
	}
	
	// METHODS
	/**
	 * Allows player to look at their current collection of CSROCKS.
	 * 
	 * @return the list of what hey currently have found
	 */
	public String lookItems() {
		String itemsList = "";
		for (int i = 0; i < items.size(); i++) {
			itemsList += items.get(i) + "\n";
		}
		return itemsList;
	}

	/**
	 * Player's life count decreases when this method is called.
	 */
	public void loseLife() {
		numOfLives--;
	}
}