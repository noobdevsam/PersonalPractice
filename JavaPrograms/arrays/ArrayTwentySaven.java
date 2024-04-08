package arrays;

import java.util.Arrays;

// program to shift all 0's to left and all 1's to right
public class ArrayTwentySaven {
    public static void main(String[] args) {
        int[] arr= {0,1,0,1,1,0};
        int left = 0;
        int right = arr.length-1;

        while (left < right) {
            if (arr[left] == 1) {
                swap(arr, left, right);
                right--;
            } else {
                left++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}

/* another implementation
 *  public static void main(String[] args) {
        int[] arr = {0, 1, 0, 1, 1, 0};
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int num : arr) {
            if (num == 0) {
                left.add(num);
            } else {
                right.add(num);
            }
        }
        left.addAll(right);
        System.out.println(left);
    }
 */