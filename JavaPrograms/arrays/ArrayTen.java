package arrays;

import java.util.HashMap;

public class ArrayTen {
    public static void main(String[] args) {
        String[] arr = {"apple", "banana", "cherry", "apple", "orange", "banana"};
        findDuplicates(arr);
    }

    private static void findDuplicates(String[] arr) {
        HashMap<String, Integer> seen = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            // get the current string from the array 
            String str = arr[i];

            // checks if the 'seen' already contains the current string (str) as a key
            if(seen.containsKey(str)) {

                // retrieves the value associated with the key (str) from the 'seen' as this value represents the first index where the string appeared in the array.
                int firstIndex = seen.get(str);
                System.out.println("String \"" + str + "\" appeared more than once, first at index: " + firstIndex );
            } else {
                // if not present, add (str) as key and (index) as value
                seen.put(str, i);
            }
        }
    }
}