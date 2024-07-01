// Check Year is leep

#include <stdio.h>

int main() {
    int year = 2024;
    if(year%4 == 0) {
        printf("%d is leep year :)", year);
    }else {
        printf("%d is not a leep year :)", year);
    }
    return 0;
}