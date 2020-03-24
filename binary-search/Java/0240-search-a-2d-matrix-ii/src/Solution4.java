public class Solution4 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;
        // 站在左下角
        int x = row - 1;
        int y = 0;
        while (x >= 0 && y < col) {
            if (matrix[x][y] == target) {
                return true;
            } else if (matrix[x][y] > target) {
                // 向上走（列固定，行变化），等于最好，否则走到第 1 个小于的地方
                // 二分法定位行号
                // x--;
                if (matrix[0][y] > target) {
                    return false;
                }
                int left = 0;
                int right = x;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (matrix[mid][y] == target) {
                        return true;
                    } else if (matrix[mid][y] < target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                x = right;
            } else {
                // 二分法定位列号
                // 向右边走
                // y++;
                if (matrix[x][col - 1] < target) {
                    return false;
                }

                int left = y;
                int right = col - 1;

                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (matrix[x][mid] == target) {
                        return true;
                    } else if (matrix[x][mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                y = left;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target = 40;
        Solution4 solution4 = new Solution4();
        boolean searchMatrix = solution4.searchMatrix(matrix, target);
        System.out.println(searchMatrix);
    }
}
