package arrays;

import java.util.Arrays;

// program to find second largest element in the array
public class ArrayFourteen {
    public static void main(String[] args) {
        int[] arr = {25,6,5,85,6214,6874,254,37468,2134,46571,1354,64743,35443,6647};

        System.out.println("Original array: " + Arrays.toString(arr));

        Arrays.sort(arr);
        int index = (arr.length-1); 
        // set value of 'index' to the last index of the array 
        //and points to the largest element in the sorted array

        
        // checks if the element at the current index (arr[index]) is equal to the element at the last index (arr[arr.length - 1]
        // This loop basically checks for duplicate largest elements.
        while (arr[index] == arr[arr.length -1]) {
            index--; // moves to the previous element in the sorted array
        }

        System.out.println("Second largest element: " + arr[index]);
    }
}
