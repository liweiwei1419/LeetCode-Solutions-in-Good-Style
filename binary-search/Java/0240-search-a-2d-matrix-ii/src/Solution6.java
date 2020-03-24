public class Solution6 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;
        // 从左下角开始搜索
        int x = row - 1;
        int y = 0;
        // 每次考虑向右边走
        while (y < col) {
            // 向右边走之前，尽量向上走
            while (x >= 0 && matrix[x][y] > target) {
                x--;
            }
            // 走不动了，再向右边走
            if (x >= 0 && matrix[x][y] == target) {
                return true;
            }
            y++;
        }
        return false;
    }
}
