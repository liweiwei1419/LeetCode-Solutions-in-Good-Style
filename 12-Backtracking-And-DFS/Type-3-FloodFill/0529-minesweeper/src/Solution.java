public class Solution {

    // 方法一：深度优先遍历

    // M 地雷
    // E 还未挖出的空方块
    // B 已经挖出的空方块

    /**
     * 相邻关系规定为：8 个方向
     */
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    private int rows;
    private int cols;

    public char[][] updateBoard(char[][] board, int[] click) {
        this.rows = board.length;
        this.cols = board[0].length;

        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            // 规则 1
            board[x][y] = 'X';
            return board;
        }
        dfs(board, x, y);
        return board;
    }

    public void dfs(char[][] board, int x, int y) {
        // 相邻地雷的数量
        int count = 0;
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (inArea(newX, newY) && board[newX][newY] == 'M') {
                count++;
            }
        }
        if (count > 0) {
            // 规则 3
            board[x][y] = (char) (count + '0');
        } else {
            // 规则 2：如果当前位置没有地雷，将它修改为 B
            board[x][y] = 'B';
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (inArea(newX, newY) && board[newX][newY] == 'E') {
                    dfs(board, newX, newY);
                }
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}