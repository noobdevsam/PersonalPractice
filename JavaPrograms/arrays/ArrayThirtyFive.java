package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayThirtyFive {
    public static void main(String[] args) {
        int[] arr = { 1, 3, -7, 3, 2, 3, 1, -3, -2, -2 };
        int[] arr2 = { 1, 2, -3, 4, 5, 6 };
        int[] arr3 = { 1, 2, -2, 3, 4, 5, 6 };

        System.out.println("Array 1: " + Arrays.toString(arr));
        print_subarray_with_sum_zero(arr);

        System.out.println("Array 2: " + Arrays.toString(arr2));
        print_subarray_with_sum_zero(arr2);

        System.out.println("Array 3: " + Arrays.toString(arr3));
        print_subarray_with_sum_zero(arr3);
    }

    private static void print_subarray_with_sum_zero(int[] arr) {
        var list = new ArrayList<Integer>();

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            list.removeAll(list);

            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                list.add(arr[j]);

                if (sum == 0) {
                    System.out.println("Sub arrays with sum 0: " + list.toString());
                }
            }
        }
    }
}

/*
 * The 'print_subarray_with_sum_zero' method systematically
 * explores all possible subarrays within the given array by iterating through it with nested loops.
 It keeps track of the subarray elements and their cumulative sum. If a subarray's sum reaches zero, it's identified and printed.
 */