import java.util.Scanner;

public class Application {
    public static void main (String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("type a first number: ");
        int first = scanner.nextInt();
        IntLinkedList list = new IntLinkedList(new IntListNode(first));
        list.print();
        /*
        while (true){
            System.out.println("type a number to add: ");
            int next = scanner.nextInt();
            list.insert(next);
            list.print();
        } */
        String cmd = "";
        while (!cmd.equals("quit") ){
            System.out.println("enter a command - 'add', 'last', 'count' or 'quit' ");
            cmd =  scanner.next();
            if (cmd.equals("add")){
                System.out.println("type a number to add: ");
                int next = scanner.nextInt();
                list.insert(next);
                list.print();
            }
            else if (cmd.equals("last")) {
                System.out.println(list.getLast_node().getValue()) ;
            }
            else if (cmd.equals("count")) {
                System.out.println(list.count()) ;
            }
            else {
                System.out.println("command not understood - please enter 'add' 'list' 'count' or 'quit'");
            }
        }
        System.exit(0);
    }
}