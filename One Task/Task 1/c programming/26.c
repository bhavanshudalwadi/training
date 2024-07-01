// Factorization of the number

#include <stdio.h>

int main() {
    int n = 36;

    printf("Factors of %d are: ", n);
    
    for(int i=1; i<=n; i++) {
        if(n%i == 0) {
            if(i == n) {
                printf("%d", i);
            }else {
                printf("%d, ", i);
            }
        }
    }
    return 0;
}