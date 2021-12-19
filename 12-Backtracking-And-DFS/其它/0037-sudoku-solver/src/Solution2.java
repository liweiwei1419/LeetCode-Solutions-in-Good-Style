import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    // 参考官方题解

    private boolean[][] row = new boolean[9][9];
    private boolean[][] col = new boolean[9][9];
    private boolean[][][] box = new boolean[3][3][9];
    /**
     * 所有空格的坐标列表
     */
    private List<int[]> spaces = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '0' - 1;
                    row[i][digit] = true;
                    col[j][digit] = true;
                    box[i / 3][j / 3][digit] = true;
                }
            }
        }
        dfs(board, 0);
    }

    /**
     * @param board
     * @param count 已经填写的 '.' 的数量
     * @return
     */
    public boolean dfs(char[][] board, int count) {
        if (count == spaces.size()) {
            return true;
        }

        int[] space = spaces.get(count);
        int i = space[0];
        int j = space[1];
        for (int digit = 0; digit < 9; ++digit) {
            if (row[i][digit] || col[j][digit] || box[i / 3][j / 3][digit]) {
                continue;
            }
            row[i][digit] = true;
            col[j][digit] = true;
            box[i / 3][j / 3][digit] = true;

            board[i][j] = (char) (digit + '0' + 1);
            if (dfs(board, count + 1)) {
                return true;
            }

            // 可以不重置，因为后面再填写的时候会覆盖
            // board[i][j] = '.';
            row[i][digit] = false;
            col[j][digit] = false;
            box[i / 3][j / 3][digit] = false;
        }
        return false;
    }
}