#include<stdio.h>

int main() {
    int k,n,a[100];//variable declaration

    printf("\nEnter the range of array: ");
    scanf("%d", &n);

    printf("Enter the elements:\n");
    for(k = 1; k <= n; k++) { //taking continuous input
        scanf("%d", &a[k]);//putting one element at a time
    }

    printf("After traversing:\n");
    for(k = 1; k <= n; k++) {
        printf("%4d", a[k]);//geting one element at a time
    }
    
}