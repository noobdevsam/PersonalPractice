package arrays;

// move all the '0(zero)'s to the end of the array
// maintain the relative order of non-zero elements
public class ArrayEighteen {
    public static void main(String[] args) {
        int[] arr = {1,0,3,12,0,5,0};
        moveZeros(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void moveZeros(int[] arr) {
        // keeps track of the next available position for a non-zero element
        int non_zero_index = 0; 

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                if (i != non_zero_index) {
                    // swap elements if current element is non-zero and not already at the non-zero-index
                    int temp = arr[i];
                    arr[i] = arr[non_zero_index];
                    arr[non_zero_index] = temp;
                }

                // point to the next available position for a non-zero element
                non_zero_index++;
            }
        }
    }
}
