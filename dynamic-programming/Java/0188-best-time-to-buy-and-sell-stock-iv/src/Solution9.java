public class Solution9 {

    // 状态压缩

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;

        if (k == 0 || len < 2) {
            return 0;
        }

        if (k >= len / 2) {
            // 转换为股票系列的第 2 题，使用贪心算法完成，思路是只要有利润，就交易
            int res = 0;

            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    res += prices[i] - prices[i - 1];
                }
            }
            return res;

        }

        int[][] dp = new int[k + 1][2];
        for (int i = 0; i <= k; i++) {
            dp[i][1] = -9999;
        }

        for (int price : prices) {
            for (int j = 1; j <= k; j++) {
                dp[j][1] = Math.max(dp[j][1], dp[j - 1][0] - price);
                dp[j][0] = Math.max(dp[j][0], dp[j][1] + price);
            }
        }
        return dp[k][0];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{3, 2, 6, 5, 0, 3};
        int k = 2;

        Solution9 solution8 = new Solution9();
        int res = solution8.maxProfit(k, prices);
        System.out.println(res);
    }
}
