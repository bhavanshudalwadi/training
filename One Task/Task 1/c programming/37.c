// Binary Search
#include <stdio.h>

void binarySearch(int arr[], int l, int r, int x, int n);

int main() {
    int arr[] = {12, 23, 45, 67, 78};

    binarySearch(arr, 0, 4, 67, 5);

    return 0;
}

void binarySearch(int arr[], int l, int r, int x, int n) {
    int mid = (l + r)/2;
    if(l <= r) {
        if(arr[mid] == x) {
            printf("%d found at position %d", x, mid+1);
        }else if(x > arr[mid]) {
            binarySearch(arr, mid + 1, r, x, n-1);
        }else if(x < arr[mid]) {
            binarySearch(arr, l, mid - 1, x, n-1);
        }
    }else {
        printf("%d found at position %d", x, mid+1);
    }
}
