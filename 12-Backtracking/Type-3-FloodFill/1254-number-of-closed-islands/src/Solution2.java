import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    // 0 表示陆地，1 表示海洋
    // 方法二：广度优先遍历

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
        Queue<int[]> queue = new LinkedList<>();
        // 第 1 步：先把四周的 0 全部改成 1
        for (int j = 0; j < cols; j++) {
            if (grid[0][j] == 0) {
                queue.offer(new int[]{0, j});
                visited[0][j] = true;
            }
            if (grid[rows - 1][j] == 0) {
                queue.offer(new int[]{rows - 1, j});
                visited[rows - 1][j] = true;
            }
        }
        for (int i = 1; i < rows - 1; i++) {
            if (grid[i][0] == 0) {
                queue.offer(new int[]{i, 0});
                visited[i][0] = true;
            }
            if (grid[i][cols - 1] == 0) {
                queue.offer(new int[]{i, cols - 1});
                visited[i][cols - 1] = true;
            }
        }

        bfs(queue);
        // 第 2 步：然后对有 0 的地方执行一次 flood fill
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                    bfs(queue);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            int x = top[0];
            int y = top[1];
            visited[x][y] = true;
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] == 0) {
                    queue.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}