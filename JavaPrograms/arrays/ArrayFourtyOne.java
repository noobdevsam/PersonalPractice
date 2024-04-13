package arrays;

import java.util.Arrays;

// program to find all equilibrium indices from a array of integer
public class ArrayFourtyOne {
    public static void main(String[] args) {
        int[] arr = { -7, 1, 5, 2, -4, 3, 0 };
        System.out.println(Arrays.toString(arr));

        findEquilibrium_indices(arr);
    }

    private static void findEquilibrium_indices(int[] arr) {
        int totalSum = 0, leftSum = 0;

        for (int num : arr) {
            totalSum += num;
        }

        for (int i = 0; i < arr.length; i++) {
            totalSum -= arr[i]; // substracting current element

            if (leftSum == totalSum) {
                System.out.println("Equilibrium index found at: " + i);
            }

            leftSum += arr[i];
        }
    }
}

/*
 * An equilibrium index of an array is an index such that the sum of elements at
 * lower indexes is equal to the sum of elements at higher indexes.
 * 
 * In this program, the `findEquilibriumIndices` method calculates the total sum
 * of the array elements first. Then it iterates over the array and for each
 * element, it subtracts the current element from the total sum and compares the
 * total sum with the sum of the elements on the left. If they are equal, it
 * means an equilibrium index is found, so it prints the index. After checking
 * the current index, it adds the current element to the left sum. This way, the
 * method finds all equilibrium indices in the array.
 */