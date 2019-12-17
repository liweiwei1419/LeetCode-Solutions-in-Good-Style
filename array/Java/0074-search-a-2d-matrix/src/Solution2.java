public class Solution2 {

    // 我自己根据二分法的思想写出来的代码

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;
        if (col == 0) {
            return false;
        }
        if (matrix[0][0] > target) {
            return false;
        }
        // 之前写了那么多，都是极端的要排除掉的情况

        // 二分法找到下界，即小于或者等于 target 的最大数
        int left = 0;
        int right = row - 1;

        // 等号不要忘记了
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // 在这一行里找
        int targetInRow = right;
        left = 0;
        right = col - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[targetInRow][mid] == target) {
                return true;
            } else if (matrix[targetInRow][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3}};
        int target = 3;
        Solution2 solution2 = new Solution2();
        boolean searchMatrix = solution2.searchMatrix(matrix, target);
        System.out.println(searchMatrix);
    }
}
