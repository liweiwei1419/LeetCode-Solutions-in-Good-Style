public class Solution {

    // 和张心翮的写法一样

    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 第 1 步：定义状态

        // dp[i][0]：到第 i 天为止（包括第 i 天），不持有股票的时候，能够得到的最大利润
        // dp[i][1]：到第 i 天为止（包括第 i 天），持有股票的时候，能够得到的最大利润
        int[][] dp = new int[len][2];

        // 定义初始值
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        // 第 2 步：从第 2 天开始计算状态转移
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        // 第 3 步：思考输出是什么
        // 所有的天数里面，不持有股票的最大值
        return dp[len - 1][0];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
        int fee = 2;
        int res = solution.maxProfit(prices, fee);
        System.out.println(res);
    }
}
