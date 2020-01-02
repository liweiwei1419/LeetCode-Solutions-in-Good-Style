public class Solution2 {

    // 状态压缩

    public int maxProfit(int[] prices) {
        int size = prices.length;
        if (size < 2) {
            return 0;
        }

        int dp1 = -prices[0];
        // 注意 1：这里要使用 16 位 int 类型值
        int dp2 = Integer.MIN_VALUE;
        int dp3 = Integer.MIN_VALUE;
        int dp4 = Integer.MIN_VALUE;

        for (int i = 1; i < size; ++i) {
            if (dp3 != Integer.MIN_VALUE) {
                dp4 = Math.max(dp4, dp3 + prices[i]);
            }

            if (dp2 != Integer.MIN_VALUE) {
                dp3 = Math.max(dp3, dp2 - prices[i]);
            }

            dp2 = Math.max(dp2, dp1 + prices[i]);
            dp1 = Math.max(dp1, -prices[i]);
        }
        // 注意 2：最后要和 0 比较一下，因为在股票价格连续下降的时候可以不做交易
        return Math.max(0, Math.max(dp2, dp4));
    }
}
