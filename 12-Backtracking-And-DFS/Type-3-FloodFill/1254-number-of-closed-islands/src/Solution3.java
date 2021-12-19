public class Solution3 {

    // 题解区代码，修改 grid 的写法

    private int rows;
    private int cols;
    private int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int[][] grid;

    public int closedIsland(int[][] grid) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.grid = grid;
        int count = 0;
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (this.grid[i][j] == 0) {
                    if (dfs(i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }


    private boolean dfs(int x, int y) {
        if (!inArea(x, y)) {
            return false;
        }
        if (grid[x][y] == 1) {
            return true;
        }
        grid[x][y] = 1;
        boolean up = dfs(x - 1, y);
        boolean down = dfs(x + 1, y);
        boolean left = dfs(x, y - 1);
        boolean right = dfs(x, y + 1);
        return up && down && left && right;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}