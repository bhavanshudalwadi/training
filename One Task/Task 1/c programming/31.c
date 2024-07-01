// Check for Anagrams

#include <stdio.h>
#include <string.h>

int main() {
    char str1[] = "bhavanshu", str2[] = "abvhahnus", temp;
    int i, j;
    if(strlen(str1) == strlen(str2)) {
        for(i=0; str1[i]!='\0'; i++) {
            for(j=1; str1[j]!='\0'; j++) {
                if(str1[j] > str1[i]) {
                    temp = str1[i];
                    str1[i] = str1[j];
                    str1[j] = temp;
                }
                if(str2[j] > str2[i]) {
                    temp = str2[i];
                    str2[i] = str2[j];
                    str2[j] = temp;
                }
            }
        }
        if(strcmp(str1, str2) == 0) {
            printf("Strings are anagrams");
        }else {
            printf("Strings are not anagrams");
        }
    }else {
        printf("Strings are not anagrams");
    }
    return 0;
}