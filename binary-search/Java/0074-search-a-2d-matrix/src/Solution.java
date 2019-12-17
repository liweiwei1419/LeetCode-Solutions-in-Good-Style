public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        // 特判
        if (rows == 0) {
            return false;
        }
        int cols = matrix[0].length;
        if (cols == 0) {
            return false;
        }

        int left = 0;
        // 最后一格的索引是矩阵元素个数 - 1
        int right = rows * cols - 1;

        while (left < right) {
            int mid = (left + right) >>> 1;

            if (matrix[mid / cols][mid % cols] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return matrix[left / cols][left % cols] == target;
    }
}
