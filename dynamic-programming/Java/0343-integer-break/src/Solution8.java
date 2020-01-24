public class Solution8 {

    public int integerBreak(int n) {
        int[] dp = {0, 1, 1};
        for (int i = 3; i < n + 1; i++) {
            dp[i % 3] = max3(Math.max(dp[(i - 1) % 3], i - 1), 2 * Math.max(dp[(i - 2) % 3], i - 2), 3 * Math.max(dp[(i - 3) % 3], i - 3));
        }
        return dp[n % 3];
    }

    private int max3(int num1, int num2, int num3) {
        return Math.max(Math.max(num1, num2), num3);
    }
}
