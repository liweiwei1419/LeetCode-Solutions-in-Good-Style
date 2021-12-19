public class Solution4 {

    // 题解区代码 2，修改 grid 的写法

    private int rows;
    private int cols;
    private int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int[][] grid;

    public int closedIsland(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.grid = grid;
        for (int j = 0; j < cols; j++) {
            dfs(0, j);
            dfs(rows - 1, j);
        }
        for (int i = 1; i < rows - 1; i++) {
            dfs(i, 0);
            dfs(i, cols - 1);
        }

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int x, int y) {
        if (grid[x][y] == 1){
            return;
        }
        grid[x][y] = 1;
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (inArea(newX, newY)) {
                dfs(newX, newY);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}