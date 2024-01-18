import java.util.Scanner;

public class App{
    public static void main(String[] args) {
		check_for_prime_number();
    }

	private static void check_for_prime_number() {
		/* A prime number is a number that is divisible by only two numbers: 		1 and itself.
        So, if any number is divisible by any other number, it is not a prime number.
        */
        System.out.print("Input a integer number: ");
        try (Scanner sc = new Scanner(System.in)) {

			int num = sc.nextInt();
			boolean flag = false;

			for(int i = 2; i <= num / 2; ++i) {
			    // condition for non-prime number
			    if(num % i == 0) {
			        flag = true;
			        break;
			    }
			}

			if(!flag) {
			    System.out.println("a prime number.");
			} else {
			    System.out.println("a non-prime number.");
			}
		}
	}
}
