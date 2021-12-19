public class Solution {

    public int maxProductPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        long[][][] dp = new long[rows + 1][cols + 1][2];

        // 这里要声明成 long 类型
        long mod = 1000000007;
        // 初始化
        // 最小值
        dp[0][0][0] = grid[0][0];
        // 最大值
        dp[0][0][1] = grid[0][0];
        for (int j = 1; j < cols; j++) {
            dp[0][j][0] = dp[0][j - 1][0] * grid[0][j];
            dp[0][j][1] = dp[0][j - 1][0] * grid[0][j];
        }
        for (int i = 1; i < rows; i++) {
            dp[i][0][0] = dp[i - 1][0][0] * grid[i][0];
            dp[i][0][1] = dp[i - 1][0][0] * grid[i][0];
        }

        // 递推开始
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (grid[i][j] >= 0) {
                    dp[i][j][0] = Math.min(grid[i][j] * dp[i - 1][j][0], grid[i][j] * dp[i][j - 1][0]);
                    dp[i][j][1] = Math.max(grid[i][j] * dp[i - 1][j][1], grid[i][j] * dp[i][j - 1][1]);
                } else {
                    dp[i][j][0] = Math.min(grid[i][j] * dp[i - 1][j][1], grid[i][j] * dp[i][j - 1][1]);
                    dp[i][j][1] = Math.max(grid[i][j] * dp[i - 1][j][0], grid[i][j] * dp[i][j - 1][0]);
                }
            }
        }
        if (dp[rows - 1][cols - 1][1] < 0) {
            return -1;
        }
        return (int) (dp[rows - 1][cols - 1][1] % mod);
    }
}