package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// program to find the common element between two array of string
public class ArrayEleven {
    public static void main(String[] args) {
        String[] arr1 = {"apple", "banana", "cherry", "orange"};
        String[] arr2 = {"mango", "apple", "grape", "banana"};

        String[] commonElements = findCommonElements(arr1,arr2);
        System.out.println("Common elements: " + Arrays.toString(commonElements));
    }

    private static String[] findCommonElements(String[] arr1, String[] arr2) {
        List<String> cElements = new ArrayList<>();

        for (String element : arr1) {
            for (String item : arr2) {
                if (element.equals(item)) {
                    // add common element to a separate list
                    cElements.add(element);
                    
                    // exits the inner loop immediately after finding a common element because we only care about finding the first occurrence of a common element for each element in the first array.
                    break;
                }
            }
        }

        return cElements.toArray(new String[cElements.size()]);
    }
}
