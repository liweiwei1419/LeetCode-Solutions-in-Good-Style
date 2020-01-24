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

    public static void main(String[] args) {
//        int[][] mat = {{1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}, {1, 1, 3, 2, 4, 3, 2}};
//        int threshold = 4;

        int[][] mat = {{18, 70}, {61, 1}, {25, 85}, {14, 40}, {11, 96}, {97, 96}, {63, 45}};
        int threshold = 40184;
        Solution solution = new Solution();
        int res = solution.maxSideLength(mat, threshold);
        System.out.println(res);
    }
}
