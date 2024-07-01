// Check Given Number Is Palindrome or Not

#include <stdio.h>

int main() {
    int n = 121, rem = 0, rev = 0;

    int temp = n;

    while(n > 0) {
        rem = n % 10;
        rev = (rev * 10) + rem;
        n = n / 10;
    }
    
    if(temp == rev) {
        printf("%d is Palindrome Number", temp);
    }else {
        printf("%d is Not a Palindrome Number", temp);
    }
    return 0;
}