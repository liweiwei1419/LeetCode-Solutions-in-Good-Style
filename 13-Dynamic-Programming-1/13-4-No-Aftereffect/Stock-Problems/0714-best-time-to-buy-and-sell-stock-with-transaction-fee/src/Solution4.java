public class Solution4 {

    // 方法一：动态规划（空间优化）

    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = -prices[0];

        for (int i = 1; i < len; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i] );
            dp[1] = Math.max(dp[1], dp[0] - prices[i]- fee);
        }
        return dp[0];
    }
}