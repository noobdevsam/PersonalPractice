import java.util.Scanner;

public class MultiplyIntWithScanner {
	public static void main(String[] args) {
		int var1, var2, product;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter two integers: ");
		var1 = sc.nextInt();
		var2 = sc.nextInt();
		sc.close();
		product = var1 * var2;
		System.out.println("Product of two integer: : " + product);
	}
}