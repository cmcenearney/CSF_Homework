import java.util.ArrayList;
import java.util.HashMap;

public class StringPermute {

    public static String reverseString(String str){

        return str;
    }

    public static String subString (String str){

        return str;
    }

    public static ArrayList<String> permuteString(String str){
        return permuteString(str, null);
    }

    public static ArrayList<String> permuteString(String str,  ArrayList<String> permutations){
        if (permutations == null) {
            permutations = new ArrayList<String>();
        }

        return permutations;
    }


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
}

/*
def permute(array)
  permutations = []
  if array.length <= 1
    return array
  end
  if array.length == 2
    return array, array.reverse
  end
  array.each_index do |i|
    n = [array[i]]
    sub_array = subArray(array,i)
    permute(sub_array).each do |sub|
      permutations << n + sub
    end
  end
  return permutations
end
*/