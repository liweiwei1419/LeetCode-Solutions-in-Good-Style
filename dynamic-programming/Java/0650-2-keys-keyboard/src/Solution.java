public class Solution {

    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 0;
        // 使用 n 的因子来处理
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    // i - j 的意思是现在已经有 j 了，所以要减去，需要再粘贴（i - j）/ j 个 j，
                    // 然后 +1 是加上copyAll的这一次
                    dp[i] = Math.min(dp[i], dp[j] + (i - j) / j + 1);
                }
            }
        }
        return dp[n];
    }
}
