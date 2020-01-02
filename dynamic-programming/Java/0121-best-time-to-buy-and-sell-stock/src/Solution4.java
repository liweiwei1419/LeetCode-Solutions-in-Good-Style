public class Solution4 {

    // 动态规划

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 0：不进行任何操作
        // 1：用户执行了一次买入操作
        // 2：用户执行了一次卖出操作

        // 状态转移方程：
        // dp[i][0] 永远等于 0
        // dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i])
        // dp[i][2] = max(dp[i - 1][2], dp[i - 1][1] + prices[i])


        // 注意：如果是 `[7, 6, 5, 4, 3]` 这种波动，应该不交易，
        // 因此输出是：max(dp[len - 1][0], dp[len - 1][2])

        int[][] dp = new int[len][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        // 这里状态 2 不应该有值，设置为 0 不影响正确性
        dp[0][2] = 0;
        for (int i = 1; i < len; i++) {
            // 可以不显式赋值，因为 int 的初值就是 0
            dp[i][0] = 0;
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][2]);
    }
}
