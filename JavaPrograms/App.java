import java.util.Scanner;

public class App {

	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("-----Check Prime Number-----");
		check_for_prime_number();
		System.out.println("-----End-----");
		System.out.println("-----Print half pyramid with symbol-----");
		print_half_pyramid_with_symbol();
		System.out.println("-----End-----");
		System.out.println("-----Check even/odd-----");
		check_even_or_odd();
		System.out.println("-----End-----");
		sc.close();
	}

	private static void check_even_or_odd() {
		System.out.print("Input a integer number: ");
		int num = sc.nextInt();
		String rs = (num % 2 == 0) ? "even number" : "odd number";
		System.out.println("The given number " + num + " is: " + rs);
	}

	private static void check_for_prime_number() {
		/*
		 * A prime number is a number that is divisible by only two numbers: 1 and
		 * itself.
		 * So, if any number is divisible by any other number, it is not a prime number.
		 */
		System.out.print("Input a integer number: ");
		int num = sc.nextInt();
		boolean flag = false;

		for (int i = 2; i <= num / 2; ++i) {
			// condition for non-prime number
			if (num % i == 0) {
				flag = true;
				break;
			}
		}

		if (!flag) {
			System.out.println("a prime number.");
		} else {
			System.out.println("a non-prime number.");
		}
	}

	private static void print_half_pyramid_with_symbol() {
		System.out.print("Input the number of rows: ");
		int rows = sc.nextInt();

		for (int i = 1; i <= rows; ++i) {
			for (int j = 1; j <= i; ++j) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
}
