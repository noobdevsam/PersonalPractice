#include<stdio.h>

int stack[100], i, j, n, choice = 0, top = -1;

void push();
void pop();
void show();

void main() {
    printf("Enter the size of the stack: ");
    scanf("%d", &n);
    printf("Stack operations using Array: ");
    printf("\n ------------ \n");

    while (choice != 4)
    {
        printf("Chose one from the below options: ");
        printf("\n1.Push\n2.Pop\n3.Show\n4.Exit");
        printf("\nEnter your choice: ");
        scanf("%d", &choice);

        switch (choice)
        {
        case 1:
            push();
            break;
        case 2:
            pop();
            break;
        case 3:
            show();
            break;
        case 4:
            printf("\nExiting----");
            break;
        default:
            printf("\nEnter a valid choice!");
        };
    }
}

void push() {
    int val;
    if (top == val)
    {
        printf("\n Overflow !");
    } else {
        printf("\nEnter the value: ");
        scanf("%d", &val);
        top = top + 1;
        stack[top] = val;
    }
    
}

void pop() {
    if (top == -1)
    {
        printf("\n UnderFlow !");
    } else {
        top = top - 1;
    }
}

void show() {
    for(i = top; i >= 0; i--){
        printf("%d\n", stack[i]);
    }

    if (top == -1)
    {
        printf("\n       hjStack is empty.");
    }
    
}