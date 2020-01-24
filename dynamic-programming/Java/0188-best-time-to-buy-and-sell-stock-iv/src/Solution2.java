public class Solution2 {

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len < 2 || k < 1) {
            return 0;
        }
        if (k > len / 2) {
            k = len / 2;
        }
        int[] diff = new int[len - 1];
        for (int i = 0; i < len - 1; i++) {
            diff[i] = prices[i + 1] - prices[i];
        }
        int[][] dp = new int[k + 1][2];
        int res = 0;
        for (int i = 1; i < len ; i++) {
            for (int j = k; j >=1 ; j--) {
                // 顺序很重要，不能变
                dp[j][0] = Math.max(dp[j][0], dp[j][1]);
                dp[j][1] = Math.max(dp[j][1] + diff[i - 1], dp[j - 1][0] + diff[i - 1]);
                res = Math.max(res, Math.max(dp[j][0], dp[j][1]));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{2, 4, 1};
        int k = 2;
        Solution2 solution = new Solution2();
        int res = solution.maxProfit(k, prices);
        System.out.println(res);
    }
}
