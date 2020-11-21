public class Solution {

    // 方法一：动态规划

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        // 0 需要占位
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}