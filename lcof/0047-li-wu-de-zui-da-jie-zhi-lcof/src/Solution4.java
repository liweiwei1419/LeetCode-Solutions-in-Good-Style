public class Solution4 {

    public int maxValue(int[][] grid) {
        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }

        int cols = grid[0].length;
        if (cols == 0) {
            return 0;
        }

        int[][] dp = new int[rows + 1][cols + 1];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dp[i + 1][j + 1] = grid[i][j] + Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[rows][cols];
    }
}
