public class Solution2 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        // 先计算第一行和第一列
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        // 再从左到右、从上到下依次计算
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}