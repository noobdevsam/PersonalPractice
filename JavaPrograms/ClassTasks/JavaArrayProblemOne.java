package ClassTasks;
public class JavaArrayProblemOne {

	// checks if a element ''item'  exists in array named 'arr'
	public static boolean contains(int[] arr, int item) {
		// iterate through each element 'n'  in the array 'arr'
		for(int n : arr) {
			// checking if 'n' is equal to 'item'
			if (item == n) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] my_array = {1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 5689, 5672, 3591, 2864};
		
		System.out.println(contains(my_array, 2013));
		System.out.println(contains(my_array, 2015));
	}
}
