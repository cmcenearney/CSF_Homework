import java.util.Scanner;

public class Lab3Samples {

    public static void main(String[] args) {
        Scanner consoleScanner = new Scanner(System.in);
        System.out.print("\nEnter 'list' or 'stack' to start: ");
        String command = consoleScanner.next();
        if (command.equals("list")) {
            linkedList();
        }
        else if (command.equals("stack")) {
            stack();
        }
        else {
            System.out.println("Invalid input, bailing");
        }
    }

    public static void linkedList() {
        IntLinkedList list =  new IntLinkedList();

        while(true) {
            Scanner consoleScanner = new Scanner(System.in);
            System.out.print("\nEnter {add/remove} number to modify the list: ");
            String command = consoleScanner.next();
            int value = consoleScanner.nextInt();

            if (command.equals("add")) {
                list.insert(value);
            }
            else if (command.equals("remove")) {
                list.remove(value);
            }
            list.print();
        }
    }

    public static void stack() {
        IntStack stack = new IntStack();

        while(true) {
            Scanner consoleScanner = new Scanner(System.in);
            System.out.print("\nEnter {push/pop} number to modify the stack: ");
            String command = consoleScanner.next();

            if (command.equals("push")) {
                int value = consoleScanner.nextInt();

                stack.push(value);
                System.out.println("Stack pushed value: " + value + ", size is " + stack.size());
            }
            else if (command.equals("pop")) {
                System.out.println("Stack popped value: " + stack.pop() + ", size is " + stack.size());
            }
        }
    }
}