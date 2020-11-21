public class Solution4 {

    // 方法二：动态规划（空间优化）

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // cash：持有现金
        // hold：持有股票

        int cash = 0;
        int hold = -prices[0];

        int preCash = cash;
        int preHold = hold;

        // 状态数组
        // 状态转移：cash → hold → cash → hold → cash → hold → cash
        for (int i = 1; i < len; i++) {
            cash = Math.max(preCash, preHold + prices[i]);
            hold = Math.max(preHold, preCash - prices[i]);

            preCash = cash;
            preHold = hold;

        }
        return cash;
    }
}