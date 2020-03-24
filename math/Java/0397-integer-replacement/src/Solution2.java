public class Solution2 {

    // 接下来把递归改成动态规划，这个解法通不过，不过采用动态的方式就可以了
    // 这行解法空间复杂度太高，会 超出内存限制

    public int integerReplacement(int n) {
        // 0 要占一个位子，所以要给出 n+1 个位子

        if (n <= 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2] + 1;
            } else {
                // 这样写就太死板了
                // dp[i] = 1 + Math.min(dp[i - 1], dp[i + 1]);
                dp[i] = Math.min(dp[i - 1] + 1, dp[(i + 1) / 2] + 2);
            }
        }
        return dp[n];
    }
}
