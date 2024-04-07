package arrays;

// find majority elements in a array
// A majority element is an element that appears more than n/2 times where n is the array size.
// Moore's Voting Algorithm
public class ArrayTwntyFive {
    public static void main(String[] args) {
        int[] arr = {2,2,3,5,2,2,6};
        
        int majority = findMajorityElement(arr);

        if (majority != -1) {
            System.out.println("Majority element: " + majority);
        } else {
            System.out.println("No mojority element");
        }
    }

    private static int findMajorityElement(int[] arr) {
        int count = 0, candidate = 0;
        /*
         * `count` keeps track of the current number of ocurrences we've seen for a particular element.
        - `candidate` is used to store the current potential majority element.
         */

        for (int num : arr) {
            if (count == 0) {
                candidate = num;
            }
            count += ((num == candidate) ? 1: -1);
        }

        // check if the candidate is actually the majority element
        count = 0; // again
        for (int i : arr) {
            if(i == candidate) {
                count ++;
            }
        }

        return (count > arr.length/2) ? candidate : -1;
    }
}


/*
 * **Candidate Selection:**
   - If `count` is 0, it means we haven't encountered a majority element candidate yet. In this case, we set the current element (`num`) as the `candidate`.
   - Otherwise:
     - If the current element (`num`) is the same as the current `candidate`, we increment `count`. This signifies that we've encountered another occurrence of the potential majority element.
     - If the current element (`num`) is different from the `candidate`, we decrement `count`. This indicates that the previous candidate might not be the majority element after all.

 **Intuition behind the logic:**

   The key idea is that if a majority element exists, its count will eventually become positive and stay positive throughout the remaining iterations. Why? Because for every element that's not the majority element, its occurrences will be countered by occurrences of the actual majority element.

 **Verifying the candidate:**

   After iterating through the entire array, we need to verify if the chosen `candidate` is indeed the majority element. This is because the process might have cancelled out occurrences of the actual majority element with non-majority elements.

   - We initialize `count` back to 0 and iterate through the array again.
   - We only increment `count` if the current element is the `candidate`.
   - If `count` becomes greater than half the array length (`arr.length / 2`) at any point, it confirms that the `candidate` is indeed the majority element and returns it.

 **No majority element:**

   - If the entire second loop finishes without `count` exceeding half the array length, it means no element appears more than half the times. The function returns `-1` to indicate this.

    **Benefits:**

        - Efficient time complexity of O(n).
        - Uses constant extra space.
        - Works well when there is a clear majority element.

    **Drawbacks:**

        - Might not work if there's no majority element (the algorithm assumes one exists). 
 */