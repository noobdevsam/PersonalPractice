package arrays;

// print elements of the largest sub-array
public class ArrayThirtySix {
  public static void main(String[] args) {
    int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
    int[] subarray = findMaxSubarray(arr);
    System.out.print("Elements of the largest subarray: ");

    for (int i : subarray) {
      System.out.print(i + " ");
    }
  }

  private static int[] findMaxSubarray(int[] arr) {
    int maxSum = Integer.MIN_VALUE;
    int start = 0, end = 0;

    for (int i = 0; i < arr.length; i++) {
      int currentSum = arr[i], currentStart = i;

      for (int j = (i+1); j < arr.length; j++) {
        currentSum += arr[j];

        if(currentSum > maxSum) {
          maxSum = currentSum;
          start = currentStart;
          end = j;
        }
      }
    }

    int[] subarray = new int[end - start + 1];
    for (int i = 0; i <= (end-start); i++) {
      subarray[i] = arr[start + i];
    }
    
    System.out.println("Start position: " + start + "\nEnding position: " + end);
    System.out.println("Maximum sum: " + maxSum);

    return subarray;
  }  
}

/*
**1. Finding the Maximum Sum and Subarray Indices:**

- The `findMaxSubarray` function takes the input array `arr`.
- It initializes variables:
    - `maxSum` to `Integer.MIN_VALUE` to store the maximum sum found so far (negative infinity).
    - `start` and `end` to keep track of the starting and ending indices of the potential largest subarray.

- The first loop iterates through each element (`arr[i]`) of the original array:
    - It creates a variable `currentSum` to store the sum for the current subarray starting at `arr[i]`.
    - It sets `currentStart` to `i`, which is the starting index for the current subarray.

- Inside a nested loop:
    - It iterates through the remaining elements (`arr[j]`) starting from the next element (`j = i + 1`) of the current `i`.
    - It adds the current element (`arr[j]`) to `currentSum`, effectively building the sum of a subarray starting from `arr[i]`.
    - It compares the `currentSum` with the `maxSum`:
        - If `currentSum` is greater than `maxSum`, it means we potentially found a larger subarray.
            - It updates `maxSum` with the new larger sum.
            - It updates `start` to `currentStart`, which is the starting index of the current (potentially largest) subarray.
            - It updates `end` to `j`, which is the current ending index of the potential largest subarray.

**2. Creating the Subarray:**

- After the first loop finishes iterating through the entire array, `maxSum` holds the value of the largest subarray sum found.
- It creates a new integer array `subarray` with a size of `end - start + 1`. This represents the length of the largest subarray based on the previously found indices.
- A second loop iterates from 0 to `end - start`:
    - It copies elements from the original array starting from the `start` index (which points to the beginning of the largest subarray) to the newly created `subarray`.

This solution avoids an additional loop to find the starting and ending indices after determining the maximum sum. It achieves this by keeping track of potential subarray start and end points during the first loop itself. 
 */