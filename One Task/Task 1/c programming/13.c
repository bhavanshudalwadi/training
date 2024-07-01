// Binary to Decimal

#include <stdio.h>
#include <math.h>

int main() {
    int n = 10001, rem = 0, arr[4], i = 0, j, dec = 0;

    while(n > 0) {
        rem = n % 10;
        dec += rem * pow(2,i);
        n = n / 10;
        i++;
    }

    printf("%d", dec);
    return 0;
}

// 1 * 2^0 + 1 * 2^1 + 0 * 2^2 + 1 * 2^3
// 1 + 2 + 0 + 8