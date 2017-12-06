
public class Item {
	//INSTANCE VARIABLES
	/**
	 * which letter this item represents from CSROCKS
	 */
	private String value;
	
	/**
	 * which room this letter is obtained from.
	 */
	private String description;
	
	//CONSTRUCTORS
	/**
	 * Creates a letter from CSROCKS.
	 * @param v the letter it is from CSROCKS.
	 * @param d which room the letter is collected from.
	 */
	public Item(String v, String d) {
		value = v;
		description = d;
	}
}
