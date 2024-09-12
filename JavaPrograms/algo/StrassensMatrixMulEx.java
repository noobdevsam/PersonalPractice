package algo;
import java.util.Arrays;

public class StrassensMatrixMulEx {

    // Function to multiply matrices using Strassen's algorithm
    private static int[][] strassenMultiply(int[][] A, int[][] B) {
        int n = A.length;                                                           if (n == 1) {
            return new int[][]{{A[0][0] * B[0][0]}};
        }

        // Splitting the matrices into quadrants
        int newSize = n / 2;
        int[][] A11 = new int[newSize][newSize];
        int[][] A12 = new int[newSize][newSize];
        int[][] A21 = new int[newSize][newSize];
        int[][] A22 = new int[newSize][newSize];

        int[][] B11 = new int[newSize][newSize];
        int[][] B12 = new int[newSize][newSize];                                    int[][] B21 = new int[newSize][newSize];
        int[][] B22 = new int[newSize][newSize];

        // Divide A and B into submatrices
        divideMatrix(A, A11, 0, 0); //Creating A11 from A with 4 elements
        divideMatrix(A, A12, 0, newSize); // Creating A12 from A with 4 elements
        divideMatrix(A, A21, newSize, 0); // Creating A21 from A with 4 elements
        divideMatrix(A, A22, newSize, newSize); // Creating A22 from A with 4 elements                                                                  
        divideMatrix(B, B11, 0, 0); // Creating B11 from B with 4 elements
        divideMatrix(B, B12, 0, newSize); // Creating B12 from B with 4 elements
        divideMatrix(B, B21, newSize, 0); // Creating B21 from B with 4 elements
        divideMatrix(B, B22, newSize, newSize); // Creating B22 from B with 4 elements

        // Strassen's formulae for calculating the seven products
        // P or M1 = (A11+A22)*(B11+B22)
        int[][] M1 = strassenMultiply(addMatrices(A11, A22), addMatrices(B11, B22));
        // Q or M2 = (A21+A22)*B11
        int[][] M2 = strassenMultiply(addMatrices(A21, A22), B11);
        // R or M3 = A11*(B12-B22)
        int[][] M3 = strassenMultiply(A11, subtractMatrices(B12, B22));
        // S or M4 = A22*(B21-B11)
        int[][] M4 = strassenMultiply(A22, subtractMatrices(B21, B11));
        // T or M5 = (A11+A12)*B22
        int[][] M5 = strassenMultiply(addMatrices(A11, A12), B22);
        // U or M6 = (A21-A11)*(B11+B12)
        int[][] M6 = strassenMultiply(subtractMatrices(A21, A11), addMatrices(B11, B12));
        // V or M7 = (A12-A22)*(B21+B22)
        int[][] M7 = strassenMultiply(subtractMatrices(A12, A22), addMatrices(B21, B22));

        // Calculating the final quadrants of the result matrix
        // C11 = P+S-T+V
        int[][] C11 = addMatrices(subtractMatrices(addMatrices(M1, M4), M5), M7);
        // C12 = R+T
        int[][] C12 = addMatrices(M3, M5);
        // C21 = Q+S
        int[][] C21 = addMatrices(M2, M4);
        // C22 = P+R-Q+U
        int[][] C22 = addMatrices(subtractMatrices(addMatrices(M1, M3), M2), M6);

        // Combining the quadrants into the result matrix
        int[][] C = new int[n][n];
        combineMatrix(C, C11, 0, 0);
        combineMatrix(C, C12, 0, newSize);
        combineMatrix(C, C21, newSize, 0);
        combineMatrix(C, C22, newSize, newSize);

        return C;
    }

