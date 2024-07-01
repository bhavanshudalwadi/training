// String Length Calculation

#include <stdio.h>
#include <string.h>

int main() {
    char str[] = "Bhavanshu";
    int i;
    // int len = strlen(str);
    for(i=0; str[i]!='\0'; i++);
    printf("%s string length is %d", str, i);
    return 0;
}