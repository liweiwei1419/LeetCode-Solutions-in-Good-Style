import java.util.Arrays;

public class Solution7 {

    // 完全背包最原始的样子

    public int numSquares(int n) {
        int upBound = (int) Math.sqrt(n);
        int[][] dp = new int[upBound + 1][n + 1];

        for (int i = 0; i < upBound; i++) {
            Arrays.fill(dp[i], 4);
        }
        dp[0][0] = 0;
        // 遍历物品

        for (int i = 1; i <= upBound; i++) {
            // 遍历背包
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (i * i <= j && dp[i][j - i * i] != 4) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - i * i] + 1);
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp));

        return dp[upBound][n];
    }

    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        int n = 12;
        int res = solution7.numSquares(n);
        System.out.println(res);
    }
}