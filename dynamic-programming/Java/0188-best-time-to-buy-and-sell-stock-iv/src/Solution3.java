public class Solution3 {

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len < 2 || k < 1) {
            return 0;
        }
        if (k > len / 2) {
            k = len / 2;
        }
        int unassigned = -999999;
        int[][] dp = new int[k + 1][2];
        for (int i = 0; i < k + 1; i++) {
            dp[i][0] = unassigned;
            dp[i][1] = unassigned;
        }
        dp[0][1] = 0;
        for (int i = 0; i < len; i++) {
            for (int j = k; j >= 1; j--) {
                if (dp[j][0] != unassigned) {
                    dp[j][1] = Math.max(dp[j][1], dp[j][0] + prices[i]);
                }
                if (dp[j - 1][1] != unassigned) {
                    dp[j][0] = Math.max(dp[j][0], dp[j - 1][1] - prices[i]);
                }
            }
        }
        int res = 0;
        for (int j = 1; j <= k; j++) {
            res = Math.max(res, dp[j][1]);
        }
        return res;
    }
}
