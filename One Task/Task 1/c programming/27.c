// Reverse a String

#include <stdio.h>

int main() {
    int i;
    char str[] = "Bhavanshu";
    for(i=0; str[i]!='\0'; i++);
    for(int j=i-1; j>=0; j--) {
        printf("%c", str[j]);
    }
    return 0;
}