public class Solution6 {

    /**
     * @param n
     * @return
     */

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = max3(max, j * (i - j), j * dp[i - j]);
            }
            dp[i] = max;
        }
        return dp[n];
    }

    private int max3(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }
}
