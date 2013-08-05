import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import java.util.Collections;
import java.util.ArrayList;

public class DominoPath2 {

    private static final int numDominos = 10;
    //private static int longestPath = 0;
    public static ArrayList<Domino> dominoBag = new ArrayList<Domino>();
    public static ArrayList<Board> possibleBoards  = new ArrayList<Board>();

    public static void createDominos() {
        for (int i = 0; i < numDominos; i++) {
            int val1 = (int) (Math.random() * 6.0) + 1;
            int val2 = (int) (Math.random() * 6.0) + 1;
            dominoBag.add(new Domino(val1, val2));
        }
    }

    public static int longestOfPaths(){
        int longest = 0;
        for (Board b : possibleBoards) {
            if (b.state_of_play.size() > longest){
                longest = b.state_of_play.size();
            }
        }
        return longest;
    }

    private static void printSet(ArrayList<Domino> set){
        for (Domino d : set)  {
            System.out.print(d.printableOutput());
            System.out.print(", ");
        }
        System.out.print("\n");
    }

    public static void printPaths(ArrayList<ArrayList<Domino>> Paths){
        for (ArrayList<Domino> path : Paths) {
            printSet(path);
        }
    }

    public static int findLongestPath() {
        iterateAllPossiblePaths();
        return longestOfPaths();
    }

    public static boolean stillHasMatches(ArrayList<Board> setOfBoards){
        boolean r = false;
        for (Board b : setOfBoards){
           b.enactBoard();
           if (b.potentialMatches().size() > 0) {
               return true;
           }
        }
        return r;
    }


    public static void iterateAllPossiblePaths(){
        //initialize the list of Boards
        for (Domino d : dominoBag) {
            Board board1 = new Board(dominoBag, true);
            board1.state_of_play.add(d);
            possibleBoards.add(board1);
            Board board2 = new Board(dominoBag, false);
            board2.state_of_play.add(d);
            possibleBoards.add(board2);
        }
        //while any Board still has potential matches
        while (stillHasMatches(possibleBoards)) {
            for (Board b : possibleBoards){
                if (b.potentialMatches().size() > 0){
                    for (Domino d : b.potentialMatches() ) {
                        Board new_board = new Board(dominoBag, b.first_play_uses_value1);
                        new_board.state_of_play = b.state_of_play;
                        new_board.state_of_play.add(d);
                        possibleBoards.add(new_board);
                    }
                    possibleBoards.remove(b);
                }
            }
        }

    }


    public static void main(String[] args) {
        createDominos();
        //printSet(dominoBag);
        int maxLength = findLongestPath();

        System.out.println("Longest path length is " + maxLength + "\n");
    }

}
