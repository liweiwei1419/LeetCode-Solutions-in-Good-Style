import java.util.Arrays;

public class Solution5 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[2][n];
        // 第 1 行全填 1
        Arrays.fill(dp[0], 1);
        // 第 2 行第 1 个别忘了也填上 1
        dp[1][0] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i % 2][j] = dp[(i - 1) % 2][j] + dp[i % 2][j - 1];
            }
        }
        return dp[(m - 1) % 2][n - 1];
    }
}