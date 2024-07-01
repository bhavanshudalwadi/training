// Number is Prime or Not

#include <stdio.h>

int main() {
    int n = 9, flag = 0;

    for(int i=2; i<n; i++) {
        if(n%i == 0) {
            flag = 1;
            break;
        }
    }

    if(flag == 1) {
        printf("%d is Not a Prime Number", n);
    }else {
        printf("%d is Prime Number", n);
    }
}