public class Solution1 {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // dp[i][j] ，表示 [0, i] 区间里，状态为 j 的最大收益
        // j = 0：什么都不操作
        // j = 1：第 1 次买入一支股票
        // j = 2：第 1 次卖出一支股票
        // j = 3：第 2 次买入一支股票
        // j = 4：第 2 次卖出一支股票

        int[] dp = new int[5];
        dp[1] = -prices[0];
        // 3 状态都还没有发生，因此应该赋值为一个不可能的数
        dp[3] = Integer.MIN_VALUE;

        for (int i = 1; i < len; i++) {
            dp[0] = 0;
            dp[1] = Math.max(dp[1], dp[0] - prices[i]);
            dp[2] = Math.max(dp[2], dp[1] + prices[i]);
            dp[3] = Math.max(dp[3], dp[2] - prices[i]);
            dp[4] = Math.max(dp[4], dp[3] + prices[i]);
        }
        return Math.max(0, Math.max(dp[2], dp[4]));
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] prices = {1, 2, 3, 4, 5};
        int res = solution1.maxProfit(prices);
        System.out.println(res);
    }
}
