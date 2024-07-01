// Count Vowels and Consonants in a String

#include <stdio.h>

int main() {
    int v = 0, c = 0, i;
    char str[] = "Bhavanshu";

    for(i=0; str[i]!='\0'; i++) {
        if(str[i] >= 65 && str[i] <= 90) {
            str[i] = str[i] + 32;
        }
    }

    for(int j=0; j<i; j++) {
        if(str[j] == 'a' || str[j] == 'e' || str[j] == 'i' || str[j] == 'o' || str[j] == 'u') {
            v++;
        }else {
            c++;
        }
    }

    printf("%s contains %d Vowels and %d Consonants", str, v, c);
    return 0;
}