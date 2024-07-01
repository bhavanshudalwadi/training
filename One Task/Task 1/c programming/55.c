//  Check for a Magic Square

#include <stdio.h>

int isMagicSquare(int mat[3][3])
{
    int sumd1 = 0, sumd2 = 0;

    for (int i = 0, j = 2; i < 3; i++, j--) {
        sumd1 += mat[i][i];
        sumd2 += mat[i][j];
    }

    if(sumd1 != sumd2)
        return 0;

    for (int i = 0; i < 3; i++) {
        int rowSum = 0, colSum = 0;

        for (int j = 0; j < 3; j++) {
            rowSum += mat[i][j];
            colSum += mat[j][i];
        }

        if (rowSum != colSum || colSum != sumd1)
            return 0;
    }

    return 1;
}

int main()
{
	int mat[3][3] = {{ 2, 7, 6 },
					{ 9, 5, 1 },
					{ 4, 3, 8 }};
	
	if (isMagicSquare(mat) == 1)
		printf("Magic Square");
	else
		printf("Not a magic Square");
	
	return 0;
}
