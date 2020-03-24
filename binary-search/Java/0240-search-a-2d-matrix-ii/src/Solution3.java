public class Solution3 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }
        int cols = matrix[0].length;
        if (cols == 0) {
            return false;
        }


        // 起点：左下角
        int x = rows - 1;
        int y = 0;
        // 不越界的条件是：行大于等于 0，列小于等于 cols - 1
        while (x >= 0 && y < cols) {
            // 打开注释，可以用于调试的代码
            // System.out.println("沿途走过的数字：" + matrix[x][y]);
            if (matrix[x][y] > target) {
                x--;
            } else if (matrix[x][y] < target) {
                y++;
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
        int target = 12;
        Solution3 solution3 = new Solution3();
        boolean searchMatrix = solution3.searchMatrix(matrix, target);
        System.out.println(searchMatrix);
    }
}
