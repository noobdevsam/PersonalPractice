package arrays;

import java.util.Arrays;

// program to find total even and odd numbers
public class ArrayNineteen {
	public static void main(String[] args) {
		int[] arr = {36,27,38,28,24,83,63,64,53};
		int total_evens = 0;

		System.out.println(Arrays.toString(arr));
		
		for(int i : arr) {
			if((i%2) == 0) {
				total_evens++;
			}
		}

		System.out.println("total evens: " + total_evens);
		System.out.println("total odds: " + (arr.length - total_evens));
	}
}
