public class Solution {

    // 状态多一个单位的偏移，这样不用讨论特殊情况

    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }

        int cols = matrix[0].length;
        if (cols == 0) {
            return 0;
        }

        int[][] dp = new int[rows + 1][cols + 1];

        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                // 注意：是字符 1
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i + 1][j], dp[i][j + 1])) + 1;
                    res = Math.max(res, dp[i + 1][j + 1]);
                }

            }
        }
        return res * res;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};

        Solution solution = new Solution();
        int res = solution.maximalSquare(matrix);
        System.out.println(res);
    }
}
