// Find GCD and LCM

#include <stdio.h>

int gcd(int a, int b) {
    if (b == 0) {
        return a;
    }
    return gcd(b, a % b);
}

int findLCM(int arr[], int n) {
    int lcm = arr[0];
    for (int i = 1; i < n; i++) {
        lcm = (lcm * arr[i]) / gcd(lcm, arr[i]);
    }
    return lcm;
}

int findGCD(int arr[], int n) {
    int mul = 1;
    for(int i=0; i<n; i++) {
        mul *= arr[i];
    }
    return mul/findLCM(arr, n);
}

int main() {
    int arr[] = {36, 60};
    printf("LCD: %d", findLCM(arr, 2));
    printf("\nGCD: %d", findGCD(arr, 2));
    return 0;
}