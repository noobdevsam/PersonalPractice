#include<stdio.h>

int main() {
	int i, n, a[100], item, found;
	
	printf("Enter array size: ");
	scanf("%d", &n);
	
	printf("Enter array elements:\n");
	for(i = 0; i < n; i++) {
		scanf("%d", &a[i]);
	}
	
	printf("After traversing: ");
	for(i = 0; i < n; i++) {
		printf("%4d", a[i]);
	}
	
	printf("\nEnter element to search: ");
	scanf("%d", &item);
	found = 0;
	
	for(i = 0; i < n; i++) {
		if(a[i] == item) {
			found = 1;
		}
	}
	
	if(found == 1) {
		printf("found");
	} else {
		printf("not found");
	}
	
	
}

