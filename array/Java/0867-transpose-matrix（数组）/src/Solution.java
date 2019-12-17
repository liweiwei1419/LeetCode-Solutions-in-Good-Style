import java.util.Arrays;

public class Solution {

    public int[][] transpose(int[][] A) {
        int row = A.length;
        if (row == 0) {
            return new int[0][0];
        }
        int col = A[0].length;
        int[][] matrix = new int[col][row];
        // 遍历还是按照原来的方式遍历
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 按照转置的方式填写转置矩阵就可以了
                matrix[j][i] = A[i][j];
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Solution solution = new Solution();
        int[][] transpose = solution.transpose(matrix);
        for (int i = 0; i < transpose.length; i++) {
            System.out.println(Arrays.toString(transpose[i]));
        }
    }
}
