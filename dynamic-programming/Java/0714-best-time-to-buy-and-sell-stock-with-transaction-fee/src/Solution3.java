/**
 * @author liweiwei1419
 * @date 2019/10/23 5:16 下午
 */
public class Solution3 {

    // 使用差分数组来做

    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 差分数组
        int[] diff = new int[len - 1];
        for (int i = 1; i < len; i++) {
            diff[i - 1] = prices[i] - prices[i - 1];
        }

        int[] dp = new int[2];
        dp[0] = 0;
        // 在买入股票的时候计算 fee
        dp[1] = diff[0] - fee;

        for (int i = 1; i < len - 1; i++) {
            dp[0] = Math.max(dp[0], dp[1]);
            dp[1] = Math.max(dp[1] + diff[i], dp[0] + diff[i] - fee);
        }
        return Math.max(dp[0], dp[1]);
    }
}


