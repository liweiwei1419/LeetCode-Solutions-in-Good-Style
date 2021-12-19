public class Solution2 {

    // 方法二：状态数组多设置一行的写法

    public int change(int amount, int[] coins) {
        int len = coins.length;
        // 定义：使用区间 [0, i) 里的硬币，恰好可以凑出面值为 j 的方案总数
        int[][] dp = new int[len + 1][amount + 1];
        // 初始化
        dp[0][0] = 1;

        // 递推开始
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[len][amount];
    }
}