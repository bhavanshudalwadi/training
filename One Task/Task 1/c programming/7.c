// Fibonacci Series

#include <stdio.h>

int main() {
    int a = 0, b = 1, c = 0, n = 5;

    printf("Fibonacci Series: ");
    if(n == 1) {
        printf("%d", a);
    }else if (n == 2) {
        printf("%d, %d", a, b);
    }else if (n > 2) {
        printf("%d, %d", a, b);
        for(int i=1; i<=n-2; i++) {
            c = a + b;
            printf(", %d", c);
            b = a;
            a = c;
        }
    }
    return 0;
}