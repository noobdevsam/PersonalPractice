package Arrays;

// print a two dimentional array
public class ArrayTwo {
    public static void main(String[] args) {
        int row = 4, col = 4;
        int[][] array = new int[row][col];

        array[0][1] = 34;
        array[2][2] = 37;
        array[3][3] = 23;

        for(int[] i : array) { // selecting one dimention and extracting its values to another array
            for (int j : i) { // iterating elements from the new array
                System.out.printf("%4d", j); // printing out the single element
            }
            System.out.println(); // creating the next line
        }
    }
}
