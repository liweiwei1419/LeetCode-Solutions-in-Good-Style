public class Solution2 {

    // 状态压缩

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        // 默认都是 0
        int[] dp = new int[n];
        // 这一句很关键，题目当中说了，网格中间有障碍物，所以初值可以这样设置
        // 审题很关键
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        // System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        Solution2 solution2 = new Solution2();
        int uniquePathsWithObstacles = solution2.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(uniquePathsWithObstacles);
    }
}
