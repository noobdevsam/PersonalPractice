package arrays;

import java.util.Arrays;

public class ArrayTwentyThree {
    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2,6,5,8,9,7};
        int length = findLengthOfConsecutiveSequence(arr);
        System.out.println("Length of the longest consecutive sequence: " + length);
    }

    private static int findLengthOfConsecutiveSequence(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        Arrays.sort(arr);
        int currentLength = 1; // keep track of the current consecutive sequence length.
        int maxLength = 1;

        for (int i = 1; i < arr.length; i++) {
            /*
             * If the current element (nums[i]) is equal to the previous element (nums[i - 1]) ,
             *it's a duplicate, so we skip it using continue;.
             */
            if (arr[i] == arr[i-1]) {
                continue;// skip duplicates, next iteration
            } else if (arr[i] == (arr[i-1] + 1)) {
                // main calculation
                // if the current element is one more than the previous element (nums[i] == nums[i - 1] + 1),
                //it's part of the current consecutive sequence, so we increment currentLength.
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1; // reset currentLength to 1 for the next potential sequence.
            }
        }

        return Math.max(maxLength, currentLength);
    }
}
