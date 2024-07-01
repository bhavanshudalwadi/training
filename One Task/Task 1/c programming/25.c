// LCM

#include <stdio.h>

int main() {
    int n1 = 12, n2 = 25, GCD, LCM;
    for(int i=1; i<=n1 && i<=n2; i++) {
        if(n1%i == 0 && n2%i == 0) {
            GCD = i;
        }
    }
    printf("LCM of %d and %d is %d", n1, n2, (n1*n2)/GCD);
    return 0;
}