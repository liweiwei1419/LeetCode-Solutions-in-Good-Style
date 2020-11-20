public class Solution {

    private boolean[][] row;
    private boolean[][] col;
    private boolean[][][] box;

    public void solveSudoku(char[][] board) {
        row = new boolean[9][9];
        col = new boolean[9][9];
        box = new boolean[3][3][9];

        // 步骤 1：同 N 皇后问题，先遍历棋盘一次，然后每一行，每一列在 row col cell 里占住位置
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    // 计算在布尔数值中的下标，减去 1 使得下标从 0 开始
                    int index = board[i][j] - '1';
                    // 在下标为 i 这一行，记录为 true
                    row[i][index] = true;
                    // 在下标为 j 这一列，记录为 true
                    col[j][index] = true;
                    // 在横坐标为 i / 3、纵坐标 j / 3 的地方， 看到的那个数字记录为 true
                    box[i / 3][j / 3][index] = true;
                }
            }
        }
        // 步骤 2：进行一次深度优先遍历，尝试所有的可能性
        dfs(board, 0, 0);
    }

    /**
     * @param board 棋盘
     * @param i     棋盘横坐标
     * @param j     棋盘纵坐标
     * @return 由于存在唯一解，搜索到一个解就可以退出了，递归函数的返回值为是否搜索到一个解
     */
    private boolean dfs(char[][] board, int i, int j) {
        // 递归终止条件 1：全部填完
        if (i == 9) {
            return true;
        }

        // 对 '.' 尝试从 1 填到 9
        if (board[i][j] == '.') {
            for (char c = '1'; c <= '9'; c++) {
                // 如果行、列、box 已经填了 c - '1' 则尝试下一个数字
                int index = c - '1';
                if (row[i][index] || col[j][index] || box[i / 3][j / 3][index]) {
                    continue;
                }

                // 填写当前字符，并且对应 row、col、box 占位
                board[i][j] = c;
                row[i][index] = true;
                col[j][index] = true;
                box[i / 3][j / 3][index] = true;

                // 题目保证只有唯一解，继续填写下一格
                // ①：i + (j + 1) / 9 表示如果 j 已经在一列的末尾（此时 j = 8），跳转到下一行
                // (j + 1) % 9 ，当 j = 8 时，j + 1 重置到 0
                if (dfs(board, i + (j + 1) / 9, (j + 1) % 9)) {
                    return true;
                }

                // 重置变量
                board[i][j] = '.';
                row[i][index] = false;
                col[j][index] = false;
                box[i / 3][j / 3][index] = false;
            }
        } else {
            // 填写下一格和 ① 一样
            return dfs(board, i + (j + 1) / 9, (j + 1) % 9);
        }
        // 递归终止条件 2：全部尝试过以后，返回 false
        return false;
    }
}