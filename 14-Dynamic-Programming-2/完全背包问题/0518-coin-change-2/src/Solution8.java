public class Solution8 {

    public int change(int amount, int[] coins) {
        int len = coins.length;
        if (len == 0) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }

        int[] dp = new int[amount + 1];
        // 初始化
        dp[0] = 1;
        for (int i = coins[0]; i <= amount; i += coins[0]) {
            dp[i] = 1;
        }

        // 递推开始
        for (int i = 1; i < len; i++) {
            // 从 coins[i] 开始即可
            for (int j = coins[i] ; j <= amount; j++) {
                if (j - coins[i] >= 0) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}
