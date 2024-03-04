#include<stdio.h>

int main() {
	int i,j,row,column, a[10][10];
	printf("Enter the size of row: ");
	scanf("%d", &row);
	printf("Enter the size of column: ");
	scanf("%d", &column);
	
	printf("Enter the elements:\n");
	for(i = 0; i<row; i++) {
		for(j = 0; j<column;j++) {
			scanf("%d", &a[i][j]);
		}
	}
	
	printf("\nTraversing 2D array:\n");
	for(i = 0; i<row; i++) {
		for(j = 0; j<column;j++) {
			printf("%4d", a[i][j]);
		}
		printf("\n");
	}
}
