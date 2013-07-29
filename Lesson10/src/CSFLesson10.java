import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CSFLesson10 {

    // Your task is to identify the complexity of this function, and rewrite it to have a better complexity.
    static void firstLab() {
        // Instantiate and populate an array of 10 random floats.
        float[] array = new float[10];
        for (int i = 0; i < 10; i++) {
            array[i] = (float) Math.random();
        }

        System.out.println("Array: " + Arrays.toString(array));

        float total = 0.0f;
        for (int j = 0; j < 10; j++) {
            total += array[j];
        }

        for (int i = 0; i < 10; i++) {
            float thisValue = array[i];
            float average = total / 10.0f;
            System.out.println("Value " + thisValue + " is " + (thisValue / average) * 100.0f + "% of the average.");
        }
    }

    /**
     * Make this code faster.
     *
     * 1 : 1
     */
    static void secondLab() {
        // Instantiate and populate an array of 10 random integers between 0 and 9.
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = (int) (Math.random() * 10.0);
        }
        // could be HashSet
        HashMap<Integer, Integer> hash = new HashMap();

        System.out.println("Array: " + Arrays.toString(array));
        // loop through once make a hash where key is i and value is count
        for (int value : array) {
           //int value = array[i];
           if (hash.get(value) == null) {
               hash.put(value, 1);
           }
           else {
               int count = hash.get(value);
               count++;
               hash.put(value, count);
           }
        }

        // loop through once, check hash, if value >1 print "..duplicate"
        for (int value : array) {
            //int value = array[i];
            if (hash.get(value) > 1) {
                System.out.println("Value " + value + " is a duplicate.");
            }
            else {
                System.out.println("Value " + value + " is not a duplicate.");
            }
        }
         /*
        for (int i = 0; i < 10; i++) {
            int thisValue = array[i];
            boolean isDuplicate = false;
            for (int j = 0; j < 10; j++) {
                if ((i != j) && (thisValue == array[j])) {
                    isDuplicate = true;
                }
            }

            if (isDuplicate) {
                System.out.println("Value " + thisValue + " is a duplicate.");
            } else {
                System.out.println("Value " + thisValue + " is not a duplicate.");
            }
        }
        */
    }

    static void thirdLab() {
        int[] denominations = {1, 5, 10, 25};
//        int[] denominations = {1, 5, 7, 20};

        CoinCounter counter = new CoinCounter(denominations);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a value: ");
            int value = scanner.nextInt();
            int numberOfCoins = counter.simpleNumberOfCoinsRequired(value);
            if (numberOfCoins == CoinCounter.CHANGE_NOT_POSSIBLE_FLAG)
                System.out.println("Impossible to make change for " + value);
            else
                System.out.println(numberOfCoins + " coins are required to make change for " + value);
        }
    }

    static void fourthLab() {
        // Bonus Challenge Assignment: Print the first N fibonacci numbers recursively, how fast is this?
        // Note that this requires familiarity with recursion. If you are not familiar with recursion,
        // don't worry, we'll cover it in a coming class.
        int n = 10;
    }

    public static int  fibIterative(int n) {
        // Bonus Challenge Assignment: Print the first N fibonacci numbers taking advantage of memoization. How fast is this?
        // Note that this does not require recursion.
        //int n = 10;
        int[] numbers = new int[n+1];
        numbers[0] = 1;
        numbers[1] = 1;
        for (int i = 2; i < n+1; i++){
            numbers[i] = numbers[i-1] + numbers[i-2];
        }
        return numbers[n];

    }

    public static void main(String[] args) {
        //firstLab();
        //secondLab();
        //thirdLab();
        //fourthLab();
        //fifthLab();

        HashMap<Long, Long> fib_cache = new HashMap<Long, Long>();
        /*
        System.out.println(Memo.fib(12l, fib_cache));
        System.out.println(Memo.fib(22l, fib_cache));
        System.out.println(Memo.fib(32l, fib_cache));
        System.out.println(Memo.fib(36l, fib_cache));
        System.out.println(Memo.fib(35l, fib_cache));
        System.out.println(Memo.fib(37l, fib_cache));
        System.out.println(Memo.fib(38l, fib_cache));
        System.out.println(Memo.fib(39l, fib_cache));
        System.out.println(Memo.fib(40l, fib_cache));
        */

        for (int i=2; i <= 41; i++){
            Memo.fib(41l, fib_cache);
        }
        System.out.println(Memo.fib(41l,fib_cache));
        System.out.println(fibIterative(42));
        System.out.println(Memo.fib(42l,fib_cache));
    }
}
