package arrays;

// program to find the element pair whose sum is equal to a specified value
public class ArraySixteen {
    public static void main(String[] args) {
        int[] arr = {2, 7,4,-5,11,5,20};
        int[] arra = {14, -15, 9, 16, 25, 45, 12, 8};
        
        findPairs(arr, 15);
        findPairs(arra, 30);
    }

    private static void findPairs(int[] arr, int val) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == val) {
                    System.out.println(arr[i] + " + " + arr[j] + " = " + val);
                }
            }
        }
    }
}