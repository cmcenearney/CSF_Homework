import java.util.Arrays;
import java.util.HashMap;

public class Fibonacci {

    public static int fibMemoized(int i) {
        return fibMemoized(i, null);
    }

    public static int fibMemoized(int i,HashMap<Integer,Integer> cache) {
        if (cache==null) {
            cache = new HashMap<Integer,Integer>();
            cache.put(0,1);
            cache.put(1,1);
        }
        if (cache.containsKey(i)) {
            return cache.get(i);
        } else {
            int f = fibMemoized(i - 1, cache)+fibMemoized(i - 2, cache);
            cache.put(i,f);
            return f;
        }
    }

    public static int  fibIterative(int n) {
        int[] numbers = new int[n+1];
        numbers[0] = 1;
        numbers[1] = 1;
        if (n >= 2) {
            for (int i = 2; i < n + 1; i++) {
                numbers[i] = numbers[i - 1] + numbers[i - 2];
            }
        }
        return numbers[n];
    }

    public static int fibRecursive (int n) {
        if (n == 1) {
            return 1;
        }
        else if (n==0){
            return 1;
        }
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    //public static HashMap<Integer, Integer> fib_cache = new HashMap<Integer,Integer>();;

    public static void main(String[] args) {
         //int type has max value of 2147483647
         //so fib[45] is the farthest you can go with it

        System.out.println(fibMemoized(45));
        System.out.println(fibIterative(45));
        System.out.println(fibRecursive(45));

    }
}
