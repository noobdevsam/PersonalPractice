package arrays;

import java.util.Arrays;

// program to find difference between largest and smallest element
// while array length must be greater than 1
public class ArrayTwenty {
	public static void main(String[] args) {
		int[] arr = {4,5,35,75,46,65};
		int max_val = arr[0], min = arr[0];

		System.out.println(Arrays.toString(arr));
		
		if(arr.length > 1) {
			for(int i : arr) {
				if(i > max_val) {
					max_val = i;
				} else if(i < min) {
					min = i;
				}
			}
		} else {
			System.out.println("error");
		}

		System.out.printf("Difference between largest(%d) and smallest(%d) element: (%d)",max_val, min, (max_val - min));
	}
}
