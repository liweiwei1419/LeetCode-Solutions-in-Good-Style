import java.util.Arrays;

public class Solution5 {

    // 完全背包（最初的写法）

    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        // 定义：使用区间 [0..i] 中的硬币，可以凑出总容量恰好为 j 的最少方案数
        int[][] dp = new int[len][amount + 1];
        for (int i = 0; i < len; i++) {
            // 要找最小值，所以初始化的时候全部设置为最大值
            Arrays.fill(dp[i], amount + 1);
        }

        // 初始化
        dp[0][0] = 0;
        for (int j = coins[0]; j <= amount; j++) {
            if (dp[0][j - coins[0]] != amount + 1) {
                dp[0][j] = dp[0][j - coins[0]] + 1;
            }
        }

        // 递推开始
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= amount; j++) {
                if (coins[i] <= j && dp[i][j - coins[i]] != amount + 1) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        if (dp[len - 1][amount] == amount + 1) {
            dp[len - 1][amount] = -1;
        }
        return dp[len - 1][amount];
    }

    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        int[] coins = new int[]{186, 419, 83, 408};
        int target = 6249;
        int res = solution5.coinChange(coins, target);
        System.out.println(res);
    }
}
