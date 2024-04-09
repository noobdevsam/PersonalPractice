package arrays;

import java.util.Arrays;

// program to place large,small, 2nd large, 2nd small, 3rd large, 3rd small ....so on
public class ArrayThirtyTwo {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50,60,70,80,90,100};
        System.out.println("Original array: " + Arrays.toString(arr));

        int[] result = rearrange(arr);
        System.out.println("New array: " + Arrays.toString(result));
    }

    private static int[] rearrange(int[] arr) {
        var n = arr.length;
        var temp = new int[n];
        
        // intialize counters for small and large elements
        int small = 0, large = n-1;

        // iterate through all elements
        for (int i = 0; i < n; i++) {
            if (i%2 == 0) {
                // fill even indices with larger elements
                temp[i] = arr[large--];
            } else {
                // fill odd indices with smaller elements
                temp[i] = arr[small++];
            }
        }

        return temp;
    }
}