public class Solution {

    // 方法一：记忆化递归

    private int[][] memo;

    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) {
            return 1;
        }
        memo = new int[m][n];
        memo[0][0] = 1;
        return dfs(m - 1, n - 1);
    }

    private int dfs(int m, int n) {
        // m = 0 和 n = 0 都有特殊含义
        if (m < 0 || n < 0) {
            return 0;
        }
        if (memo[m][n] > 0) {
            return memo[m][n];
        }
        return memo[m][n] = dfs(m - 1, n) + dfs(m, n - 1);
    }
}