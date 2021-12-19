import java.util.Arrays;

public class Solution2 {

    // 方法二：深度优先遍历

    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int rows;
    private int cols;
    private int[][] maze;

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        rows = maze.length;
        if (rows == 0) {
            return -1;
        }
        cols = maze[0].length;
        this.maze = maze;

        int[][] distances = new int[rows][cols];
        for (int[] row : distances) {
            Arrays.fill(row, -1);
        }
        distances[start[0]][start[1]] = 0;
        dfs(start, distances);
        return distances[destination[0]][destination[1]];
    }

    public void dfs(int[] cur, int[][] dist) {
        for (int i = 0; i < 4; i++) {
            int x = cur[0];
            int y = cur[1];
            int count = 0;
            while (inArea(x + directions[i][0], y + directions[i][1]) && maze[x + directions[i][0]][y + directions[i][1]] == 0) {
                x = x + directions[i][0];
                y = y + directions[i][1];
                count++;
            }
            if (dist[x][y] == -1 || dist[x][y] > dist[cur[0]][cur[1]] + count) {
                dist[x][y] = dist[cur[0]][cur[1]] + count;
                dfs(new int[]{x, y}, dist);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}