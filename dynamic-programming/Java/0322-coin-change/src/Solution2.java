import java.util.Arrays;

public class Solution2 {

    public int coinChange(int[] coins, int amount) {
        // 给 0 占位
        int[] dp = new int[amount + 1];

        // 注意：因为要比较的是最小值，这个不可能的值就得赋值成为一个最大值
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != -1) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }

            if (dp[i] == amount + 1) {
                dp[i] = -1;
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
