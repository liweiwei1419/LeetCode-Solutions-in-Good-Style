public class Solution2 {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') {
                    // 思路：在 '.' 上逐个尝试
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (solve(board)) {
                                return true;
                            }
                            // 状态重置
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }

            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {

            // 检查行
            if (board[i][col] != '.' && board[i][col] == c) {
                return false;
            }

            // 检查列
            if (board[row][i] != '.' && board[row][i] == c) {
                return false;
            }

            // 检查块
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] != '.'
                    && board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }
}
