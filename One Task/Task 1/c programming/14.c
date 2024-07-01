// Basic Calculator

#include <stdio.h>

double add(double, double);
double min(double, double);
double mul(double, double);
double div(double, double);

int main() {
    double a, b, c = 0;
    int o;
    char ch;

    printf("Enter First Number: ");
    scanf("%lf", &c);

    printf("1. Addition\n");
    printf("2. Minus\n");
    printf("3. Multiplication\n");
    printf("4. Division\n");

    do {
        printf("Select Operation: ");
        scanf("%d", &o);

        printf("Enter Another Number: ");
        scanf("%lf", &b);

        switch(o) {
            case 1: c = add(c, b);
                    printf("%lf", c);
                    break;
            case 2: c = min(c, b);
                    printf("%lf", c);
                    break;
            case 3: c = mul(c, b);
                    printf("%lf", c);
                    break;
            case 4: c = div(c, b);
                    printf("%lf", c);
                    break;
            default: printf("Please Try Again...");
        }

        printf("\nDo you want to continue? y/n: ");
        scanf("%s", &ch);
    } while(ch == 'y');

    return 0;
}

double add(double a, double b) {
    return a + b;
}

double min(double a, double b) {
    return a - b;
}

double mul(double a, double b) {
    return a * b;
}

double div(double a, double b) {
    if(b != 0) {
        return a / b;
    }else {
        printf("%d is invalid", b);
    }
}