import java.util.Arrays;

public class Solution3 {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        if (dp[amount] == amount + 1) {
            dp[amount] = -1;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[] coins = {2};
        int amount = 3;
        int res = solution3.coinChange(coins, amount);
        System.out.println(res);
    }
}
