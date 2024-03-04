#include<stdio.h>

int main() {
    int i, n, a[100], pass, comp, temp;
    
    printf("Enter the range of array: ");
    scanf("%d", &n);

    printf("Enter the elements:\n");
    for(i = 0; i < n; i++) {
        scanf("%d", &a[i]);
    }

    printf("After traversing:\n");
    for(i = 0; i < n; i++) {
        printf("%4d", a[i]);
    }

    for(pass = n-1; pass>0; pass--) {
        for(comp = 0; comp < pass; comp++) {
            if(a[comp] > a[comp+1]) {
                temp = a[comp];
                a[comp] = a[comp+1];
                a[comp+1] = temp;
            }
        }
    }

    printf("\nAfter sorting:\n");
    for(i = 0; i<n; i++) {
        printf("%4d", a[i]);
    }
}