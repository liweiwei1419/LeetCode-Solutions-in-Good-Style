public class Solution4 {
    public int integerBreak(int n) {
        if (n <= 1) {
            return 1;
        }
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
        return Integer.max(Integer.max(num1, num2), num3);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int integerBreak = solution.integerBreak(8);
        System.out.println(integerBreak);
    }
}