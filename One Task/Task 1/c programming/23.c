// Print ASCII value of a character

#include <stdio.h>

int main() {
    for(char c = 'A'; c<='Z'; c++) {
        printf("%3d ", c);
    }
    printf("\n");
    for(char c = 'a'; c<='z'; c++) {
        printf("%3d ", c);
    }
    return 0;
}