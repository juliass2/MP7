
public class Item {
	//INSTANCE VARIABLES
	/**
	 * which letter this item represents from CSROCKS
	 */
	private String value;
	
	/**
	 * which room this letter is obtained from.
	 */
	private int roomNumber;
	
	private static int roomsMade = 1;
	
	//CONSTRUCTORS
	/**
	 * Creates a letter from CSROCKS.
	 * @param v the letter it is from CSROCKS.
	 * @param d which room the letter is collected from.
	 */
	public Item(String v) {
		value = v;
		roomNumber = roomsMade++;
	}
	
	/**
	 * To string method which will access this item's value and description.
	 */
	public String toString() {
		return "You found "+ value + " in room " + roomNumber + "!";
	}
}
