public class Solution5 {

    // 搜索二维矩阵【从右下角或者左上角开始搜索，关键点就只有这一个】

    // 从左下角开始，尝试不断向右边走
    // 右边走不动了，就向下面走，直到出边界

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;
        // 从左下角开始搜索
        int x = row - 1;
        int y = 0;
        // 每次考虑向上走
        while (x >= 0) {
            // 向上走之前，尽量向右边走
            while (y < col && matrix[x][y] < target) {
                y++;
            }
            if (y < col && matrix[x][y] == target) {
                return true;
            }
            x--;
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
        int target = 20;
        Solution solution = new Solution();
        boolean searchMatrix = solution.searchMatrix(matrix, target);
        System.out.println(searchMatrix);
    }
}
