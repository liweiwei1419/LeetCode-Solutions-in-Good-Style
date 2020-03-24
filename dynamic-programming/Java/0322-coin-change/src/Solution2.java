import java.util.Arrays;

public class Solution2 {

    // 使用「完全背包」问题的思路

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
        Solution2 solution2 = new Solution2();
        int[] coins = {1, 2, 5};
        int amount = 11;
        int res = solution2.coinChange(coins, amount);
        System.out.println(res);
    }
}
