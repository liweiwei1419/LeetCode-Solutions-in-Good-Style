import java.util.Arrays;

/**
 * @author liweiwei1419
 * @date 2019/11/28 10:21 下午
 */
public class Solution {
    boolean solved;
    boolean[][] rows;
    boolean[][] cols;
    boolean[][] blocks;

    public void solveSudoku(char[][] board) {
        solved = false;
        rows = new boolean[9][10];
        cols = new boolean[9][10];
        blocks = new boolean[9][10];

        // 初始化
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                int block = (row / 3) * 3 + col / 3;
                int cellVal = board[row][col] - '0';
                rows[row][cellVal] = true;
                cols[col][cellVal] = true;
                blocks[block][cellVal] = true;
            }
        }
        dfs(board, 0, 0);
    }

    private void dfs(char[][] board, int row, int col) {
        if (row == 9) {
            solved = true;
            return;
        }

        if (board[row][col] != '.') {
            if (col < 8) {
                dfs(board, row, col + 1);
            } else {
                dfs(board, row + 1, 0);
            }
        } else {
            // 这个计算式很关键
            int block = (row / 3) * 3 + col / 3;

            // 尝试填写数字
            for (int i = 1; i <= 9; i++) {
                if (!rows[row][i] && !cols[col][i] && !blocks[block][i]) {
                    board[row][col] = (char) (i + '0');
                    rows[row][i] = true;
                    cols[col][i] = true;
                    blocks[block][i] = true;

                    if (col < 8) {
                        dfs(board, row, col + 1);
                    } else {
                        dfs(board, row + 1, 0);
                    }

                    if (!solved) {
                        board[row][col] = '.';
                        rows[row][i] = false;
                        cols[col][i] = false;
                        blocks[block][i] = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        Solution solution = new Solution();
        solution.solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
