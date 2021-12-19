public class Solution5 {

    // 与前面问题不同的地方在于，规定在卖出的时候扣除手续费

    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 第 1 步：定义状态：第 2 维表示是否持股
        // dp[i][0]：到下标为 i 这一天，不持有股票的时候，我们手上拥有的现金数
        // dp[i][1]：到下标为 i 这一天，持有股票的时候，我们手上拥有的现金数
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            // 规定在卖出股票的时候扣除手续费
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }
}