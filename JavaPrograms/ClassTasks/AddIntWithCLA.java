package ClassTasks;
public class AddIntWithCLA {
	public static void main(String[] args) {
		int var1, var2, add;
		var1 = Integer.parseInt(args[0]);
		var2 = Integer.parseInt(args[1]);
		add = var1 + var2;
		System.out.println("Sum of two integer: " + args[0] + " + " + args[1] + " = "+ add);
	}
}

// Compile: javac AddIntWithCLA.java
// Run: java AddIntWithCLA 63 83
