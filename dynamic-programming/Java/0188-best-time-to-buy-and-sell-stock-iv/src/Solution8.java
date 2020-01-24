public class Solution8 {

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;

        if (k == 0 || len < 2) {
            return 0;
        }

        if (k >= len / 2) {
            return greedy(prices, len);
        }

        // 状态转移方程有 -1 的时候，为了防止数组下标越界，多开一行，是常见的做法
        int[][][] dp = new int[len + 1][k + 1][2];

        // 初始化：把持股的部分都设置为一个较大的负值
        for (int i = 0; i <= len; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j][1] = -9999;
            }
        }

        // 注意：i 和 j 都有 1 个位置的偏移
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
            }
        }

        // 说明：i、j 状态都是前缀性质的，只要在最后定义就可以了
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

    public static void main(String[] args) {
        int[] prices = new int[]{3, 2, 6, 5, 0, 3};
        int k = 2;

        Solution8 solution8 = new Solution8();
        int res = solution8.maxProfit(k, prices);
        System.out.println(res);
    }
}
