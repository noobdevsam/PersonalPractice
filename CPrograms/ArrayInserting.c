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
    
    printf("\nEnter the position to insert: ");
    scanf("%d", &p);

    if( (p<0) || (p>n) ) {
        // if the selected position number is greater than the array size
        printf("Insert impossible");
    } else {
        for(k=(n - 1); k>=p; k--) {
            a[k+1] = a[k];
        }
        printf("Enter the element to insert: ");
        scanf("%d", &a[p]);
        n++;
    }

    printf("After inserting:\n");
    for(k = 0; k < n; k++) {
        printf("%4d", a[k]);//geting one element at a time
    }
}