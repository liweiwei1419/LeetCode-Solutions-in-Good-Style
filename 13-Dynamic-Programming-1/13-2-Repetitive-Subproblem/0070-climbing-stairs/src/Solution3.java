public class Solution3 {

    // 方法三：记忆化递归

    private int[] memo;

    public int climbStairs(int n) {
        memo = new int[n + 1];
        return dfs(n);
    }

    private int dfs(int n) {
        if (memo[n] != 0) {
            return memo[n];
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        return memo[n] = dfs(n - 1) + dfs(n - 2);
    }
}