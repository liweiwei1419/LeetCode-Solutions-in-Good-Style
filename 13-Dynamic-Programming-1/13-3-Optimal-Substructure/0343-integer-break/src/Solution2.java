public class Solution2 {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        // 初始化
        dp[1] = 1;
        // 递推开始
        for (int i = 2; i <= n; i++) {
            // 其中一个加法因子至少是 1，最多是 i - 1
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
}