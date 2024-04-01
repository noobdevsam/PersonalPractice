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

}


