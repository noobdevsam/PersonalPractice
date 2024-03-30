package arrays;

// check if a value exists in a array
public class ArrayThree {
    public static void main(String[] args) {
        int[] arr = {54,78,235,65,45,323};
        System.out.println(ispresent(arr,43));
        System.out.println(ispresent(arr,65));
    }

    private static boolean ispresent(int[] arr, int i) {
        for (int n : arr) {
            if (i == n) {
                return true;
            }
        }
        return false;
    }

}
