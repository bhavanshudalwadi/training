// Matrix Subtraction

#include <stdio.h>

int main() {

    int m1[3][3] = {
        {1, 2, 2},
        {3, 0, 4},
        {4, 1, 2}
    };

    int m2[3][3] = {
        {3, 4, 1},
        {4, 2, 2},
        {3, 2, 1}
    };

    int ans[3][3];

    for(int i=0; i<3; i++) {
        for(int j=0; j<3; j++) {
            ans[i][j] = m1[i][j] - m2[i][j];
            printf("%2d ", ans[i][j]);
        }
        printf("\n");
    }

    return 0;
}