import java.util.Arrays;

public class Solution3 {

    // 动态规划时间复杂度高

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        // 最大值是 4，这是一个不可能的值
        Arrays.fill(dp, 4);

        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int numSquares = solution3.numSquares(12);
        System.out.println(numSquares);
    }
}
