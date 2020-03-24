public class Solution8 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;
        // 从右上角开始搜索
        int x = 0;
        int y = col - 1;
        // 每次考虑向左边走
        while (y >= 0) {
            // 向左边走之前，尽量向下走
            while (x < row && matrix[x][y] < target) {
                x++;
            }
            if (x < row && matrix[x][y] == target) {
                return true;
            }
            y--;
        }
        return false;
    }
}
