import java.util.Arrays;

public class Solution2 {

    // 4 个数轮换，大风车转呀转悠悠

    public void rotate(int[][] matrix) {
        int N = matrix.length;
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[N - j - 1][i];
                matrix[N - j - 1][i] = matrix[N - i - 1][N - j - 1];
                matrix[N - i - 1][N - j - 1] = matrix[j][N - i - 1];
                matrix[j][N - i - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };

        Solution2 solution2 = new Solution2();
        solution2.rotate(matrix);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        // 850488
        System.out.println(Integer.MAX_VALUE / 101 / 25);
    }
}
