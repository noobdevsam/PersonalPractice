package arrays;

// program to find all leader elements
// An element is leader if it is greater than all the elements to its right side
public class ArrayTwentySix {

    public static void main(String[] args) {
        int[] arr = { 10, 9, 14, 23, 15, 0, 9 }; // Array of integers
        int n = arr.length; // Length of the array

        for (int i = 0; i < n; i++) {
            int j = 0; // Inner loop counter (initialized for each outer loop iteration)

            for (j = i + 1; j < n; j++) { // Inner loop iterates from the next element (i+1)
                if (arr[j] >= arr[i]) {
                    break;
                    /*
                     * Check if the current element (arr[j]) is greater than or equal to the element
                     * at index 'i'
                     * If so, break the inner loop (no need to continue checking)
                     */
                }
            }

            if (j == n) {
                System.out.print(arr[i] + " ");
                /*
                 * Print the element at index 'i' if the inner loop wasn't broken (i.e.,
                 * no larger elements found)
                 */
            }
        }
    }
}
