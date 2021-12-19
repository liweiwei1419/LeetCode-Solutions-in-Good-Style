public class Solution3 {

    public int maxSideLength(int[][] mat, int threshold) {
        int rows = mat.length;
        if (rows == 0) {
            return 0;
        }
        int cols = mat[0].length;
        if (cols == 0) {
            return 0;
        }

        int[][] preSum = new int[rows + 1][cols + 1];
        int maxLen = 0;
        // 注意：对 mat 的访问只到 mat[rows - 1][cols - 1]，因此 i 和 j 的上界分别是 rows 和 cols 可以取等号
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                // 容斥原理
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + mat[i - 1][j - 1] - preSum[i - 1][j - 1];
                // 判断是否有该点为右下角定点的更大的正方形，sum <= threshold, 如果有更新最大边
                // 注意：这里取 i 和 j
                int maxSide = Math.min(i, j);
                for (int k = maxLen + 1; k <= maxSide; k++) {
                    int x1 = i - k + 1;
                    int y1 = j - k + 1;
                    int subSum = preSum[i][j] - preSum[i][y1 - 1] - preSum[x1 - 1][j] + preSum[x1 - 1][y1 - 1];
                    if (subSum <= threshold) {
                        maxLen = k;
                    } else {
                        // 因为都是正的，所以一旦发现不行直接退出循环即可
                        break;
                    }
                }
            }
        }
        return maxLen;
    }
}