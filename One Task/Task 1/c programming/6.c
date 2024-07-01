// Factorial of Number

#include <stdio.h>

int main() {
    int n = 5, fact = 1;

    for(int i=n; i>=1; i--) {
        fact = fact * i;
    }

    printf("Factorial of %d is %d", n, fact);
    return 0;
}