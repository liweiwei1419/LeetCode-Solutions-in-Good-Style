public class NumMatrix {

    private int[][] preSum;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return;
        }

        int cols = matrix[0].length;
        if (cols == 0) {
            return;
        }
        preSum = new int[rows + 1][cols + 1];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                preSum[i + 1][j + 1] = preSum[i + 1][j] + preSum[i][j + 1] - preSum[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1]
                - preSum[row1][col2 + 1]
                - preSum[row2 + 1][col1]
                + preSum[row1][col1];
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        NumMatrix numMatrix = new NumMatrix(matrix);
        int res1 = numMatrix.sumRegion(2, 1, 4, 3);
        System.out.println(res1);

        int res2 = numMatrix.sumRegion(1, 1, 2, 2);
        System.out.println(res2);

        int res3 = numMatrix.sumRegion(1, 2, 2, 4);
        System.out.println(res3);
    }
}
