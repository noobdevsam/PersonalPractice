#include<stdio.h>

void qsort(int a[25], int first, int last)
{
    int i,j, pivot, temp;

    if (first< last)
    {
        pivot = first;
        i = first;
        j = last;

        while (i < j)
        {
            while (a[i] <= a[pivot] && i < last)
            {
                i++;
            }

            while (a[j] > a[pivot])
            {
                j--;
            }
            
            if (i < j)
            {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        temp = a[pivot];
        a[pivot] = a[j];
        a[j] = temp;

        //call the function two times
        qsort(a, first, j-1);
        qsort(a, j+1, last);
    }
}

int main()
{
    int i, n, a[25];
    printf("\n Enter the range of array: ");
    scanf("%d", &n);

    printf("Enter the elements of the array: ");
    for (i = 0; i < n; i++) 
    {
        scanf("%d", &a[i]);
    }

    qsort(a, 0, n-1);

    printf("After sorting: ");
    for (i = 0; i < n; i++)
    {
        printf("%d \n", a[i]);
    }

    return 0;
}