public class Solution {

    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        // 最小值
        int left = matrix[0][0];
        // 最大值
        int right = matrix[m - 1][n - 1];

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            // 从头到尾，数一下小于等于 mid 的个数
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] <= mid) {
                        count++;
                    } else {
                        break;
                    }
                }
            }

            if (count < k) {
                // 如果 mid 的个数小于 k 个，说明
                // target 位于 [mid + 1..right] 之间
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}