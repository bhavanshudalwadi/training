// Armstrong Number Check

#include <stdio.h>
#include <math.h>

int main() {
    int n = 1634, i = 0, sum = 0, rem = 0;
    int temp = n, n2 = n;
    while(n > 0) {
        n /= 10;
        i++;
    }
    while(n2 > 0) {
        rem = n2 % 10;
        sum += pow(rem, i);
        n2 /= 10;
    }
    printf("%d", sum);

    if(temp == sum) {
        printf("%d is Armstrong Number", temp);
    }else {
        printf("%d is Not a Armstrong Number", temp);
    }
    return 0;
}