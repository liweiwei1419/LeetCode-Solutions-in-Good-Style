public class Solution {

    // 方法一：深度优先遍历 flood fill

    private int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int rows;
    private int cols;
    private int[][] grid;
    private boolean[][] visited;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        cols = grid[0].length;
        if (cols == 0) {
            return 0;
        }

        this.grid = grid;
        this.visited = new boolean[rows][cols];
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    res = Math.max(res, dfs(i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int x, int y) {
        visited[x][y] = true;
        int res = 1;
        for (int[] direction:directions) {
            int nextX = x + direction[0];
            int nextY = y + direction[1];
            if (inArea(nextX, nextY) && grid[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                res += dfs(nextX, nextY);
            }
        }
        return res;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}