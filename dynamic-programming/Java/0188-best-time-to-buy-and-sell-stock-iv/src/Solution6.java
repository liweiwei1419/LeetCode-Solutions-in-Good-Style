public class Solution6 {

    // 解法错误

    public int maxProfit(int k, int[] prices) {
        // 特判
        int len = prices.length;
        if (len < 2 || k == 0) {
            return 0;
        }

        // 特别重要
        if (k > len / 2) {
            int res = 0;
            for (int i = 1; i < len; i++) {
                if (prices[i] - prices[i - 1] > 0) {
                    res += prices[i] - prices[i - 1];
                }
            }
            return res;
        }

        k = len / 2;

        int[][][] dp = new int[len][k + 1][2];

        dp[0][1][0] = 0;
        for (int j = 1; j <= k; j++) {
            dp[0][j][1] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[len - 1][k][0];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        int k = 4;

        Solution6 solution6 = new Solution6();
        int res = solution6.maxProfit(k, prices);
        System.out.println(res);
    }
}
