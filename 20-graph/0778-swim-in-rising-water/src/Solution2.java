import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    private int N;

    public static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int swimInWater(int[][] grid) {
        this.N = grid.length;

        int left = 0;
        int right = N * N - 1;
        while (left < right) {
            int mid = (left + right) / 2;

            if (grid[0][0] <= mid && bfs(grid, mid)) {
                // mid 可以，尝试 mid 小一点是不是也可以呢？// [left, mid]
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    /**
     * 使用广度优先遍历得到从 (x, y) 开始向四个方向的所有小于等于 threshold 且与 (x, y) 连通的结点
     *
     * @param grid
     * @param threshold
     * @return
     */
    private boolean bfs(int[][] grid, int threshold) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            int x = front[0];
            int y = front[1];
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] <= threshold) {
                    if (newX == N - 1 && newY == N - 1) {
                        return true;
                    }

                    queue.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}