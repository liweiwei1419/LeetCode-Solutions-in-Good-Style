public class Solution3 {

    // 方法二：记忆化递归

    private int[] memo;

    public int numTrees(int n) {
        if (n < 0) {
            return 0;
        }
        if (n < 2) {
            return 1;
        }
        memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        return dfs(n);
    }

    private int dfs(int n) {
        if (memo[n] != 0) {
            return memo[n];
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += dfs(i - 1) * dfs(n - i);
        }
        memo[n] = sum;
        return sum;
    }
}