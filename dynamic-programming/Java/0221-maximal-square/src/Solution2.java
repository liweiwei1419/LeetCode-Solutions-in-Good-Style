public class Solution2 {

    // 状态压缩

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
        int res = 0;
        int leftUp = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                // 把下一个需要的状态值保存起来
                int nextLeftUp = dp[j + 1];
                // 注意：是字符 1
                if (matrix[i][j] == '1') {
                    dp[j + 1] = Math.min(leftUp, Math.min(dp[j], dp[j + 1])) + 1;
                    res = Math.max(res, dp[j + 1]);
                } else {
                    // 注意：这里要重置一下
                    dp[j + 1] = 0;
                }

                leftUp = nextLeftUp;

            }
        }
        return res * res;
    }
}
