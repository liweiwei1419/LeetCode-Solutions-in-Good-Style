public class Solution2 {

    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 因为当前状态只依赖于前面一天，因此，可以把转态压缩一个维度
        // 状态压缩，减少空间复杂度
        int[] dp = new int[2];

        // 定义初始值
        dp[0] = 0;
        dp[1] = -prices[0];

        // 第 2 步：从第 2 天开始计算状态转移
        // 第 3 步：思考输出是什么，所有的天数里面，不持有股票的最大值
        for (int i = 1; i < len; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i] - fee);
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
        int fee = 2;
        int res = solution2.maxProfit(prices, fee);
        System.out.println(res);
    }
}
