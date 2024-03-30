package classtasks;
public class MultiplyInOopManner {
	private int var1,var2;
	
	MultiplyInOopManner() {
		var1 = var2 = 0;
	}
	
	MultiplyInOopManner(int var1, int var2) {
		this.var1 = var1;
		this.var2 = var2;
	}
	
	void putVar1(int var1) {
		this.var1 = var1;
	}
	
	void putVar2(int var2) {
		this.var2 = var2;
	}
	
	int getMultiplication() {
		return var1*var2;
	}
	
	public static void main(String[] args) {
		MultiplyInOopManner obj = new MultiplyInOopManner();
		obj.putVar1(10);
		obj.putVar2(20);
		System.out.println("First obj returned : " + obj.getMultiplication() );
		
		MultiplyInOopManner obj2 = new MultiplyInOopManner(20, 30);
		System.out.println("Second obj returned : " + obj2.getMultiplication() );
	}
}