public class Solution3 {

    // 取模还是很费事的

    public int maxProfit(int[] prices) {
        int len = prices.length;
        // 特判
        if (len < 2) {
            return 0;
        }

        int[] dp = new int[3];

        // 初始化
        dp[0] = 0;
        dp[1] = -prices[0];
        dp[2] = 0;

        int preCash = dp[0];
        int preStock = dp[1];

        for (int i = 1; i < len; i++) {
            dp[0] = Math.max(preCash, preStock + prices[i]);
            dp[1] = Math.max(preStock, dp[2] - prices[i]);
            dp[2] = preCash;

            preCash= dp[0];
            preStock = dp[1];
        }
        return Math.max(dp[0], dp[2]);
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 0, 2};
        Solution3 solution2 = new Solution3();
        int res = solution2.maxProfit(prices);
        System.out.println(res);
    }
}
