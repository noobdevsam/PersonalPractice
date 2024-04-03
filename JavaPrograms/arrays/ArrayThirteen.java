package arrays;

import java.util.Arrays;

// program to remove duplicate elements from a array of integer
public class ArrayThirteen {

    public static void main(String[] args) {
        int[] a = {1,2,1,2,3,4,5,6,4,4,5,5,7,8,8,0,9,0,9};
        int length = a.length;
        removeDuplicates(a, length);
    }
    
    public static void removeDuplicates(int[] a, int length) {
        int j = 0; // used as an index to keep track of the unique elements encountered so far
        Arrays.sort(a);
        //  iterates 'a' except for the last element (since it won't be compared with another element) 
        for (int i = 0; i < length - 1; i++) {

            // checks if current element is different from next element
            if (a[i] != a[i + 1]) {
                // copies element of index i to index j
                a[j] = a[i];
                j++; // point to next available position to store anothor unique element
            }
        }

        //copies the last element of the array to the position pointed to by j, ensuring it's included in the unique elements.
        a[j] = a[length - 1];
        j++; //  increments j one last time to account for the last element being copied.

        // iterates through the modified array
        for (int i = 0; i < j; i++) {
            System.out.print(a[i]+" ");
        }
    }
    
}
