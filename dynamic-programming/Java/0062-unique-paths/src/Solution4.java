public class Solution4 {

    // 记忆化递归：使用缓存数组

    private int[][] memo;

    public int uniquePaths(int m, int n) {
        // 递归终止条件
        if (m < 1 || n < 1) {
            return 0;
        }

        // 递归收敛条件
        if (m == 1 && n == 1) {
            return 1;
        }
        memo = new int[m][n];
        memo[0][0] = 1;
        return dfs(m - 1, n - 1);
    }

    private int dfs(int m, int n) {
        // 数据非法，终止条件
        if (m < 0 || n < 0) {
            return 0;
        }
        // 收敛条件，回到起点
        if (m == 0 && n == 0) {
            return memo[0][0];
        }
        if (memo[m][n] > 0) {
            return memo[m][n];
        } else {
            return memo[m][n] = dfs(m - 1, n) + dfs(m, n - 1);
        }
    }
}
