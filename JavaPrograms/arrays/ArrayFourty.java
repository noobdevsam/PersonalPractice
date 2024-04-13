package arrays;

import java.util.Arrays;

// program to rearrange array for every second elements should be greater than its left and right element
public class ArrayFourty {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 9, 5, 3, 8, 7, 10, 12, 14 };
        System.out.println(Arrays.toString(arr));
        rearrange_elements(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void rearrange_elements(int[] arr) {
        for (int i = 0; i < (arr.length - 1); i++) {
            if (i % 2 == 0) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, (i + 1));
                }
            } else {
                if (arr[i] < arr[i + 1]) {
                    swap(arr, i, (i + 1));
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


/*
 * 
The `rearrangeArray` method is designed to rearrange the elements of the input array in such a way that every second element is greater than its left and right elements. Here's how it works:

1. The method iterates over the array starting from the first element (at index 0) to the second last element (at index `nums.length - 2`). It doesn't include the last element because there's no element after the last one to compare it with.

2. For each element at index `i`, it checks if `i` is an even number (`i % 2 == 0`). If it is, it means we're at a position where the current element should be less than the next one. So, if the current element is greater than the next one (`nums[i] > nums[i + 1]`), it swaps these two elements.

3. If `i` is an odd number, it means we're at a position where the current element should be greater than the next one. So, if the current element is less than the next one (`nums[i] < nums[i + 1]`), it swaps these two elements.

 */