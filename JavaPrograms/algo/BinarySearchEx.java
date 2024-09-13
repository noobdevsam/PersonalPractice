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

/*

Let's analyze the **time complexity** for the code you provided.

### Code Breakdown:
1. **Check if the array is sorted (`isSorted()` method)**:
   - This method iterates through the array to check if each element is greater than or equal to the previous one.
   - **Time complexity**: O(n), where `n` is the number of elements in the array.

2. **Sorting the array (`Arrays.sort(arr)`)**:
   - If the array is not sorted, the code sorts it using `Arrays.sort()`, which has a time complexity of **O(n log n)**.
   - If the array is already sorted, sorting is skipped.

3. **Binary search (`binarySearch()` method)**:
   - After the array is either confirmed to be sorted or sorted, a binary search is performed.
   - **Time complexity**: O(log n).

### Time Complexity Scenarios:

#### 1. **If the array is already sorted**:
   - **Step 1: Checking if the array is sorted**: O(n).
   - **Step 2: No sorting is required** (since the array is already sorted), so this step is skipped.
   - **Step 3: Binary search**: O(log n).

   **Total time complexity**:  

   O(n) {for sorting check} + O(log n) {for binary search} = O(n)

#### 2. **If the array is not sorted**:
   - **Step 1: Checking if the array is sorted**: O(n).
   - **Step 2: Sorting the array**: O(n log n).
   - **Step 3: Binary search**: O(log n).

   **Total time complexity**:  
   
   O(n)(for sorting check)+O(nlogn)(for sorting)+O(logn)(for binary search)=O(nlogn)

### Summary:
- **If the array is already sorted**: **O(n)**.
- **If the array is not sorted**: **O(n log n)**.

This is consistent with the earlier analysis and applies to your new code as well.

-----------


The overall time complexity of the binary search algorithm depends on the context in which it is used and the initial conditions of the array (whether it is sorted or not). Let's break it down into two primary cases:

1. If the Array is Already Sorted:

In this case, the binary search algorithm directly operates on the sorted array.

Time complexity:

Binary search alone: O(log n), where n is the number of elements in the array.



This is the ideal time complexity when performing binary search on a pre-sorted array.

2. If the Array is Not Sorted:

Binary search requires a sorted array to function correctly. If the array is not sorted, you need to sort it first before applying binary search.

Time complexity:

Sorting the array: O(n log n), using a typical efficient sorting algorithm like Merge Sort, Quick Sort, or the built-in Java Arrays.sort() (which is typically a variant of TimSort).

Binary search: O(log n) after sorting.


Total time complexity:


O(n log n),{for sorting} + O(log n),{for binary search} = O(n log n)

Since O(n log n) dominates O(log n), the overall time complexity when the array is unsorted is O(n log n).

Summary of Overall Time Complexities:

If the array is already sorted: O(log n) (binary search only).

If the array is not sorted: O(n log n) (sorting + binary search).


Thus, the overall time complexity of binary search depends on whether the array is sorted:

O(log n) if the array is sorted.

O(n log n) if the array needs to be sorted first.



*/
