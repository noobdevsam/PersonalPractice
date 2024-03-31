package arrays;

import java.util.Arrays;

// program to remove an element from an array by shifting elements position to left
// aka overriding one element with next element
public class ArrayFive {
    public static void main(String[] args) {
        int[] arr = {45,54,6,64,831,88345,48413,54845,46,86,374,89};
        int index_to_remove = 4; 
        System.out.println("Original array: " + Arrays.toString(arr));
        
        // shifting element to left starting from the specified index
        for (int index = index_to_remove; index < arr.length -1; index++) {
            arr[index] = arr[index + 1];//overridng element
        }

        System.out.println("New array: " + Arrays.toString(arr));
    }
}
