import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;

public class DominoPath {

	private static final int numDominos = 10;
	private static int longestPath = 0;
	private static ArrayList<Domino> dominoBag = new ArrayList<Domino>();
	
	/**
	 * Creates a bag (an ArrayList, really) of random dominos.
	 */
	private static void createDominos() {
		for (int i = 0; i < numDominos; i++) {
			int value1 = (int) (Math.random() * 6.0) + 1;
			int value2 = (int) (Math.random() * 6.0) + 2;
			dominoBag.add(new Domino(value1, value2));
		}
	}
	
	/**
	 * Iterate through every possible starting position from the bag of dominoes,
	 * and find the longest possible path from among all of the starting positions.
	 * @return The longest path length encountered while evaluating every start position.
	 */
	private static int findLongestPath() {
		// TODO: Fill this out
		throw new NotImplementedException();
	}
	
	/**
	 * The main entry point; creates the bag of random dominoes and finds the longest possible path
	 * that may be constructed from it.
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		createDominos();
		
		int maxLength = findLongestPath();
		
		System.out.println("Longest path length is " + maxLength + "\n");
	}

}
