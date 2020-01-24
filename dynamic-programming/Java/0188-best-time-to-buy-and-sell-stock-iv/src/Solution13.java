public class Solution13 {

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k == 0 || len < 2) {
            return 0;
        }
        if (k >= len / 2) {
            return greedy(prices, len);
        }

        int[][] dp = new int[k][2];

        for (int j = 0; j < k; j++) {
            dp[j][1] = -9999;
        }

        for (int price : prices) {
            for (int j = 0; j < k ; j++) {
                if (j == 0) {
                    dp[j][1] = Math.max(dp[j][1], -price);
                } else {
                    // 基本状态转移方程 1
                    dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - price);
                }
                // 基本状态转移方程 2
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + price);
            }
        }
        return dp[k - 1][0];
    }

    private int greedy(int[] prices, int len) {
        int res = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i - 1] < prices[i]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
        int k = 4;

        Solution13 solution11 = new Solution13();
        int res = solution11.maxProfit(k, prices);
        System.out.println(res);
    }
}
