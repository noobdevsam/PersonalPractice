package arrays;

import java.util.Arrays;

// program to find if sum of all 10's is equal to 30
public class ArrayTwentyTwo {
	public static void main(String[] args) {
		int[] arr = {10, 77, 10, 54, -11, 10};
		int search_val = 10, fixed_sum = 30, temp_sum = 0;

		System.out.println(Arrays.toString(arr));
		
		for(int i : arr) {
			if(i == search_val) {
				temp_sum += search_val;
			}

			if(temp_sum >= fixed_sum) {
				break;
			}
		}

		System.out.println("Is sum of all 10's is equal to "+ fixed_sum + " : " + (temp_sum == fixed_sum));
	}
}
