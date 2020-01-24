import java.util.Arrays;

public class Solution2 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        // 初始化的时候 dp[0][1] = 1; 或者 dp[1][0] = 1; 均可
        dp[1][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        // 输入: m = 7, n = 3
        // 输出: 28
        Solution2 solution = new Solution2();
        int m = 7;
        int n = 3;
        int uniquePaths = solution.uniquePaths(m, n);
        System.out.println(uniquePaths);
    }
}
