import java.util.Arrays;

public class Solution {

    public int[][] imageSmoother(int[][] M) {
        int row = M.length;
        if (row == 0) {
            return new int[0][0];
        }
        int col = M[0].length;
        if (col == 0) {
            return new int[0][0];
        }
        int[][] ret = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ret[i][j] = smoother(M, i, j, row, col);
            }

        }
        return ret;
    }

    private int smoother(int[][] M, int i, int j, int row, int col) {
        int count = 0;
        int sum = 0;
        for (int k = Math.max(0, i - 1); k <= Math.min(row - 1, i + 1); k++) {
            for (int l = Math.max(0, j - 1); l <= Math.min(col - 1, j + 1); l++) {
                sum += M[k][l];
                count++;
            }
        }
        return sum / count;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};
        Solution solution = new Solution();
        int[][] imageSmoother = solution.imageSmoother(matrix);
        for (int i = 0; i < imageSmoother.length; i++) {
            System.out.println(Arrays.toString(imageSmoother[i]));
        }
    }
}
