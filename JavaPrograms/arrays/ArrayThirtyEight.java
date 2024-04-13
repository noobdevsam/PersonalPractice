package arrays;

// find the pair and value of max product from the array
public class ArrayThirtyEight {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 7, -7, 5, 8, -5};

        find_max_product_and_pair(arr);
    }

    private static void find_max_product_and_pair(int[] arr) {
        int max_pair_product = Integer.MIN_VALUE, max_i = -1, max_j = -1;

        for (int i = 0; i < (arr.length - 1); i++) {
            for (int j = (i+1); j < arr.length; j++) {
                if ( max_pair_product < (arr[i]*arr[j]) ) {
                    max_pair_product = arr[i]*arr[j];
                    max_i = i;
                    max_j = j;
                }
            }
        }

        System.out.println( "Pair is (" + arr[max_i] + "," + arr[max_j] + ") , max product : " + max_pair_product);
    }
}
