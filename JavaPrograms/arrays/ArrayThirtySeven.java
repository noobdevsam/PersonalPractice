package arrays;

import java.util.Arrays;

// program to (merge+sort) into one array and split elments into two arrays
public class ArrayThirtySeven {
    public static void main(String[] args) {
        int[] A = {1,5,6,7,8,10};
        int[] B = {2,4,9};

        System.out.println("Unsorted: ");
        System.out.println("A: " + Arrays.toString(A));
        System.out.println("B: " + Arrays.toString(B));

        int p = A.length, q = B.length;
        
        // merge A and B into C
        int[] C = new int[p+q];
        int i = 0, j = 0, k = 0;
        while (i < p && j < q) {
            if (A[i] < B[j]) {
                C[k++] = A[i++];
            } else {
                C[k++] = B[j++];
            }
        }

        // copy remaining elements if there is any and not copied yet
        while (i < p) {
            C[k++] = A[i++];
        }
        while (j < q) {
            C[k++] = B[j++];
        }

        // split C back into A and B
        for (i = 0; i < p; i++) {
            A[i] = C[i];
        }
        for (i = 0; i < q; i++) {
            B[i] = C[i+p];
        }

        System.out.println("Sorted and splited: ");
        System.out.println("A: " + Arrays.toString(A));
        System.out.println("B: " + Arrays.toString(B));
    }    
}

/*
 * **Merging Arrays**: The program uses three indices `i`, `j`, and `k` to track the current positions in arrays `A`, `B`, and `C`. It enters a loop that continues until all elements from both `A` and `B` have been considered:
   - If the current element in `A` is less than the current element in `B`, the element from `A` is copied to `C`, and the index `i` is incremented.
   - If the current element in `B` is less than or equal to the current element in `A`, the element from `B` is copied to `C`, and the index `j` is incremented.
   - The index `k` is incremented after each copy to the next position in `C`.

3. **Handling Remaining Elements**: After the loop, there may be some remaining elements in either `A` or `B` that haven't been copied to `C`. Two additional loops are used to copy these remaining elements.

4. **Splitting Array `C`**: Once all elements are merged into `C`, the program then splits `C` back into two arrays:
   - The first `p` elements of `C` are copied back into `A`.
   - The remaining elements of `C` are copied into `B`.

5. **Output**: Finally, the program prints the sorted arrays `A` and `B` to the console.

The result is that array `A` contains the first `p` smallest elements (in sorted order), and array `B` contains the remaining elements, also in sorted order, as per the example provided.
 */