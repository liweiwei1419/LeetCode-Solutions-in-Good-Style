public class Solution7 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;
        // 从右上角开始搜索
        int x = 0;
        int y = col - 1;
        // 每次考虑向下走
        while (x < row) {
            // 向下走之前，尽量向左边走
            while (y >= 0 && matrix[x][y] > target) {
                y--;
            }
            if (y >= 0 && matrix[x][y] == target) {
                return true;
            }
            x++;
        }
        return false;
    }
}

