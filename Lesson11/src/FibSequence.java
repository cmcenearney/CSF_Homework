import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashMap;

public class FibSequence {
    /**
     * Returns the nth fibonacci number, recursively computed.
     * The 0th fibonacci number is 0
     * The 1st is 1
     * The 2nd is 1
     * The 3rd is 2
     * etc
     * @param n The index in the fibonacci sequence to recursively calculate
     * @return The respective fibonacci number
     */
    int fibNumber(int n) {
        // TODO: Fill out to make FibSequenceTest pass
        return fibMemoized(n);
        //throw new NotImplementedException();
    }

    public static int fibMemoized(int i) {
        return fibMemoized(i, null);
    }

    public static int fibMemoized(int i,HashMap<Integer,Integer> cache) {
        if (cache==null) {
            cache = new HashMap<Integer,Integer>();
            cache.put(0,0);
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
        numbers[0] = 0;
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
            return 0;
        }
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

}
