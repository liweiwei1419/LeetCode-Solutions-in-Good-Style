public class Solution7 {

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

        int[][] dp = new int[k + 1][2];

        dp[1][0] = 0;
        for (int j = 1; j <= k; j++) {
            dp[j][1] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = k; j > 0; j--) {

                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - prices[i]);


                dp[j][0] = Math.max(dp[j][0], dp[j][1] + prices[i]);
            }
        }
        return dp[k][0];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        int k = 4;

        Solution7 solution6 = new Solution7();
        int res = solution6.maxProfit(k, prices);
        System.out.println(res);
    }
}
