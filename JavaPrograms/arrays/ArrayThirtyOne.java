package arrays;

// program to arrange all negative elements from first place and then arrange all positive elements while maintaining their relative order
public class ArrayThirtyOne {
    public static void main(String[] args) {
        int[] arr = {3,-1,2,-5,4,8};

        rearrange(arr);

        System.out.println("Rearranged array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void rearrange(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            // main logic for negative -> positive
            if (arr[i] < 0) {
                swap(arr, count, i);
                count++;
            }

            //  main logic for positive -> negative
            // if (arr[i] > 0) {
            //     swap(arr, count, i);
            //     count++;
            // }
        }
    }

    private static void swap(int[] arr, int count, int i) {
        int temp = arr[count];
        arr[count] = arr[i];
        arr[i] = temp;
    }
}

// explain:
/*
 * rearrange method:
        Takes an integer array arr as input.
        Initializes 'count' to 0, which will keep track of the insertion point for negative elements.
        Loops through the array using 'i' as the index.
        Checks if the current element arr[i] is negative.
            If negative, it swaps the element at 'count' and 'i' using the swap method.
            Increments 'count' to prepare for the next negative element.
    swap method:
        Takes the array 'arr', two indices 'count' and 'i', as input.
        Creates a temporary variable temp to hold the value at arr[count].
        Swaps the values at arr[count] and arr[i] using the temporary variable.

    It maintains the relative order of positive elements while placing all negative elements at the beginning of the array.
 */