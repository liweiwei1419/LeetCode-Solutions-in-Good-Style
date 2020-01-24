import java.util.Arrays;

public class Solution {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);

        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        // 输入: m = 7, n = 3
        // 输出: 28
        Solution solution = new Solution();
        int m = 7;
        int n = 3;
        int uniquePaths = solution.uniquePaths(m, n);
        System.out.println(uniquePaths);
    }
}
