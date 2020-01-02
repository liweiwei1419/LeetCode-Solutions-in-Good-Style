public class Solution {

    // 深度优先遍历

    private int rows;
    private int cols;
    private char[][] board;
    private int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public void solve(char[][] board) {
        rows = board.length;
        if (rows == 0) {
            return;
        }
        cols = board[0].length;
        if (cols == 0) {
            return;
        }
        this.board = board;

        // 第 1 列和最后 1 列
        for (int i = 0; i < rows; i++) {
            floodFill(i, 0);
            floodFill(i, cols - 1);
        }

        // 第 1 行和最后 1 行
        for (int i = 1; i < cols - 1; i++) {
            floodFill(0, i);
            floodFill(rows - 1, i);
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

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    private void floodFill(int i, int j) {
        if (inArea(i, j) && board[i][j] == 'O') {
            board[i][j] = '-';
            for (int k = 0; k < 4; k++) {
                int newX = i + directions[k][0];
                int newY = j + directions[k][1];
                floodFill(newX, newY);
            }
        }
    }
}