    // Method to add two matrices
    private static int[][] addMatrices(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }
        return result;
    }

    // Method to subtract two matrices
    private static int[][] subtractMatrices(int[][] A, int[][] B) {
        int n = A.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = A[i][j] - B[i][j];
            }
        }
        return result;
    }

    // Method to divide a matrix into quadrants
    private static void divideMatrix(int[][] parent, int[][] child, int rowStart, int colStart) {
        for (int i = 0, r = rowStart; i < child.length; i++, r++) {
            for (int j = 0, c = colStart; j < child.length; j++, c++) {
                child[i][j] = parent[r][c];
            }
        }
    }

    // Method to combine quadrants into a matrix
    private static void combineMatrix(int[][] parent, int[][] child, int rowStart, int colStart) {
        for (int i = 0, r = rowStart; i < child.length; i++, r++) {
            for (int j = 0, c = colStart; j < child.length; j++, c++) {
                parent[r][c] = child[i][j];
            }
        }
    }

    // Helper function to print matrices
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    // Main method for testing the implementation
    public static void main(String[] args) {
        int[][] A = {
            {1,2,3,4},
            {3,4,5,7},
            {6,7,8,9},
            {9,2,6,4}
        };

        int[][] B = {
            {5,6,8,5},
            {7,8,9,0},
            {0,3,5,2},
            {7,9,4,1}
        };

        int[][] result = strassenMultiply(A, B);

        System.out.println("Resultant Matrix:");
        printMatrix(result);
    }
}


/*

The divideMatrix and combineMatrix methods are essential for splitting and merging matrices in Strassen's algorithm.
Here’s a detailed explanation of each:

1. divideMatrix Method
Purpose: This method extracts a submatrix (quadrant) from the main matrix. It's used to split a larger matrix into
four smaller submatrices during Strassen's recursive steps.

Signature:
----------
divideMatrix(int[][] parent, int[][] child, int rowStart, int colStart)

Parameters:
-----------
parent: The larger matrix to be split.

child: The submatrix that will hold the divided part of the parent matrix.

rowStart: The starting row index in the parent matrix from where the submatrix should be copied.

colStart: The starting column index in the parent matrix from where the submatrix should be copied.


Logic:

The method iterates over the parent matrix from the given starting row and column.

It copies values from the parent matrix to the child matrix, row by row, and column by column.


Example: Let’s assume you have a 4x4 matrix A and want to divide it into 2x2 submatrices:

A = {
    {1, 2, 3, 4},
    {5, 6, 7, 8},
    {9, 10, 11, 12},
    {13, 14, 15, 16}
};

Now, if you call divideMatrix(A, A11, 0, 0), it extracts the top-left quadrant:

A11 = {
    {1, 2},
    {5, 6}
};

Similarly, other submatrices like A12, A21, and A22 are extracted by adjusting the rowStart and colStart values.

2. combineMatrix Method

Purpose: This method is used to combine smaller submatrices (quadrants) back into a larger matrix.
It’s the reverse of the divideMatrix method. After computing the four quadrants of the result matrix,
this method combines them into the full matrix.

Signature:

public static void combineMatrix(int[][] parent, int[][] child, int rowStart, int colStart)

Parameters:

parent: The larger matrix where the smaller child matrix will be placed.

child: The submatrix that will be placed inside the parent matrix.

rowStart: The starting row in the parent matrix where the child matrix should be inserted.

colStart: The starting column in the parent matrix where the child matrix should be inserted.


Logic:

This method iterates through the child matrix and places its values into the appropriate location within the
parent matrix, starting from rowStart and colStart.


Example: If you want to place the following submatrix C11 (which is 2x2) into the top-left corner of a 4x4 matrix C:

C11 = {
    {10, 12},
    {14, 16}
};

You would call combineMatrix(C, C11, 0, 0), and C would now look like this (assuming other quadrants are not yet filled):

C = {
    {10, 12, 0, 0},
    {14, 16, 0, 0},
    {0, 0, 0, 0},
    {0, 0, 0, 0}
};

General Flow in Strassen's Algorithm

1. Divide Phase (divideMatrix):

The larger matrices  and  are divided into four quadrants (A11, A12, A21, A22) and (B11, B12, B21, B22).



2. Recursive Multiplication:

The seven Strassen sub-multiplications are performed on the submatrices.



3. Combine Phase (combineMatrix):

After the recursive multiplications, the result quadrants (C11, C12, C21, C22) are combined back into the final result matrix.




In Summary:

divideMatrix: Takes part of the matrix (a quadrant) and stores it in a smaller matrix.

combineMatrix: Inserts a smaller matrix into the correct position of a larger matrix, effectively merging the result
quadrants back into the full matrix.

*/