package dsaPrograms.AllLongestCommonSubsequences;

import java.util.HashSet;
import java.util.Set;

public class AllLongestCommonSubsequences {

    public static void main(String[] args) {
        String str1 = "abcabcaa";
        String str2 = "acbacba";

        Set<String> longestCommonSubsequences = findLongestCommonSubsequences(str1, str2);

        System.out.println("Longest Common Subsequences:");
        for (String lcs : longestCommonSubsequences) {
            System.out.println(lcs);
        }
    }

    private static Set<String> findLongestCommonSubsequences(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int longestLength = dp[m][n];
        Set<String> result = new HashSet<>();

        backtrack(str1, str2, m, n, dp, new StringBuilder(), longestLength, result);

        return result;
    }

    private static void backtrack(String str1, String str2, int i, int j, int[][] dp,
                                  StringBuilder currentLCS, int longestLength, Set<String> result) {
        if (i == 0 || j == 0) {
            result.add(currentLCS.reverse().toString());
            return;
        }

        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            // Characters match, include them in the current LCS
            currentLCS.append(str1.charAt(i - 1));
            backtrack(str1, str2, i - 1, j - 1, dp, currentLCS, longestLength - 1, result);
            currentLCS.deleteCharAt(currentLCS.length() - 1);
        } else {
            // Characters don't match, explore both directions
            if (dp[i - 1][j] >= dp[i][j - 1]) {
                backtrack(str1, str2, i - 1, j, dp, currentLCS, longestLength, result);
            }

            if (dp[i][j - 1] >= dp[i - 1][j]) {
                backtrack(str1, str2, i, j - 1, dp, currentLCS, longestLength, result);
            }
        }
    }
}
