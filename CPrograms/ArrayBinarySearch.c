#include<stdio.h>

int main() {
	int i, n, a[100], item, beg, end, mid;
	
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
	beg = 0;
    end = (n - 1);
    mid = (beg + end)/2;
	
	while(beg <= end) {
		if(item < a[mid]) {
			end = mid - 1;
		} else if(item == a[mid]) {
			printf("\n%d found at location: %d", item, mid);
			break;
		} else {
			beg = mid + 1;
		}
		
		mid = (beg + end)/2;
	}
	
	if(beg>end) {
		printf("not found");
	}
	
	return 0;
}

