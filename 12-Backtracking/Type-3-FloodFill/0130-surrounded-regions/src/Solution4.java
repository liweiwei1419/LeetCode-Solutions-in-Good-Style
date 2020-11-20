public class Solution4 {

    // 参考资料：https://zhuanlan.zhihu.com/p/189500715

    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int n = board.length, m = board[0].length;
        // 第 1 步：四周向中间搜
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!inAround(i, j, n, m)) {
                    continue;
                }
                if (board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        // 第 2 步：遍历图，更新结果
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y) {
        // 保证当前点在图中
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return;
        }
        if (board[x][y] != 'O') {
            return;
        }
        board[x][y] = '*';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }

    /**
     * 是否在四周
     *
     * @param x
     * @param y
     * @param n
     * @param m
     * @return
     */
    public boolean inAround(int x, int y, int n, int m) {
        return x == 0 || y == 0 || x == n - 1 || y == m - 1;
    }
}