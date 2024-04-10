package arrays;

import java.util.Arrays;

// program to replace every element with the next greatest element (from the right side) in a given array of integers.
// There is no element next to the last element, therefore replace it with -1.
public class ArrayThirtyFour {
    public static void main(String[] args) {
        int[] arr = { 45, 20, 100, 23, -5, 2, -6 };
        System.out.println("Original: " + Arrays.toString(arr));
        System.out.println("Original: " + Arrays.toString(arrangeWithNextGreatest(arr)));
    }

    private static int[] arrangeWithNextGreatest(int[] arr) {
        var size = arr.length;
        var max_value_from_right = arr[size - 1];

        arr[size - 1] = -1;

        for (int i = size - 2; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max_value_from_right;

            if (max_value_from_right < temp) {
                max_value_from_right = temp;
            }
        }

        return arr;
    }
}

/*
 * The `next_greatest_num` method takes an array of integers as input and
 * modifies it by replacing each element with the next greatest element in the
 * array. The method works by iterating through the array from right to left.
 * For each element, it stores the next greatest element seen so far in a
 * variable. Then, it replaces the current element with the next greatest
 * element and updates the next greatest element if necessary. Finally, it
 * returns the modified array.
 */