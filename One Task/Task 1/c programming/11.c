// Calculate the sum of the digits

#include <stdio.h>

int main() {
    int n = 374658, rem = 0, sum = 0;
    
    int temp = n;
    while(n > 0) {
        rem = n % 10;
        sum += rem;
        n = n / 10;
    }

    printf("Sum of Digits of %d is %d", temp, sum);
    return 0;
}