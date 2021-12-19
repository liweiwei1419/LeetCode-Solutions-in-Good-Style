public class Solution {

    // 方法一：深度优先遍历

    private int rows;
    private int cols;
    private int[][] grid;
    private boolean[][] visited;
    private final static int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int numEnclaves(int[][] A) {
        this.rows = A.length;
        this.cols = A[0].length;

        grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = A[i][j];
            }
        }


        this.visited = new boolean[rows][cols];
        // 把与边界相连的 1 改成 0

        for (int j = 0; j < cols; j++) {
            if (grid[0][j] == 1) {
                dfs(0, j);
            }
            if (grid[rows - 1][j] == 1) {
                dfs(rows - 1, j);
            }
        }
        for (int i = 1; i < rows - 1; i++) {
            if (grid[i][0] == 1) {
                dfs(i, 0);
            }
            if (grid[i][cols - 1] == 1) {
                dfs(i, cols - 1);
            }
        }

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int x, int y) {

        visited[x][y] = true;
        grid[x][y] = 0;
        for (int[] direction : DIRECTIONS) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] == 1) {
                dfs(newX, newY);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}