public class JavaArrayProblemFour {
	// addition of two matrix
	public static void main(String[] args) {
		final int row =3, column = 3;
		int[][] first_matrix = {
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		int[][] second_matrix = {
			{9,8,7},
			{6,5,4},
			{3,2,1}
		};
		int[][] sum = new int[row][column];

		//addition
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < column; j++) {
				sum[i][j] = first_matrix[i][j] + second_matrix[i][j];
			}
		}

		//printing out sum matrix
		System.out.println("Sum: ");
		for(int[] rw : sum) {
			for(int clm : rw) {
				System.out.print(clm+ " ");
			}
			System.out.println();
		}
	}
}
