// Print Hollow Pyramid

#include <stdio.h>

int main() {
    int n = 11;
    for(int i=0; i<=n; i++) {
        for(int s=n; s>=i; s--) {
            printf(" ");
        }
        for(int j=0; j<=i; j++) {
            if(j==0 || i==n) {
                printf("*");
            }else {
                printf(" ");
            }
        }
        for(int j=1; j<=i; j++) {
            if(j==i || i==n) {
                printf("*");
            }else {
                printf(" ");
            }
        }
        printf("\n");
    }
    return 0;
}