package arrays;

import java.util.ArrayList;
import java.util.List;

// find list of anti-diagonal indecies of a square matrix
public class ArrayTwrentyFour {
    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        List<List<Integer>> diagonals = findAntiDiagonals(matrix);

        for (List<Integer> list : diagonals) {
            System.out.println(list);
        }
    }

    private static List<List<Integer>> findAntiDiagonals(int[][] matrix) {
        int n = matrix.length;
        List<List<Integer>> diagonals = new ArrayList<>();

        // handle base case for empty matrix
        if (n == 0) {
            return diagonals;
        }

        for (int sum = 0; sum < (2 * n - 1); sum++) {
            List<Integer> diagonal = new ArrayList<>();

            // iterate based on the sum of row and column indices
            for (int row = 0; (row <= sum) && (row < n); row++) {
                int col = sum - row;
                if (col >= 0 && col < n) {
                    diagonal.add(matrix[row][col]);
                }
            }

            if (!diagonal.isEmpty()) {
                diagonals.add(diagonal);
            }
        }

        return diagonals;
    }
}

/*
 * 
This solution utilizes a single loop based on the sum of the row and column indices (sum). It iterates through all possible combinations of these indices from 0 to 2 * n - 2.  Here's the breakdown:

    Loop based on sum: We iterate through all possible sums of row and column indices (sum). This ensures we cover all diagonals.
    Inner loop for elements: For each sum, we iterate through rows (row) from 0 to sum (inclusive) and calculate the corresponding column (col = sum - row). If both row and col are within the matrix bounds, we add the element to the current diagonal list.
    Adding non-empty diagonals: We only add the diagonal list to the final result (diagonals) if it contains elements (not empty).


**1. Initialization:**

- The code defines a method `findAntiDiagonals` that takes a square matrix (`matrix`) as input and returns a list of lists (`diagonals`), where each inner list represents an anti-diagonal.
- It retrieves the matrix size (`n`) and initializes an empty list (`diagonals`) to store the anti-diagonals.
- Similar to the previous solution, it handles the base case for an empty matrix (`n == 0`).

**2. Looping based on sum:**

- The core logic lies within a `for` loop that iterates through a range of `sum` values from 0 to `2 * n - 1`.
  - This range ensures we cover all possible combinations of row and column indices for anti-diagonals in an `n x n` matrix.

**3. Building the diagonal list:**

  - Inside the loop, an empty list `diagonal` is created to store the elements of the current anti-diagonal.

**4. Inner loop for elements:**

  - We iterate through rows (`row`) from 0 to the current `sum` (inclusive) using another `for` loop.
    - The corresponding column index (`col`) is calculated for each `row` using the formula `col = sum - row`. This ensures we move diagonally based on the current `sum`.

  - We check two conditions before adding an element to the `diagonal` list:
    - `col >= 0 && col < n`: This ensures the calculated column index is within the valid range of the matrix (avoiding out-of-bounds access).
    - This check prevents adding elements from outside the matrix boundaries, which wouldn't be part of any anti-diagonal.

  - If both conditions are met, the element at `matrix[row][col]` is added to the `diagonal` list.

**5. Adding non-empty diagonals:**

- After iterating through all possible rows for the current `sum`, we check if the `diagonal` list is empty.
  - We only add the `diagonal` list to the final result (`diagonals`) if it contains elements (not empty). This is because some `sum` values might not correspond to actual anti-diagonals (e.g., `sum` exceeding matrix dimensions).

**6. Returning the result:**

  - After iterating through all possible `sum` values, the function returns the final list (`diagonals`) containing all the extracted anti-diagonals from the input matrix.

This approach offers a more concise solution by using a single loop based on the sum of row and column indices. It avoids separate iterations for different starting points on the top row or column and efficiently captures all anti-diagonals in the matrix.

 */