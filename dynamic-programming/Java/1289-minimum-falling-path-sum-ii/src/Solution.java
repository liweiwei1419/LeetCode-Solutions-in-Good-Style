public class Solution {

    public int minFallingPathSum(int[][] arr) {
        int len = arr.length;

        int maxVal = 400_0000;
        int[][] dp = new int[len + 1][len + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= len; j++) {
                // 假设修正法
                dp[i][j] = maxVal;
                for (int k = 1; k <= len; k++) {
                    if (j == k) {
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + arr[i - 1][j - 1]);
                }
            }

        }

        int res = maxVal;
        for (int i = 1; i <= len; i++) {
            res = Math.min(res, dp[len][i]);
        }
        return res;
    }
}
