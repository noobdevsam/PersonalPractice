package arrays;

import java.util.Arrays;

// insert an element inside an array to a specified postion
public class ArraySix {
    public static void main(String[] args) {
        int[] arr = {45,54,6,64,831,88345,48413,54845,46,86,374,89};
        int index_position = 4, new_value = 34;
        System.out.println("Original array: " + Arrays.toString(arr));

        //shift element to right to create space in array
        //iterate the array from last to the specified index
        for (int i = (arr.length - 1); i > index_position; i--) {
            arr[i] = arr[i - 1];
        }

        arr[index_position] = new_value;
        System.out.println("New arry: " + Arrays.toString(arr));
    }
}
