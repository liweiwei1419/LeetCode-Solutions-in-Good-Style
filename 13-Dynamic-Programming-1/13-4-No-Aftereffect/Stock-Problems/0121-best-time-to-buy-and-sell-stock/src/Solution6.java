public class Solution6 {

    // 方法四：差分，转化为差分数组的最大子段和

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 差分数组比原始数组的长度少 1
        int[] diff = new int[len - 1];
        for (int i = 0; i < len - 1; i++) {
            diff[i] = prices[i + 1] - prices[i];
        }

        // dp[i] 以 diff[i] 结尾的子序列的和的最大值
        int[] dp = new int[len - 1];
        dp[0] = diff[0];
        for (int i = 1; i < len - 1; i++) {
            dp[i] = Math.max(diff[i], dp[i - 1] + diff[i]);
        }

        // 还是要考虑到 [7 , 6, 5, 4, 3] 这种不交易的情况
        // 初值应该赋值成 0
        int res = 0;
        for (int i = 0; i < len - 1; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}