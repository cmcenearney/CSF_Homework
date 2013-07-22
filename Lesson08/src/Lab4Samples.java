import java.util.Scanner;

public class Lab4Samples {

    public static void main(String[] args) {

        Scanner consoleScanner = new Scanner(System.in);
        System.out.print("\nType 'bst' or 'maxheap' to start: ");
        String result = consoleScanner.next();
        if (result.equals("bst")) {
            bst();
        }
        else if (result.equals("maxheap")) {
            maxHeap();
        }
        else {
            System.out.println("Invalid input, bailing");
        }
    }

    public static void bst() {
        IntBST bst = new IntBST();

        while(true) {
            Scanner consoleScanner = new Scanner(System.in);
            System.out.print("\nType 'insert {number}' or bulk {n1,n2,n3...} or 'find {number} to insert/find into the BST: ");
            String command = consoleScanner.next();
            //int value = consoleScanner.nextInt();

            if (command.equals("insert")) {
                int value = consoleScanner.nextInt();
                bst.insertValue(value);
                bst.printTree();
            }
            else if (command.equals("find")) {
                int value = consoleScanner.nextInt();
                System.out.println("It is " + bst.search(value) + " that " + value + " exists in the BST.");
            }
            else if (command.equals("bulk")) {
                String bulk_add = consoleScanner.next();
                bst.bulkAdd(bulk_add);
                bst.printTree();
            }
        }
    }

    public static void maxHeap() {
        IntMaxHeap maxHeap = new IntMaxHeap();

        while(true) {
            Scanner consoleScanner = new Scanner(System.in);
            System.out.print("\nEnter a number to be entered in the maxheap: ");
            int newInt = consoleScanner.nextInt();

            maxHeap.insertValue(newInt);
            maxHeap.printTopValue();
        }
    }
}