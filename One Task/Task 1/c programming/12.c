// Decimal to Binary Conversion

#include <stdio.h>

int main() {
    int n, rem = 0, i = 0;

    printf("Enter N: ");
    scanf("%d", &n);

    int arr[n], temp = n;

    while(n > 0) {
        rem = n % 2;
        arr[i] = rem;
        n = n / 2;
        i++;
    }

    printf("Binary of %d is: ", temp);
    for(i=i-1; i>=0; i--) {
        printf("%d", arr[i]);
    }
    return 0;
}


// 2 | 234 | 1
// 2 | 123 | 0
// .
// .
// .