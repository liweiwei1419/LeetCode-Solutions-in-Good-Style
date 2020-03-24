import java.util.Arrays;


public class Solution2 {

    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int[] dp = new int[n];
        dp[0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j > 0) {
                    dp[j] = grid[0][j] + dp[j - 1];
                } else if (j == 0 && i > 0) {
                    dp[j] = dp[j] + grid[i][0];
                } else if (i != 0 && j != 0) {
                    dp[j] = Integer.min(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
            // System.out.println(Arrays.toString(dp));
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 5}, {3, 2, 1}};
        Solution2 solution = new Solution2();
        int minPathSum = solution.minPathSum(grid);
        System.out.println(minPathSum);
    }
}
