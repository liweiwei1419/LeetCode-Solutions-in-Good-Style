public class Solution3 {

    public int minFallingPathSum(int[][] arr) {
        int len = arr.length;

        int maxVal = 400_0000;
        int[][] dp = new int[2][len];
        System.arraycopy(arr[0], 0, dp[0], 0, len);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len; j++) {
                dp[i % 2][j] = maxVal;
                for (int k = 0; k < len; k++) {
                    if (j == k) {
                        continue;
                    }
                    dp[i % 2][j] = Math.min(dp[i % 2][j], dp[(i - 1) % 2][k] + arr[i][j]);
                }
            }

        }

        int res = maxVal;
        for (int i = 0; i < len; i++) {
            res = Math.min(res, dp[(len - 1) % 2][i]);
        }
        return res;
    }
}
