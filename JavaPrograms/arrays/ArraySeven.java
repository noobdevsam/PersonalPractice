package arrays;

// find min and max value from a array
public class ArraySeven {
    public static void main(String[] args) {
        int[] arr = {351,58468,68743,354,35476,31,54,3543,43};
        int min = arr[0], max = arr[0];

        for (int i : arr) {
            if (i > max) {
                max = i;
            }

            if (i < min) {
                min = i;
            }
        }

        System.out.println("Min value: " + min);
        System.out.println("Max value: " + max);
    }
}
