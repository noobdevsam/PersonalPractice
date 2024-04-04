package arrays;

// program to find second smallest element
public class ArrayFifteen {
    public static void main(String[] args) {
        int[] arr = {23,43,52,521,754,453,21,90,43,64,22,75,20,14};

        int firstSmallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for(int num: arr) {
            if(num < firstSmallest) {
                secondSmallest = firstSmallest; // update: hold previous small value
                firstSmallest = num; // set new first small value
            } else if ((num < secondSmallest) && (num != firstSmallest)) {
                secondSmallest = num;
            }
        }

        if (secondSmallest == Integer.MAX_VALUE) {
            System.out.println("Array has less than two distinct elements");
        } else {
            System.out.println("Second smallest element is: " + secondSmallest);
        }
    }
    
}
