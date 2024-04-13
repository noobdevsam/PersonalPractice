package arrays;

import java.util.Arrays;
import java.util.Random;

// shuffle array elements
public class ArrayThirtyNine {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(arr));
        shuffle_elements(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void shuffle_elements(int[] arr) {
        for (int i = (arr.length - 1); i >= 1; i--) {
            var random = new Random();
            // generate random index between 0 to i(inclusive)
            int j = random.nextInt(i+1);

            swap_elements(arr, i, j);
        }
    }

    private static void swap_elements(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
