package arrays;

import java.util.Arrays;

// program to reverse an array
public class ArrayEight {
    public static void main(String[] args) {
        int[] arr = {54,5468,6841,365,65546,3321,79,22,993,35,45,323,46};
        System.out.println("Original array: " + Arrays.toString(arr));

        reverseArray(arr);
        System.out.println("Reversed array: " + Arrays.toString(arr));
    }

    private static void reverseArray(int[] arr) {
        int left = 0, right = (arr.length -1);

        // swapping the element of first index with element of last index and vice versa
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++; // move forward
            right--; // move backward
        }
    }
}
