public class Solution {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        // 特判
        if (len < 2) {
            return 0;
        }

        int[][] dp = new int[len][3];

        // 初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;

        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][2] - prices[i]);
            dp[i][2] = dp[i - 1][0];
        }
        return Math.max(dp[len - 1][0], dp[len - 1][2]);
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 0, 2};
        Solution solution = new Solution();
        int res = solution.maxProfit(prices);
        System.out.println(res);
    }
}
