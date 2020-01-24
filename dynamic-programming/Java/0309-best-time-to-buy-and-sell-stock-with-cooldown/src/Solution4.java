public class Solution4 {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }

        // 第一个维度是天数
        // 第二个维度表示是否持有股票
        // 0 表示不持有，包括本来就不持有和处在冷冻期
        // 1 表示持有
        // 2 表示进入冷冻期

        int[][] dp = new int[len][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        for (int i = 1; i < len; i++) {
            // 第 i 天不持有股票的情况有两种
            // a.第 i - 1 天也不持有股票
            // b.第 i - 1 天进入冷冻期（i - 1天卖出）
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);

            // 第 i 天持有股票有两种情况
            // a.第i - 1天也持有股票
            // b.第i - 1天不持有股票，在第i天买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            // 第i天进入冷冻期只有一种情况，第i - 1天持有股票且卖出（今天卖出）
            dp[i][2] = dp[i - 1][1] + prices[i];
        }
        // 最后最大利润为最后一天，不持有股票或者进入冷冻期的情况 （今天卖出）
        return Math.max(dp[len - 1][0], dp[len - 1][2]);

    }
}
