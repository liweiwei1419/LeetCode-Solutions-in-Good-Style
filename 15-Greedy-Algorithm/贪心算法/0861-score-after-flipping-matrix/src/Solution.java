public class Solution {

    public int matrixScore(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;

        int res = rows * (1 << (cols - 1));

        // 注意：从 1 开始
        for (int j = 1; j < cols; j++) {
            int nOnes = 0;
            for (int i = 0; i < rows; i++) {
                if (A[i][0] == 1) {
                    nOnes += A[i][j];
                } else {
                    // 如果这一行进行了行反转，则该元素的实际取值为 1 - A[i][j]
                    nOnes += (1 - A[i][j]);
                }
            }
            int k = Math.max(nOnes, rows - nOnes);
            res += k * (1 << (cols - j - 1));
        }
        return res;
    }
}