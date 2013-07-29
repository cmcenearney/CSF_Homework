import java.util.HashMap;

public class Memo {
   // public HashMap<Long,Long> cache;
    public static long fib(long i) {
        return fib(i, null);
    }

    public static long fib(long i,HashMap<Long,Long> cache) {
        if (cache==null) {
            cache = new HashMap<Long, Long>();
            cache.put(0l,1l);
            cache.put(1l,1l);
        }
        if (cache.containsKey(i)) {
            return cache.get(i);
        } else {
            long f = fib(i-1, cache)+fib(i-2, cache);
            cache.put(i,f);
            return f;
        }
    }

}
