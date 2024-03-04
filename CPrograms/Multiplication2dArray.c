#include<stdio.h>

int main() {
	int i,j,row1,clm1, a[10][10],row2, clm2, b[10][10], s[10][10];
	printf("Size of row for square Matrix1: ");
	scanf("%d", &row1);
	printf("Size of column for square Matrix1: ");
	scanf("%d", &clm1);
	
	printf("Enter elements: ");
	for(i = 0; i<row1; i++) {
		for(j = 0; j<clm1;j++) {
			scanf("%d", &a[i][j]);
		}
	}
	
	printf("\nOutput: Matrix1:\n");
	for(i = 0; i<row1; i++) {
		for(j = 0; j<clm1;j++) {
			printf("%4d", a[i][j]);
		}
		printf("\n");
	}
	
	printf("Size of row for square Matrix2: ");
	scanf("%d", &row2);
	printf("Size of column for square Matrix2: ");
	scanf("%d", &clm2);
	
	printf("Enter elements: ");
	for(i = 0; i<row2; i++) {
		for(j = 0; j<clm2;j++) {
			scanf("%d", &b[i][j]);
		}
	}
	
	printf("\nOutput: Matrix2:\n");
	for(i = 0; i<row2; i++) {
		for(j = 0; j<clm2;j++) {
			printf("%4d", b[i][j]);
		}
		printf("\n");
	}
	
	if(clm1==row2) {
		for(i = 0; i<row1; i++) {
			for(j = 0; j<clm1;j++) {
				s[i][j] = a[i][j] * b[i][j];
			}
		}
		
		printf("\nOutput: Multiplication\n");
		for(i = 0; i<row1; i++) {
			for(j = 0; j<clm1;j++) {
				printf("%4d", s[i][j]);
			}
			printf("\n");
		}
	} else {
		printf("Impossible");
	}
}
