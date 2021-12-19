public class Solution {

    // 暴力解法：不能通过测试用例

    public int maxSideLength(int[][] mat, int threshold) {
        int rows = mat.length;
        if (rows == 0) {
            return 0;
        }
        int cols = mat[0].length;
        if (cols == 0) {
            return 0;
        }

        int maxSide = Math.min(rows, cols);
        int res = 0;
        for (int k = 1; k <= maxSide; k++) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (i + k > rows || j + k > cols) {
                        continue;
                    }

                    int sum = getSubMatrixSum(mat, i, j, k);
                    if (sum <= threshold) {
                        res = Math.max(res, k);
                    }
                }
            }
        }
        return res;
    }

    private int getSubMatrixSum(int[][] mat, int x, int y, int side) {
        int maxRow = x + side;
        int maxCol = y + side;
        int res = 0;
        for (int i = x; i < maxRow; i++) {
            for (int j = y; j < maxCol; j++) {
                res += mat[i][j];
            }
        }
        return res;
    }
}