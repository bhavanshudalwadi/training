// Matrix Diagonal Sum

#include <stdio.h>

void printDiagonalSums(int mat[3][3]) {
	int principal = 0, secondary = 0;
	for (int i = 0; i < 3; i++) 
	{
		for (int j = 0, k = 2; j < 3; j++, k--) 
		{
			if (i == j)
				principal += mat[i][j];

			if (i == k)
				secondary += mat[i][k];
		}
	}

	printf("%s", "Principal Diagonal: ");
	printf("%d\n", principal);
	printf("%s", "Secondary Diagonal: ");
	printf("%d\n", secondary);
}

int main()
{
	int a[3][3]={
					{1, 2, 3}, 
					{5, 6, 7}, 
					{1, 2, 3}
				};
	printDiagonalSums(a);
	return 0;
}
