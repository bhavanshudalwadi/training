// Perfect Number Check

#include <stdio.h>

int main() {
    int n = 6, sum = 0;
    if(n > 1) {
        for(int i = 1; i<n; i++) {
            if(n%i == 0) {
                sum += i;
            }
        }
        if(sum == n) {
            printf("%d is perfect number", n);
        }else {
            printf("%d is not a perfect number", n);
        }
    }else {
        printf("%d is not a perfect number", n);
    }
    return 0;
}