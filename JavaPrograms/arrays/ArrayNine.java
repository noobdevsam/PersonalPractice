package arrays;

// program to find duplicate elements and their index value of first appearance
public class ArrayNine {
    public static void main(String[] args) {
        int[] arr = {4,6,8,2,2,8,1,7,3,5,1,7,3,2,4,6,5};
        findDuplicate(arr);
    }

    private static void findDuplicate(int[] arr) {
        boolean[] seen = new boolean[arr.length];

        // iterate through the given array
        for (int i = 0; i < arr.length; i++) {
            if(seen[arr[i]]) {
                System.out.println("Element " + arr[i] + " appeared more than once, first at index: " + findFirstIndex(arr, i));
            } else {
                seen[arr[i]] = true;
            }
        }
    }

    // method to find the first index of a duplicate element
    private static int findFirstIndex(int[] arr, int currentIndex) {
        for (int i = 0; i < currentIndex; i++) {
            if (arr[i] == arr[currentIndex]) {
                return i;
            }
        }
        return -1; // not found before currentIndex
    }

    /*
    Here's a breakdown of why it works:

        1. **`seen` array:** The `seen` array is a boolean array with the same size as the input array. It's used to track if an element has been encountered before.
        2. **Outer loop:** The outer loop iterates through each element in the input array.
        3. **Checking for duplicates:** Inside the loop, it checks if the current element's index (`arr[i]`) in the `seen` array is already marked as true. This indicates the element has been seen before.
            - If a duplicate is found (`seen[arr[i]] == true`), the program calls `findFirstIndex` to get the first occurrence's index. It then prints details about the duplicate element.
            - If the element hasn't been seen yet (`seen[arr[i]] == false`), the program marks it as seen by setting the corresponding index in the `seen` array to true.
        4. **`findFirstIndex` function:** This function iterates through the array from the beginning (index 0) up to, but not including, the current index (`currentIndex`). It checks if any element before the current one matches the current element. If a match is found, it returns the index of the first occurrence. Otherwise, it returns -1.
    */
}


