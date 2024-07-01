// GCD

#include <stdio.h>

int main() {
    int n1 = 36, n2 = 60, GCD;
    for(int i=1; i<=n1 && i<=n2; i++) {
        if(n1%i == 0 && n2%i == 0) {
            GCD = i;
        }
    }
    printf("GCD of %d and %d is %d", n1, n2, GCD);
    return 0;
}