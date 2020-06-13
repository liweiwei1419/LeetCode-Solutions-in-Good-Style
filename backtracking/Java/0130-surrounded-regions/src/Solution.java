public class Solution {

    // 深度优先遍历

    public void solve(char[][] board) {
        int rows = board.length;
        if (rows == 0) {
            return;
        }
        int cols = board[0].length;
        if (cols == 0) {
            return;
        }

        int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        // 第 1 列和最后 1 列
        for (int i = 0; i < rows; i++) {
            dfs(i, 0, rows, cols, board, directions);
            dfs(i, cols - 1, rows, cols, board, directions);
        }
        // 第 1 行和最后 1 行
        for (int i = 1; i < cols - 1; i++) {
            dfs(0, i, rows, cols, board, directions);
            dfs(rows - 1, i, rows, cols, board, directions);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '-') {
                    board[i][j] = 'O';
                }
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
