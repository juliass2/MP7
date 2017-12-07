
public class Riddle {
	//INSTANCE VARIABLES
	/**
	 * the solution to the riddle.
	 */
	private String solution;
	
	/**
	 * Making a riddle with a solution.
	 * @param sol the solution to the riddle.
	 */
	public Riddle (String sol) {
		solution = sol;
	}
	public String toString() {
		return "The solution is " + solution;
	}
}
