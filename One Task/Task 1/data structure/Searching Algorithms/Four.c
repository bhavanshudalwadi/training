// Linear Search
#include <stdio.h>

int main() {
    int arr[] = {6, 7, 8, 1, 2, 3, 4, 5}, n = 45;

    for(int i=0; i<5; i++) {
        if(arr[i] == n) {
            printf("Search Found at position %d\n", (i+1));
        }
    }
    return 0;
}