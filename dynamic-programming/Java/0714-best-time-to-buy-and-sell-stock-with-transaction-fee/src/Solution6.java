public class Solution6 {

    // dp[i]：第 i 天的最大利润
    // 定义两个维度：第一个维度是天数，第二个维度是是否持有
    // 0 为不持有，1为持有

    // 输出是最后一天不持有

    public int maxProfit(int[] prices, int fee) {

        int len = prices.length;
        if (len == 0) {
            return 0;
        }

        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        // 持有，表示购进，因此利润为负数
        dp[0][1] = -prices[0];


        for (int i = 1; i < len; i++) {
            // 分类讨论：今天的操作仅和昨天有关
            // 1、i - 1天持股，i 天卖出才能获得最高利润
            // 2、i - 1天不持股，i 天仍然不持股
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + (prices[i] - fee));

            // 分类讨论：今天的操作仅和昨天有关
            // 1、i - 1天持股，i 什么都不操作，因为不能操作
            // 2、i - 1天不不持股，i 天必须买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        // 输出为：最后一天不持有
        return dp[len - 1][0];
    }
}
