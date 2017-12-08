
public class Riddle {
	//INSTANCE VARIABLES
	/**
	 * the solution to the riddle.
	 */
	private String solution;
	
	//CONSTRUCTORS
	/**
	 * Making a riddle with a solution.
	 * @param sol the solution to the riddle.
	 */
	public Riddle (String sol) {
		solution = sol;
	}
	public String toString() {
		return "The answer to the riddle is " + solution;
	}
	
	// GETTERS
	/**
	 * Get the solution of the riddle
	 * 
	 * @return the solution
	 */
	public String getSolution() {
		return solution;
	}
}
