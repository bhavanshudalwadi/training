// Basic Memory Allocation and Deallocation

#include <stdio.h>
#include <stdlib.h>

int main() {

    // Block of 5 ints
    int *p1 = (int *) malloc(5 * sizeof(int));

    // 5 Blocks of 4 bytes
    int *p2 = (int *) calloc(5, sizeof(int));

    for(int i=1; i<=5; i++) {
        p1[i-1] = i;
        p2[i-1] = i;
    }

    for(int i=0; i<5; i++) {
        printf("%d, ", p1[i]);
    }
    printf("\n");
    for(int i=0; i<5; i++) {
        printf("%d, ", p2[i]);
    }

    free(p1);
    free(p2);

    return 0;
}