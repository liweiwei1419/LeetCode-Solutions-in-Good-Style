public class Solution {

    // 方法一：深度优先遍历

    public void solve(char[][] board) {
        // 特殊判断
        int rows = board.length;
        if (rows == 0) {
            return;
        }
        int cols = board[0].length;
        if (cols == 0) {
            return;
        }

        int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        // 第 1 步：四个边的 0 以及与其相邻的 0 都无法被包围，因此
        // 把四周的 0 以及 0 的联通分量全部变成 '-'，

        // 第 1 列和最后 1 列
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0, rows, cols, board, directions);
            }
            if (board[i][cols - 1] == 'O') {
                dfs(i, cols - 1, rows, cols, board, directions);
            }
        }
        // 第 1 行和最后 1 行
        for (int j = 1; j < cols - 1; j++) {
            if (board[0][j] == 'O') {
                dfs(0, j, rows, cols, board, directions);
            }
            if (board[rows - 1][j] == 'O') {
                dfs(rows - 1, j, rows, cols, board, directions);
            }
        }

        // 第 2 步：遍历一次棋盘，
        // 1. 剩下的 0 就是被 X 包围的 0，
        // 2. - 是原来不能被包围的 0，恢复成 0
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '-') {
                    board[i][j] = 'O';
                }
                // 已经是 X 的地方不用管
            }
        }
    }

    private boolean inArea(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    private void dfs(int i, int j, int rows, int cols, char[][] board, int[][] directions) {
        if (inArea(i, j, rows, cols) && board[i][j] == 'O') {
            board[i][j] = '-';
            for (int k = 0; k < 4; k++) {
                int newX = i + directions[k][0];
                int newY = j + directions[k][1];
                dfs(newX, newY, rows, cols, board, directions);
            }
        }
    }
}