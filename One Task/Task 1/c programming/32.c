// Count Words in a Sentence

#include <stdio.h>

int main() {
    char str[] = "bhavanshu dalwadi is good programmer.";
    int c = 0;
    for(int i=0; str[i]!='\0'; i++) {
        if(str[i] == 32) {
            c++;
        }
    }
    printf("\"%s\" contains %d words", str, (c+1));
    return 0;
}