package arrays;

import java.util.ArrayList;
import java.util.Arrays;

// separate even and odd numbers from a given array of integers. Put all even numbers first, and then odd numbers.   
public class ArrayThirtyThree {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int evenCount = 0, oddCount = 0, evenIndex = 0, oddIndex = 0;
        var list = new ArrayList<Integer>();
        

        // count even and odd numbers
        for (int i : arr) {
            if(i%2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        int[] even = new int[evenCount];
        int[] odd = new int[oddCount];

        for (int i : arr) {
            if(i%2 == 0) {
                even[evenIndex++] = i;
            } else {
                odd[oddIndex++] = i;
            }
        }

        for (int i : even) {
            list.add(i);
        }

        for (int i : odd) {
            list.add(i);
        }
        System.out.println("Orginal: " + Arrays.toString(arr));
        System.out.println("Modified: " +list.toString());
    }
}
