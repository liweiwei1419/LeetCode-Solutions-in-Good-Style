public class Solution3 {

    // 完全背包空间优化的写法

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        // 初始化
        dp[0] = 1;

        // 递推开始
        int len = coins.length;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j - coins[i - 1] >= 0) {
                    dp[j] += dp[j - coins[i - 1]];
                }
            }
        }
        return dp[amount];
    }
}