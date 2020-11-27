public class Solution9 {

    public int change(int amount, int[] coins) {
        int len = coins.length;
        if (len == 0) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = coins[0]; i <= amount; i += coins[0]) {
            dp[i] = 1;
        }

        for (int i = 1; i < len; i++) {
            for (int j = coins[i]; j <= amount; j += coins[i]) {
                dp[j + coins[i]] += dp[j];

            }
        }
        return dp[amount];
    }
}
