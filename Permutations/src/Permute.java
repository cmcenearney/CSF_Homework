import java.util.ArrayList;

public class Permute {
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
    public static ArrayList reverseArray(ArrayList items) {
        int size = items.size();
        ArrayList copy = new ArrayList(items.size());
        for (int i = size-1; i >= 0; i--) {
           copy.add(items.get(i));
        }
        return copy;
    }

    public static ArrayList subArray(ArrayList items, int delete_me) {
        ArrayList copy = new ArrayList();
        for (int i = 0; i < items.size(); i++) {
            if (i != delete_me) {
                copy.add(items.get(i));
            }
        }
        return copy;
    }
    /*
    public static ArrayList<ArrayList> permute(ArrayList items) {
        ArrayList permutations = new ArrayList();
        if (items.size() <= 1) {
            ArrayList results = new ArrayList();
            results.add(items);
            return results;
        } else if (items.size() == 2) {
            ArrayList results = new ArrayList();
            results.add(items);
            results.add(reverseArray(items));
            return results;
        }
        for (int i = 0; i < items.size(); i++) {
            //ArrayList p = new ArrayList();
            Object p = items.get(i);
            ArrayList sub = subArray(items,i);
            ArrayList perms = permute(sub);
            // [[a,b], [b,a]]
            for (int j = 0; j < perms.size(); j++){
                ArrayList perm = perms.get(j);
                permutations.add(perm);
            }
        }
        return permutations;
    }
         */


    public static void main(String[] args) {

        ArrayList<String> test = new ArrayList<String>();
        test.add("a");
        test.add("c");
        //test.add("e");
        test.add("b");
        //System.out.println(permute(test));
        System.out.println(test);
        System.out.println(test.size());
        System.out.println(reverseArray(test));
        System.out.println(subArray(test, 2));
       // System.out.println(permute(test));

    }
}
