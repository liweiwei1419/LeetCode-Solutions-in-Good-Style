import java.util.Arrays;

public class Solution4 {

    public void solveSudoku(char[][] board) {
        dfs(board, 0);
    }

    private boolean dfs(char[][] board, int d) {
        if (d == 81) {
            return true; //found solution
        }
        int i = d / 9, j = d % 9;
        if (board[i][j] != '.') {
            return dfs(board, d + 1);//prefill number skip
        }

        boolean[] flag = new boolean[10];
        validate(board, i, j, flag);
        for (int k = 1; k <= 9; k++) {
            if (flag[k]) {
                board[i][j] = (char) ('0' + k);
                if (dfs(board, d + 1)) {
                    return true;
                }
            }
        }
        board[i][j] = '.'; //if can not solve, in the wrong path, change back to '.' and out
        return false;
    }

    private void validate(char[][] board, int i, int j, boolean[] flag) {
        Arrays.fill(flag, true);
        for (int k = 0; k < 9; k++) {
            if (board[i][k] != '.') {
                flag[board[i][k] - '0'] = false;
            }
            if (board[k][j] != '.') {
                flag[board[k][j] - '0'] = false;
            }
            int r = i / 3 * 3 + k / 3;
            int c = j / 3 * 3 + k % 3;
            if (board[r][c] != '.') {
                flag[board[r][c] - '0'] = false;
            }
        }
    }
}
