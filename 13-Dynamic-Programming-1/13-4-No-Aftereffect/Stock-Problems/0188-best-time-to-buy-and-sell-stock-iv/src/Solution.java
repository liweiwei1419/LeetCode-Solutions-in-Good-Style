public class Solution {

    // 方法一：动态规划（超出内存限制）

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        // 特殊判断
        if (k == 0 || len < 2) {
            return 0;
        }
        // 特殊判断，因为交易一次需要 2 天，如果 k >= len / 2，相当于没有限制
        // 转换为「力扣」第 122 题，使用贪心算法
        if (k >= len / 2) {
            return greedy(prices, len);
        }

        // 状态转移方程里下标有 -1 的时候，为了防止数组下标越界，多开一行，因此第一维的长度是 len + 1
        // 第二维表示交易次数，从 0 开始，因此第二维的长度是 k + 1
        // 第三维表示是否持股，0：不持股，1：持股
        int[][][] dp = new int[len + 1][k + 1][2];

        // 初始化：把持股的部分都设置为一个较小的负值
        // 注意：如果使用默认值 0，状态转移的过程中会做出错误的决策
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j][1] = Integer.MIN_VALUE;
            }
        }

        // 注意：i 和 j 都有 1 个位置的偏移
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
            }
        }
        // 说明：第一维和第二维状态都具有前缀性质的，输出最后一个状态即可
        return dp[len][k][0];
    }

    private int greedy(int[] prices, int len) {
        // 转换为股票系列的第 2 题，使用贪心算法完成，思路是只要有利润，就交易
        int res = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i] > prices[i - 1]) {
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}