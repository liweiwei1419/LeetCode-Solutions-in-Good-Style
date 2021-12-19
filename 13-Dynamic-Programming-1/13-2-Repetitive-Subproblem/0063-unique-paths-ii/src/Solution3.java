public class Solution3 {

    // 空间优化 + 哨兵技巧
    // 空间复杂度：O(N)，N 是矩阵的列数

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        if (rows == 0) {
            return 0;
        }
        int cols = obstacleGrid[0].length;
        int[] dp = new int[cols + 1];
        // 技巧：回避了对边界条件的判断
        dp[1] = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j + 1] = 0;
                } else {
                    dp[j + 1] += dp[j];
                }
            }
        }
        return dp[cols];
    }
}