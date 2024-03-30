package arrays;

import java.util.Arrays;

//java program to sort numeric|string array
public class ArrayOne{
    public static void main(String[] args) {
        // declare and initialize array
        int[] arr1 = {545,45,46,4648,64685,8548,14,358,846,84364586};
        String[] arr2 = {"Java","Python", "PHP", "C#", "C Programming", "C++"};

        System.out.println("Numeric array: " + Arrays.toString(arr1));
        Arrays.sort(arr1);
        System.out.println("Sorted Numeric array: " + Arrays.toString(arr1));
        System.out.println();
        System.out.println("String array: " + Arrays.toString(arr2));
        Arrays.sort(arr2);
        System.out.println("String array: " + Arrays.toString(arr2));

    }
}