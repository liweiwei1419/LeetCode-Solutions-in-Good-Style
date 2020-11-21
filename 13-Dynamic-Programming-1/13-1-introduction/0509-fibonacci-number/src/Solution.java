public class Solution {

    // 动态规划
    // 时间复杂度：O(N)
    // 空间复杂度：O(N)

    public int fib(int N) {
        if (N < 2) {
            return N;
        }
        int[] dp = new int[N + 1];

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }
}