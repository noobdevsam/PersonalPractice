package arrays;

import java.util.Arrays;

// program to find the average of the elements except largest and smalleat element
public class ArrayTwentyOne {
	public static void main(String[] args) {
		int[] arr = {4,5,35,75,46,65};
		int max_val = arr[0], min = arr[0], sum = arr[0];

		System.out.println(Arrays.toString(arr));
		
		if(arr.length > 1) {
			for(int i : arr) {
			
				sum += i;
				
				if(i > max_val) {
					max_val = i;
				} else if(i < min) {
					min = i;
				}
				
			}
		} else {
			System.out.println("error");
		}

		float avg = ((sum - max_val - min) / (arr.length - 2));
		System.out.println("Average value(except largest and smallest element):" + avg);
	}
}
