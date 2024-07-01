// Linear Search
#include <stdio.h>

int main() {
    int arr[] = {56,78,45,29,45}, n = 45;

    for(int i=0; i<5; i++) {
        if(arr[i] == n) {
            printf("Search Found at position %d\n", (i+1));
        }
    }
    return 0;
}