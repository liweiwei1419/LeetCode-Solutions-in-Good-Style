import java.util.Arrays;

public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;

        // 默认都是 0
        int[][] dp = new int[m][n];

        // 先写第 0 行
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }
        // 再写第 0 列
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }
        // printArr(dp);
        return dp[m - 1][n - 1];
    }

    private void printArr(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }

    /**
     * [
     * [0,0,0],
     * [0,1,0],
     * [0,0,0]
     * ]
     *
     * @param args
     */
    public static void main(String[] args) {
        // write your code here
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        Solution solution = new Solution();
        int uniquePathsWithObstacles = solution.uniquePathsWithObstacles(obstacleGrid);
        System.out.println(uniquePathsWithObstacles);
    }
}
