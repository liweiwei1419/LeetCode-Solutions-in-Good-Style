import java.util.Arrays;

public class Solution {

    public void rotate(int[][] matrix) {
        int N = matrix.length;

        // 第 1 步：转置
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                swap(matrix, i, j);
            }
        }

        // 第 2 步：逐行反转
        for (int[] row : matrix) {
            reverse(row, N);
        }
    }

    /**
     * 将坐标 (x, y) 与 坐标 (y, x) 互换
     *
     * @param matrix
     * @param x
     * @param y
     */
    private void swap(int[][] matrix, int x, int y) {
        int temp = matrix[x][y];
        matrix[x][y] = matrix[y][x];
        matrix[y][x] = temp;
    }

    private void reverse(int[] arr, int N) {
        int left = 0;
        int right = N - 1;
        while (left < right) {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        Solution solution = new Solution();
        solution.rotate(matrix);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
