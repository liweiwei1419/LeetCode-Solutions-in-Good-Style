import java.util.Arrays;

public class Solution6 {

    // 完全背包
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 4);
        dp[0] = 0;
        // 遍历物品
        for (int i = 1; i * i <= n; i++) {
            // 遍历背包
            for (int j = 1; j <= n; j++) {
                if (i * i <= j && dp[j - i * i] != 4) {
                    dp[j] = Math.min(dp[j - i * i] + 1, dp[j]);
                }
            }
        }
        return dp[n];
    }
}