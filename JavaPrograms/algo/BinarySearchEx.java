package algo;

import java.util.Arrays;

public class BinarySearchEx {

    public static void main(String[] args) {
        
        // int[] arr = {40, 30, 2, 70, 4, 3, 33, 7, 1};
        int[] arr = {1, 10, 14,17, 25, 34, 77, 80};
        
        int target = 1;

        if (!isSorted(arr)) {
            System.out.println("Given Array: " + Arrays.toString(arr));
            System.out.println("Array is not sorted. Sorting now.....");
            Arrays.sort(arr);
            System.out.println("After sorting: " + Arrays.toString(arr));
        } else {
            System.out.println("Given array is already sorted. Moving forward.");
        }

        int returnedIndexValue = binarySearch(arr, target);

        if (returnedIndexValue == -1) {
            System.out.println("The element " + target + " is not present inside the given array.");
        } else {
            System.out.println("After sorting the array, the element " + target + " was found at position: " + returnedIndexValue);
        }

    }

    private static int binarySearch(int[] arr, int target) {
        
        int left = 0, right = (arr.length - 1);

        while (left <= right) {
            int mid = (left + (right - left)) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    private static boolean isSorted(int[] arr) {

        for(int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                return false;
            }
        }

        return true;
    }
}