import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.Collections;
import java.util.ArrayList;

public class DominoPath {

	private static final int numDominos = 10;
	private static int longestPath = 0;
	private static ArrayList<Domino> dominoBag = new ArrayList<Domino>();
    private static ArrayList<ArrayList<Domino>> paths = new ArrayList<ArrayList<Domino>>();
	
	/**
	 * Creates a bag (an ArrayList, really) of random dominos.
	 */
	private static void createDominos() {
		for (int i = 0; i < numDominos; i++) {
			int val1 = (int) (Math.random() * 6.0) + 1;
			int val2 = (int) (Math.random() * 6.0) + 1;
			dominoBag.add(new Domino(val1, val2));
		}
	}
	
	/**
	 * Iterate through every possible starting position from the bag of dominoes,
	 * and find the longest possible path from among all of the starting positions.
	 * @return The longest path length encountered while evaluating every start position.
	 */

    private static ArrayList<Domino> getFreeDominos(){
        ArrayList<Domino> freeDominos = new ArrayList<Domino>();
        for (Domino d : dominoBag){
            if ( d.getFree() ) {
                freeDominos.add(d);
            }
        }
        return freeDominos;
    }

    private static ArrayList<Domino> potentialMatches(int val){

        ArrayList<Domino> potentialMatches = new ArrayList<Domino>();
        for (Domino d: getFreeDominos()) {
            if (d.getFree()){
                if (d.getValue1() == val || d.getValue2()==val){
                    potentialMatches.add(d);
                }
            }
        }
        return potentialMatches;
    }

    private static int longestOfPaths(){
        int longest = 0;
        for (ArrayList<Domino> path : paths) {
            if (path.size() > longest){
                longest = path.size();
            }
        }
        return longest;
    }

    private static void printSet(ArrayList<Domino> set){
        for (Domino d : set)  {
            System.out.print(d.printableOutput());
            System.out.print("  ");
        }
        System.out.print("\n");
    }

    private static void printPaths(){
        for (ArrayList<Domino> path : paths) {
            printSet(path);
        }
    }

	private static int findLongestPath() {
        for (Domino d : dominoBag){
            d.play(1);
            ArrayList<Domino> path = new ArrayList<Domino>();
            findAllPaths(d, d.getValue2(), path);
            d.play(2) ;
            ArrayList<Domino> path2 = new ArrayList<Domino>();
            findAllPaths(d, d.getValue1(), path2);
        }
        return longestOfPaths();
	}

    private static void resetBag(){
        for (Domino d : dominoBag){
            d.Free();
        }
    }

    private static void findAllPaths(Domino d, int val,  ArrayList<Domino> path) {
        ArrayList<Domino> freeDominos = getFreeDominos();
        //bag is empty, put everything back in the bag and return the length of the path
        if (freeDominos.size() == 0){
            printSet(path);
            resetBag();
            paths.add(path);
        }
        ArrayList<Domino> matches = potentialMatches(val) ;
        //no matches left in the bag
        if (matches.size()==0){
            printSet(path);
            resetBag();
            paths.add(path);
        }
        //in play, recurse through all available matching dominos
        else {
            for (Domino match : matches){
                d.match(match);
                path.add(match);
                findAllPaths(match, match.getFreeValue(), path);
                //somehow return the state of the bag to what it was before the above line???
            }
        }

    }


	/**
	 * The main entry point; creates the bag of random dominoes and finds the longest possible path
	 * that may be constructed from it.
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		createDominos();
		//printSet(dominoBag);
		int maxLength = findLongestPath();
		
		System.out.println("Longest path length is " + maxLength + "\n");
	}

}
