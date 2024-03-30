package ClassTasks;
import java.util.Scanner;

public class AddIntWithScanner {
	public static void main(String[] args) {
		int var1, var2, add;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter two integers: ");
		var1 = sc.nextInt();
		var2 = sc.nextInt();
		sc.close();
		add = var1 + var2;
		System.out.println("Sum of two integer: : " + add);
	}
}