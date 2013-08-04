import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;

public class Sort {
    private Sort() {
        super();
    }

    /**
     * Sorts given array using the insertionSort technique
     * @param array The array of ints to sort, ascending
     */
    public static void insertionSort(int[] array) {
        // TODO: Perform an insertion sort on the array
        throw new NotImplementedException();
    }

    /**
     * merges two sorted arrays
     * @param a1
     * @param a2
     */
    public static int[] merge(int[] a1, int[] a2){
        int i  = 0; int j = 0;  int k = 0;
        int[] merged = new int[a1.length + a2.length];
        while (k < (a1.length + a2.length)) {
           // can this check be avoided?
           if (i == a1.length)  {
               //just add a2
               while (j < a2.length){
                   merged[k] = a2[j]; k++; j++;
               }
               break;
           } else if (j == a2.length) {
               //just add a1
               while (i < a1.length){
                   merged[k] = a1[i]; k++; i++;
               }
               break;
           }
           if ( a1[i] < a2[j] ) {
              merged[k] = a1[i];
              i++;
           }
           else  {
              merged[k] = a2[j];
              j++;
           }
           k++;
        }
        return merged;
    }

    /**
     * Sorts given array using a recursiveMergeSort technique
     * @param array The array of ints to sort, ascending
     */
    public static int[] recursiveMergeSort(int[] array) {
        //throw new NotImplementedException();
        if (array.length == 1){
            return array;
        }
        else {
            int[] front = java.util.Arrays.copyOfRange(array, 0, array.length/2);
            int[] back = java.util.Arrays.copyOfRange(array, array.length/2, array.length);
            return merge(recursiveMergeSort(front), recursiveMergeSort(back));
        }
    }

}
