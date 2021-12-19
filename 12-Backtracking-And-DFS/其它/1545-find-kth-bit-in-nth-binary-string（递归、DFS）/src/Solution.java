public class Solution {

    public char findKthBit(int n, int k) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] * 2 + 1;
        }
        return dfs(dp, n, k);
    }


    private char dfs(int[] dp, int n, int k) {
        if (n == 1) {
            return '0';
        }
        int m = dp[n - 1] + 1;
        if (k == m) {
            return '1';
        }
        if (k < m) {
            return dfs(dp, n - 1, k);
        }
        char ch = dfs(dp, n - 1, dp[n] - k + 1);
        if (ch == '1') {
            return '0';
        }
        return '1';
    }
}
