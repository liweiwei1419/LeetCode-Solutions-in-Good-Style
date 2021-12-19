public class Solution4 {

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
     * 计算小于等于 target 的元素的个数，从矩阵的左上角开始找
     *
     * @param matrix
     * @param target
     * @return
     */
    private int lessEquals(int[][] matrix, int target) {
        int n = matrix.length;
        int i = 0;
        int j = n - 1;
        int count = 0;
        while (i < n && j >= 0) {
            if (matrix[i][j] <= target) {
                count += j + 1;
                i++;
            } else {
                j--;
            }
        }
        return count;
    }
}