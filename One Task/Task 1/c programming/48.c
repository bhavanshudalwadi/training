// Print Number Pattern

#include <stdio.h>

int main() {
    for(int i=1; i<=5; i++) {
        for(int s=6; s>i; s--) {
            printf(" ");
        }
        for(int j=0; j<i; j++) {
            printf("%2d", i+j);
        }
        printf("\n");
    }
    return 0;
}