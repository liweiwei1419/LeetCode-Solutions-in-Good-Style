public class Solution {

    private char[][] grid;
    private int cols;
    private int rows;

    private boolean[][] visited;
    private int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // 方法一：DFS

    public boolean containsCycle(char[][] grid) {
        if (grid.length == 0) {
            return false;
        }
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && dfs(new int[]{i, j}, null)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean dfs(int[] current, int[] pre) {
        if (visited[current[0]][current[1]]) {
            return true;
        }

        boolean res = false;
        visited[current[0]][current[1]] = true;
        char target = grid[current[0]][current[1]];

        for (int[] dir : directions) {
            int nextX = current[0] + dir[0];
            int nextY = current[1] + dir[1];
            if (inArea(nextX, nextY)
                    && grid[nextX][nextY] == target
                    && (pre == null || nextX != pre[0] || nextY != pre[1])) {
                res = dfs(new int[]{nextX, nextY}, current);
            }
            if (res) {
                break;
            }
        }
        return res;
    }

    private boolean inArea(int x, int y) {
        return 0 <= x && x < rows && 0 <= y && y < cols;
    }

    private int getIndex(int x, int y) {
        return x * cols + y;
    }
}
