public class Solution3 {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = (left + right) / 2;
            int count = lessEquals(matrix, mid);
            if (count < k) {
                // 下一轮搜索区间在 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间在 [left..mid]
                right = mid;
            }
        }
        return left;
    }

    /**
     * 计算小于等于 target 的元素的个数，从矩阵的右下角开始找
     *
     * @param matrix
     * @param target
     * @return
     */
    private int lessEquals(int[][] matrix, int target) {
        int n = matrix.length;
        int i = n - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= target) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return count;
    }
}