import java.util.Arrays;

public class JavaArrayProblemThree {
	//adding new element to the array
	public static void main(String[] args) {
		int[] my_array = {25, 14, 56, 15, 65, 85, 75, 36, 19, 93, 43};
		int index_position = 3, new_value = 20;
		
		System.out.println("Original Array: "+ Arrays.toString(my_array)); 

		// creating new array from existing array
		int[] new_array = Arrays.copyOf(my_array, my_array.length + 1);

		// creating space by shifting elemnets to the right
		for(int i = (new_array.length - 1); i > index_position; i--) {
			new_array[i] = new_array[i -1];
		}
		
		// insert new element in the specified positon
		new_array[index_position] = new_value;
		
		System.out.println("New Array: "+ Arrays.toString(new_array));
	}
}
