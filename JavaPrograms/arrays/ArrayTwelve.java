package arrays;

import java.util.HashSet;
import java.util.Set;

public class ArrayTwelve {
    public static void main(String[] args) {
        int[] arr1 = {2,3,5,2,8,9,5,3,6,4,8};
        int[] arr2 = {6,4,7,9,3,4,2};

        String commonElements = findCommonElements(arr1,arr2);
        System.out.println("Common elements: " + commonElements);
    }

    private static String findCommonElements(int[] arr1, int[] arr2) {
        Set<Integer> cElements = new HashSet<>();

        for (int i : arr1) {
            for (int j : arr2) {
                if(i==j) {
                    cElements.add(i);
                    break;
                }
            }
        }

        return String.valueOf(cElements.toString());
    }
}