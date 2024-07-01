// Matrix Multiplication

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
            ans[i][j] = 0;
            for(int k=0; k<3; k++) {
                ans[i][j] += m1[i][k] * m2[k][j];
            }
            printf("%2d ", ans[i][j]);
        }
        printf("\n");
    }

    return 0;
}