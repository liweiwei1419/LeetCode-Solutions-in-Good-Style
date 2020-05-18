public class Solution4 {

    // 状态压缩 + 哨兵技巧
    // 空间复杂度：O(N)，N 是矩阵的列数

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        int[] dp = new int[n + 1];

        // 技巧：回避了对边界条件的判断
        dp[1] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j + 1] = 0;
                } else {
                    dp[j + 1] += dp[j];
                }
            }
        }
        return dp[n];
    }
}
