import java.util.Arrays;

public class Solution {

    /**
     * 前缀和矩阵
     */
    private int[][] preSum;

    public int[][] matrixBlockSum(int[][] mat, int K) {
        // 行数和列数不用特判，因为题目已经说了不为 0
        int rows = mat.length;
        int cols = mat[0].length;

        // 初始化的时候多设置一行，多设置一列
        preSum = new int[rows + 1][cols + 1];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                preSum[i + 1][j + 1] = preSum[i + 1][j] + preSum[i][j + 1] - preSum[i][j] + mat[i][j];
            }
        }

        int[][] res = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 左上角横纵坐标
                int row1 = Math.max(i - K, 0);
                int col1 = Math.max(j - K, 0);

                // 右下角横纵坐标
                int row2 = Math.min(i + K, rows - 1);
                int col2 = Math.min(j + K, cols - 1);
                res[i][j] = sumRegion(row1, col1, row2, col2);
            }
        }
        return res;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1]
                - preSum[row1][col2 + 1]
                - preSum[row2 + 1][col1]
                + preSum[row1][col1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int K = 1;

        int[][] res = solution.matrixBlockSum(mat, K);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));

        }
    }
}
