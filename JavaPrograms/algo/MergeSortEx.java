package algo;
import java.util.Arrays;

public class MergeSortEx {
        public static void main(String[] args) {
                int[] arry = {12, 11,13,5,6,7};
                int left_index = 0, right_index = (arry.length - 1);

                System.out.println("Given array: " + Arrays.toString(arry));

                mergeSort(arry, left_index, right_index);

                System.out.println("Sorted array: " + Arrays.toString(arry));
        }

        // The mergeSort function recursively divides the array and sorts the parts
        private static void mergeSort(int[] array, int left, int right){

        // Check if the left index is less than the right, meaning the array has more than one element
                if (left < right) {

                        // Find the middle point of the current section of the array
                        int mid = left + (right - left) / 2;

                        // Recursively sort the first half
                        mergeSort(array, left, mid);

                        // Recursively sort the second half
                        mergeSort(array, mid + 1, right);

                        // Merge the two sorted halves
                        merge(array, left, mid, right);
                }
        }

        // The merge function merges two sorted subarrays into one sorted array
        private static void merge(int[] array, int left, int mid, int right) {

                // Calculate the sizes of the two subarrays to be merged
                int size1 = (mid - left) + 1, size2 = (right - mid);

                // Create temporary arrays to hold the two subarrays
                int[] leftArray = new int[size1];
                int[] rightArray = new int[size2];

                // Copy data into the temporary arrays from the original array
                // here, arraycopy(source_array, start_position_of_source, destination_array, start_position_of_destination_array, total_number_of_element_to_copy)
                System.arraycopy(array, left, leftArray, 0, size1);
                System.arraycopy(array, (mid+1) , rightArray, 0, size2);

                // Initialize indices for the leftArray, rightArray, and the merged array
                int i = 0, j = 0;
                int k = left; // for merged array

                // Merge the two subarrays by comparing their elements
                while((i < size1) && (j < size2) ) {
                        if(leftArray[i] <= rightArray[j]) {

                                // Copy smaller element from leftArray
                                array[k] = leftArray[i];

                                // Move to the next element's index position
                                i++;
                        } else {

                                // Copy smaller element from rightArray
                                array[k] = rightArray[j];

                                // Move to the next element's index position
                                j++;
                        }

                        k++;
                }

                // Copy any remaining elements from leftArray (if any)
                while(i < size1) {
                        array[k] = leftArray[i];
                        i++;
                        k++;
                }

                // Copy any remaining elements from rightArray (if any)
                while(j < size2) {
                        array[k] = rightArray[j];
                        j++;
                        k++;
                }
        }

}

/*
The time complexity of Merge Sort is the same in all cases (best, average,
and worst) because the algorithm consistently divides the array into two halves
and then merges them in linear time.

1. Best Case Time Complexity: O(n log n)

Explanation: Even if the array is already sorted, Merge Sort will still divide
the array into halves, recursively sort both halves, and then merge them.
Since the process of splitting and merging happens in a fixed manner,
the time complexity remains the same: O(n log n).


2. Average Case Time Complexity: O(n log n)

Explanation: On average, the algorithm will divide the array and merge it in exactly the
same way regardless of how the elements are distributed. Each level of recursion performs
merging in O(n) time, and there are log n levels of recursion, leading to a time complexity of O(n log n).


3. Worst Case Time Complexity: O(n log n)

Explanation: In the worst case (when the array is in reverse order, for example),
Merge Sort still divides the array into two halves and merges them after sorting.
The number of comparisons and merges remains consistent with the other cases,
making the time complexity O(n log n).


Summary:

Best Case: O(n log n)

Average Case: O(n log n)

Worst Case: O(n log n)


Why Time Complexity is Always O(n log n):

Dividing the array takes logarithmic time because the array is divided in half recursively
until subarrays of size 1 are reached: this results in log n levels of recursion.

Merging the subarrays takes linear time for each level of recursion, as the total number
of elements being merged at each level is n.


Thus, the overall time complexity is O(n log n) in all cases.



Space Complexity:

Merge sort requires additional space for the temporary arrays (leftArray and rightArray),
which results in a space complexity of O(n).
*/