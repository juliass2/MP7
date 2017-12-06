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
	
	//CONSTRUCTORS
	/**
	 * Constructing a basic player.
	 */
	public Player() {
		numOfLives = 5;
		items = new ArrayList<Item>();
	}
	
	//GETTERS
	/**
	 * Look at the remaining lives.
	 * @return number of lives remaining.
	 */
	public int getNumOfLives() {
		return numOfLives;
	}
	
	/**
	 * Getter method for items ArrayList.
	 * @return items arrayList
	 */
	public ArrayList<Item> getItems() {
		return items;
	}
	
	//METHODS
	/**
	 * Allows player to look at their current collection of CSROCKS.
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
	
	/**
	 * Allows the player to move forward or backward into another room.
	 * @param direction whether the player wants to move forward or back.
	 */
	public void move(String direction) {
		return;
	}
}
