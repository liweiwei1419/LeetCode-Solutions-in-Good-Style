public class Solution7 {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = max3(Math.max(dp[i - 1], i - 1), 2 * Math.max(dp[i - 2], i - 2), 3 * Math.max(dp[i - 3], i - 3));
        }
        return dp[n];
    }

    private int max3(int num1, int num2, int num3) {
        return Math.max(Math.max(num1, num2), num3);
    }
}
