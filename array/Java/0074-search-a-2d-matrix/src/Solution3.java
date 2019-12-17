public class Solution3 {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int begin = 0, end = row * col - 1;
        while (begin <= end) {
            int mid = (end - begin) / 2 + begin;
            int value = matrix[mid / col][mid % col];
            if (value == target) {
                return true;
            } else if (value < target) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
