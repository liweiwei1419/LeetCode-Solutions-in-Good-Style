public class Solution {

    public int integerBreak(int n) {
        // 0 需要占位，因此开 n + 1 个空间
        int[] dp = new int[n + 1];
        // 这个值不会被参考到，因此，只是占位，不会被用到
        dp[0] = 99999;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }
        return dp[n];
    }
}
