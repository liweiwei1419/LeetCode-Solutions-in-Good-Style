// 动态规划

public class Solution2 {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = max3(dp[i], j * dp[i - j], j * (i - j));
            }
        }
        return dp[n];
    }

    private int max3(int num1, int num2, int num3) {
        return Math.max(Math.max(num1, num2), num3);
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int maxBreak = s.integerBreak(10);
        System.out.println(maxBreak);
        for (int i = 1; i < 13; i++) {
            maxBreak = s.integerBreak(i);
            System.out.println(maxBreak);
        }
    }
}
