import java.util.Arrays;

public class Search {
    private Search() {
        super();
    }

    /**
     * @param array A sorted array of ints to search through. This must be sorted.
     * @param searchTerm An int to search the array for
     * @return Whether the searchTerm exists in the array
     */
    public static boolean binarySearch(int[] array, int searchTerm) {

         if (array.length == 0){
            return false;
         }

         if (array.length == 1) {
             if (array[0] == searchTerm) {
                 return true;
             }
             else {
                 return false;
             }
         }

        int[] first_half = Arrays.copyOfRange(array, 0, array.length/2);
        int[] second_half = Arrays.copyOfRange(array, array.length/2, array.length);

        return  ( binarySearch(first_half, searchTerm) || binarySearch(second_half, searchTerm) );

    }
}
