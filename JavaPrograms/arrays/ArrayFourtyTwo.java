package arrays;

// program to replace each element with the product of all other elements
public class ArrayFourtyTwo {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        replaceWithProduct(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void replaceWithProduct(int[] arr) {
        int len = arr.length;
        int right = 1;
        int[] temp = new int[len];

        temp[0] = 1;

        // iterate in forward direction from second index
        for (int i = 1; i < len; i++) {
            temp[i] = temp[i-1] * arr[i-1];
        }

        // iterate in backward direction from last index
        for (int i = (len-1); i >= 0; i--) {
            temp[i] *= right;
            right *= arr[i];
        }

        System.arraycopy(temp, 0, arr, 0, len);
    }
}

/*
 * The `replaceWithProduct` method:
   - A temporary array `temp` of the same length as `nums` is created.
   - The first element of `temp` is set to `1`.
   - A `for` loop is used to populate `temp` such that each element `temp[i]` is the product of all elements in `nums` before `i`.
   - A variable `right` is initialized to `1`. This will hold the product of all elements in `nums` after `i`.
   - A `for` loop is used to update each element `temp[i]` by multiplying it with the product of all elements in `nums` after `i`. This is done in reverse order, starting from the end of the array.
   - Finally, the `System.arraycopy` method is used to copy the elements from `temp` back into `nums`.

This is a common problem in coding interviews. It's also a good exercise in understanding how to manipulate arrays in Java.
 */