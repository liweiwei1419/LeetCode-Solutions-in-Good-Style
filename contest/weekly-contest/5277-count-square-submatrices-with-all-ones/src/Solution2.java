/**
 * @author liweiwei1419
 * @date 2019/12/1 1:28 下午
 */
public class Solution2 {

    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int len = Math.min(m, n);

        // 状态定义：以 (i, j) 为右下角，边长为 k 的正方形是否全为 1
        boolean[][][] dp = new boolean[m][n][len];

        // 初始化的时候，先把边长为 1 的正方形搞定
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = matrix[i][j] == 1;
                if (dp[i][j][0]) {
                    res += 1;
                }
            }
        }

        // 边长为 2 正方形的右下角只在 [1, m], [1, n] 区间里出现
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 1; k < len; k++) {
                    if (matrix[i][j] == 0) {
                        continue;
                    }

                    // 然后看 3 个地方是不是可以构成正方形
                    // 1、i - 1, j
                    // 2、i - 1, j - 1
                    // 3、i, j - 1
                    // 看它之前的状态，所以是 k - 1
                    dp[i][j][k] = dp[i - 1][j][k - 1] && dp[i][j - 1][k - 1] && dp[i - 1][j - 1][k - 1];

                    if (dp[i][j][k]) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
