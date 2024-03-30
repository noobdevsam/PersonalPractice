package ClassTasks;
public class JavaArrayProblemFive {
	// find the largest element of an array
	public static void main(String[] args) {
		double[] arr = {45.4, -23.70, 25.65, 85.98, -99.67};
		double largest = arr[0];

		for(double num : arr) {
			if(largest < num) {
				largest = num;
			}
		}

		System.out.format("Largest element: %.2f",largest);
	}
}
