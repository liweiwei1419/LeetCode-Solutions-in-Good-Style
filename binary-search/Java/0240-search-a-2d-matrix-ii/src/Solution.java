public class Solution {

    // 二分法：先排除掉不存在目标数的行，然后挨个搜索这些行

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }
        int cols = matrix[0].length;
        if (cols == 0) {
            return false;
        }

        int low = 0;
        int height = rows - 1;
        // 站在左上角
        // 找最后一个小于等于 target 的索引
        // 2
        // 4
        // 7
        // 9
        // target = 7 的话，应该找到 7
        while (low < height) {
            int mid = (low + height + 1) >>> 1;
            if (matrix[mid][0] > target) {
                height = mid - 1;
            } else {
                low = mid;
            }
        }

        // 后处理
        if (matrix[low][0] == target) {
            return true;
        }

        // 对每一行进行二分查找，这里 i 的上限写 low 或者 height 都是可以的
        for (int row = 0; row <= low; row++) {
            int left = 0;
            int right = cols - 1;
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (matrix[row][mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            // 后处理
            if (matrix[row][left] == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{-1}, {-1}};
        Solution solution = new Solution();
        int target = -1;
        boolean res = solution.searchMatrix(matrix, target);
        System.out.println(res);
    }
}