package arrays;

// find the index of an element from an array
public class ArrayFour {
    public static void main(String[] args) {
        int[] arr = {64,668,365,1658,1544,44,784,1514,578};
        System.out.println(find_index(arr, 668));
        System.out.println(find_index(arr, 44));
        System.out.println(find_index(arr, 578));

    }

    private static int find_index(int[] array, int item) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == item) {
                return i;
            }
        }
        return -1;
    }
}
