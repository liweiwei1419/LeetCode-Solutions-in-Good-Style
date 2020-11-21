public class Solution2 {

    // 方法二：动态规划

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // dp[i][j]：到下标为 i 这一天结束的时候，拥有的现金数
        // 第 1 维：天数（从 0 开始）
        // 第 2 维：是否持股，0 表示不持股，1 表示持股
        int[][] dp = new int[len][2];
        // 初始化
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 从下标 1 开始进行状态转移
        // 状态转移：0 → 1 → 0 → 1 → 0 → 1 → 0
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        // 由于状态定义具有前缀性质，因此将最后一个状态，不持股的结果返回即可
        return dp[len - 1][0];
    }
}