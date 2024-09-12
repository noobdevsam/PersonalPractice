package algo;

public class QuickSortEx {
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5, 3};

        System.out.println("Unsorted array: ");
        printArray(arr);

        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array: ");
        printArray(arr);
    }

    // implement the quick sort on a array
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            // finds the pivotal element
            //  elements smaller than pivotal element are on the left side
            // elements greater than pivotal element are on the right side
            int pivot_element = partition(arr, low, high);

            // recursive call on the left of pivot index
            quickSort(arr, low, pivot_element - 1);

            // recursive call on the right of pivot index
            quickSort(arr, pivot_element + 1, high);
        }
    }

    // function to partition the array on the basis of pivot element (here, first one)
    private static int partition(int[] arr, int low, int high) {

        // choosing the first element as pivot
        int pivot = arr[low];

        // initialize the pointers for left and right positions
        int i = low + 1;
        int j = high;

        // partition process
        while (i <= j) {

            // step - 1: find element greater than pivot from left side
            while (i <= j && arr[i] <= pivot) {
                i++;
            }

            // step - 2: find element smaller than pivot from right side
            while (i <= j && arr[j] > pivot) {
                j--;
            }

            // step - 3: swap the elements if the found elements are in the wrong order
            if (i < j) {
                int temp =  arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // step - 4: place the pivot in its final/correct position
        arr[low] = arr[j];
        arr[j] = pivot;

        // return the pertition index
        return j;
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

/*
 * Partition Function:

    The first element (array[low]) is chosen as the pivot.
    Two pointers, i and j, are used to traverse the array from the left and right sides.
    The while loops ensure that i moves to the right until it finds an element greater than the pivot,
        and j moves to the left until it finds an element smaller than or equal to the pivot.
    When i and j meet or cross each other, the loop ends, and the pivot is swapped with the element at index j to place it in the correct position.
 */

/*

The time complexity of the Quick Sort algorithm depends on how the pivot is chosen and how the partitioning occurs.
Since the last implementation always selects the **first element** as the pivot, its time complexity will vary based on the input data.
Here’s a breakdown:

### 1. **Best Case Time Complexity (O(n log n)):**
- The best case occurs when the pivot divides the array into two almost equal subarrays after each partition.
- If the array is well-balanced during every partition (i.e., the pivot divides the array into two nearly equal parts),
    the Quick Sort algorithm will perform **O(log n)** recursive calls, and each partition operation 
    takes **O(n)** time (scanning the array to place elements on the correct side of the pivot).
- Therefore, the overall time complexity in the best case is **O(n log n)**.

### 2. **Worst Case Time Complexity (O(n²)):**
- The worst case occurs when the pivot divides the array in a highly unbalanced manner.
    For example, when the array is already sorted (either in ascending or descending order) and 
    the first element is always the smallest or largest.
- In this case, after each partition, one subarray will contain all the elements except one, and the other subarray will be empty.
- This results in **O(n)** recursive calls, and each partition operation still takes **O(n)** time.
- Hence, the time complexity in the worst case becomes **O(n²)**.

### 3. **Average Case Time Complexity (O(n log n)):**
- On average, the pivot will split the array into reasonably balanced parts.
- The algorithm will need to make **O(log n)** recursive calls, and each partition takes **O(n)** time.
- Thus, the average time complexity of Quick Sort is **O(n log n)**.

### Summary:

- **Best Case:** \( O(n \log n) \)
- **Average Case:** \( O(n \log n) \)
- **Worst Case:** \( O(n^2) \)

### Space Complexity:
- The space complexity of Quick Sort is **O(log n)** due to the recursive call stack.
In the worst case, when the recursion is highly unbalanced, the space complexity could degrade to **O(n)**.

### Worst-case Example:
If you input a **sorted array** into this Quick Sort implementation, it will experience the worst-case performance.
This is because the first element will always be the smallest or largest, leading to highly unbalanced partitions.

*/
