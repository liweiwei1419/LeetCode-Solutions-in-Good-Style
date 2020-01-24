public class Solution2 {

    // 同 Solution

    // i,j 的值来源：上面和前面的值之和

    // 空间可以再省

    public int uniquePaths(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[0][j] = 1;
                } else if (j == 0) {
                    dp[i][0] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        // 输入: m = 7, n = 3
        // 输出: 28
        Solution2 solution2 = new Solution2();
        int m = 7;
        int n = 3;
        int uniquePaths = solution2.uniquePaths(m, n);
        System.out.println(uniquePaths);
    }
}
