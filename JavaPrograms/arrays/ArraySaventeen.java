package arrays;

import java.util.ArrayList;
import java.util.Arrays;

// find common elements in three arrays
public class ArraySaventeen {
    public static void main(String[] args) {
        int arr1[] = {2, 88, 4, 8};
        int arr2[] = {2, 3, 4, 79, 8, 10, 16};
        int arr3[] = {67, 4, 8, 14, 40};

        findCommonElements(arr1, arr2, arr3);
    }

    private static void findCommonElements(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0, j = 0 , k = 0;
        var common = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);

        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if ((arr1[i] == arr2[j]) && (arr2[j] == arr3[k])) {
                common.add(arr1[i]);
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }

        System.out.println("Common elements: " + common);
    }    
}