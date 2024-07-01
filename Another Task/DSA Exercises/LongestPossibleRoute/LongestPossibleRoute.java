package dsaPrograms.LongestPossibleRoute;

public class LongestPossibleRoute {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1}
        };

        int longestRoute = findLongestRoute(matrix);
        System.out.println("Longest possible route length: " + longestRoute);
    }

    private static int findLongestRoute(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];

        dp[0][0] = (matrix[0][0] == 1) ? 1 : 0;

        for (int j = 1; j < cols; j++) {
            dp[0][j] = (matrix[0][j] == 1) ? dp[0][j - 1] + 1 : 0;
        }

        for (int i = 1; i < rows; i++) {
            dp[i][0] = (matrix[i][0] == 1) ? dp[i - 1][0] + 1 : 0;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[rows - 1][cols - 1];
    }
}

