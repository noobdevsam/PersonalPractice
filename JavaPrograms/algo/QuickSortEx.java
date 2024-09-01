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
    The while loops ensure that i moves to the right until it finds an element greater than the pivot, and j moves to the left until it finds an element smaller than or equal to the pivot.
    When i and j meet or cross each other, the loop ends, and the pivot is swapped with the element at index j to place it in the correct position.
 */