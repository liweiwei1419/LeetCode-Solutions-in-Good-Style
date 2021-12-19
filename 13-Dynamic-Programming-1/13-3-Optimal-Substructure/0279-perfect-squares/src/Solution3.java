import java.util.Arrays;


public class Solution3 {

    // 动态规划

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 4);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return dp[n];
    }
}