// Transpose  of a Matrix

#include <stdio.h>

int main() {

    int m[3][3] = {
        {1, 2, 2},
        {3, 0, 4},
        {4, 1, 2}
    };
    
    int ans[3][3];

    for(int i=0; i<3; i++) {
        for(int j=0; j<3; j++) {
            ans[i][j] = m[j][i];
            printf("%2d ", ans[i][j]);
        }
        printf("\n");
    }

    return 0;
}