package arrays;

import java.util.Arrays;

// program to find total possible triangle number
public class ArrayTwentyEight {
    public static void main(String[] args) {
        int[] arr = {4,6,7,3};
        int triangles = countTriangles(arr);
        System.out.println("Total possible triangles: " + triangles);
    }

    private static int countTriangles(int[] arr) {
        int n = arr.length, count = 0;
        Arrays.sort(arr);

        // iterate upto third last element
        for (int i = 0; i < (n-2); i++) { 

            // iterate upto second last element
            for (int j = (i+1); j < (n-1); j++) { 

                // iterate upto last element, (similar to for-each )
                for (int k = (j+1); k < n; k++) { 

                    // main logic
                    if (arr[i] + arr[j] > arr[k]) {
                        count++;
                    } else {
                        break; // no need to check further(sorted array)
                    }
                }
            }
        }

        return count;
    }
}
