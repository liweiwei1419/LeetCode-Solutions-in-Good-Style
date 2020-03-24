public class Solution2 {

    public boolean searchMatrix(int[][] matrix, int target) {
        // 特判
        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }
        int cols = matrix[0].length;
        if (cols == 0) {
            return false;
        }

        // 起点：右上角
        int x = 0;
        int y = cols - 1;

        // 不越界的条件是：行小于等于 rows - 1，列大于等于 0
        while (x < rows && y >= 0) {
            // 打开注释，可以用于调试的代码
            // System.out.println("沿途走过的数字：" + matrix[x][y]);
            if (matrix[x][y] > target) {
                y--;
            } else if (matrix[x][y] < target) {
                x++;
            } else {
                return true;
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
        int target = 10;
        Solution2 solution2 = new Solution2();
        boolean searchMatrix = solution2.searchMatrix(matrix, target);
        System.out.println(searchMatrix);
    }
}
