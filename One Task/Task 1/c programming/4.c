// Find The Largest Number Among The Three Number

#include <stdio.h>

int main() {
    int a = 5, b = 10, c = 15;

    if(a > b) {
        if(a > c) {
            printf("%d is Largest Number", a);
        }else {
            printf("%d is Largest Number", c);
        }
    }else {
        if(b > c) {
            printf("%d is Largest Number", b);
        }else {
            printf("%d is Largest Number", c);
        }
    }
    return 0;
}