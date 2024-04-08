package arrays;
// cyclally rotate an array
public class ArrayTwentyNine {
    public static void main(String[] args) {
        int[] arr = { 5, 52, 8, 96, 6, 2, 23, 46, 48, 685, 85 };
        rotate(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void rotate(int[] arr) {
        if (arr.length != 0 || arr.length != 1) {
            int last = arr[arr.length-1];

            // iterate backward from second last element to first element
            for (int i = (arr.length - 2); i >=0; i--) {
                arr[i + 1] = arr[i];// shift element to right by one position
            }
            arr[0] = last;
        } else {
            System.out.println("Error");
        }
    }
}
