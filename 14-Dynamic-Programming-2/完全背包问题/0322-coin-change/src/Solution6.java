import java.util.Arrays;

public class Solution6 {

    // 完全背包未优化空间的写法

    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        // 定义：使用区间 [0..i) 里的硬币，能够凑出面值总和恰好为 j 的最少硬币数
        int[][] dp = new int[len + 1][amount + 1];

        // 初始化
        for (int[] row : dp) {
            Arrays.fill(row, amount + 1);
        }
        dp[0][0] = 0;
        // 递推开始
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j <= amount; j++) {
                if (coins[i - 1] <= j && dp[i][j - coins[i - 1]] != amount + 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i - 1]] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // 输出
        if (dp[len][amount] == amount + 1) {
            dp[len][amount] = -1;
        }
        return dp[len][amount];
    }

}
