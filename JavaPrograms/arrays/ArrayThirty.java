package arrays;

import java.util.Arrays;

// check whether there is any pair with a specified sum in a given sorted and rotated array
public class ArrayThirty {
    public static void main(String[] args) {
        int[] arr = {15, 16, 9, 2, 1, 4};
        int[] arr2 = {22, 25, 17, 18, 19, 20};
        int[] arrs = arr;
        int[] arrs2 = arr2;

        System.out.println("for sorted array: ");
        Arrays.sort(arrs);
        Arrays.sort(arrs2);
        findPairs(arrs, 11);
        findPairs(arrs2, 42);
        
        System.out.println("for rotated array: ");
        rotate(arr);
        rotate(arr2);
        findPairs(arr, 11);
        findPairs(arr2, 42);

        
    }

    private static void findPairs(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] + arr[j] == sum) {
                    System.out.println(arr[i] +" + " +arr[j] + " = " + sum);
                }
            }
        }
    }

    // rotate array
    private static void rotate(int[] arr) {
        if (arr.length != 0 || arr.length != 1) {
            int last = arr[arr.length-1];

            // iterate backward from second last element to first element
            for (int i = (arr.length - 2); i >=0; i--) {
                arr[i + 1] = arr[i];// shift element to right by one position
            }
            arr[0] = last;
        } else {
            System.out.println("Error");
        }
    }
}
