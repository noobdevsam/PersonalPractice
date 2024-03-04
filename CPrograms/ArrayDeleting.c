#include<stdio.h>

int main() {
    int k,n,a[100],p;//variable declaration

    printf("\nEnter the range of array: ");
    scanf("%d", &n);

    printf("Enter the elements:\n");
    for(k = 0; k < n; k++) { //taking continuous input
        scanf("%d", &a[k]);//putting one element at a time
    }

    printf("After traversing:\n");
    for(k = 0; k < n; k++) {
        printf("%4d", a[k]);//geting one element at a time
    }
    
    printf("\nEnter the position to delete: ");
    scanf("%d", &p);

    if( (p<0) || (p>n) ) {
        // if the selected position number is greater than the array size
        printf("Delete impossible\n");
    } else {
        for(k=(p+1); k<n; k++) {
            a[k-1] = a[k];
        }
        n--;

        printf("After deleting:\n");
        for(k = 0; k < n; k++) {
            printf("%4d", a[k]);//geting one element at a time
        }
    }
}