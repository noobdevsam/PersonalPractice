package ClassTasks;
public class JavaArrayProblemTwo {
	// getting the sum of all elements in a array
	public static void main(String[] args) {
		int[] my_array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int sum = 0;
		
		for(int n : my_array) {
			sum += n;
		}
		
		System.out.println("The sum is: " + sum);
	}
}
