public class Solution {

    // 0 表示陆地，1 表示海洋
    // 方法一：深度优先遍历
    private int rows;
    private int cols;
    private final static int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int[][] grid;
    private boolean[][] visited;

    public int closedIsland(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.grid = grid;

        visited = new boolean[rows][cols];
        // 第 1 步：先把四周的 0 全部改成 1
        for (int j = 0; j < cols; j++) {
            if (grid[0][j] == 0) {
                dfs(0, j);
            }
            if (grid[rows - 1][j] == 0) {
                dfs(rows - 1, j);
            }
        }
        for (int i = 1; i < rows - 1; i++) {
            if (grid[i][0] == 0) {
                dfs(i, 0);
            }
            if (grid[i][cols - 1] == 0) {
                dfs(i, cols - 1);
            }
        }

        // 第 2 步：然后对有 0 的地方执行一次 flood fill
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int x, int y) {
        visited[x][y] = true;
        for (int[] direction : DIRECTIONS) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] == 0) {
                dfs(newX, newY);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}