public class Solution {

    // 这个代码是错的，只能返回长度

    public int shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        int[][] dp = new int[m + 1][n + 1];

        // Fill table in bottom up manner
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // Below steps follow above recurrence
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (charArray1[i - 1] == charArray2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
