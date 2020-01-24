public class Solution3 {

    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }

        int cols = matrix[0].length;
        if (cols == 0) {
            return 0;
        }

        int[] dp = new int[cols + 1];
        int leftUp = 0;
        int res = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int nextLeftUp = dp[j];
                // 注意：是字符 1
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(leftUp, Math.min(dp[j], dp[j - 1])) + 1;
                    res = Math.max(res, dp[j]);
                } else {
                    dp[j] = 0;
                }
                leftUp = nextLeftUp;
            }
        }
        return res * res;
    }
}
