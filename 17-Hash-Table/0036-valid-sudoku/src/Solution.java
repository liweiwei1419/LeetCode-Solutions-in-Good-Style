public class Solution {

    // 方法一：数组（哈希表），空间换时间

    public boolean isValidSudoku(char[][] board) {
        // 第 1 维表示行的下标
        boolean[][] row = new boolean[9][9];
        // 第 1 维表示列的下标
        boolean[][] col = new boolean[9][9];
        // 第 1、2 维表示 board 的下标
        boolean[][][] box = new boolean[3][3][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                // 注意 1：'.' 的时候跳过
                if (board[i][j] == '.') {
                    continue;
                }
                // 注意 2：这里转换成整型数值
                int index = board[i][j] - '1';
                // 注意 3：如果发现冲突，直接返回 false
                if (row[i][index] || col[j][index] || box[i / 3][j / 3][index]) {
                    return false;
                }
                row[i][index] = true;
                col[j][index] = true;
                box[i / 3][j / 3][index] = true;
            }
        }
        return true;
    }
}