import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    private int rows;
    private int cols;

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minimumEffortPath(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        if (rows == 1 && cols == 1) {
            return 0;
        }

        int left = 0;
        int right = 999999;
        while (left < right) {
            // 不会溢出，因此不用写成 left + (right - left) / 2
            int mid = (left + right) / 2;

            boolean[][] visited = new boolean[rows][cols];
            if (bfs(heights, mid, 0, 0, visited)) {
                // mid 是符合要求的，下一轮搜索区间 [left, mid]
                right = mid;
            } else {
                // 下一轮搜索区间 [mid + 1, right]
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 如果遍历到的路径的所有路径差都小于等于 diff，返回 true
     *
     * @param heights
     * @param diff
     * @param x
     * @param y
     * @param visited
     * @return
     */
    private boolean bfs(int[][] heights, int diff, int x, int y, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            for (int[] direction : DIRECTIONS) {
                int newX = front[0] + direction[0];
                int newY = front[1] + direction[1];

                if (inArea(newX, newY) && !visited[newX][newY] && Math.abs(heights[newX][newY] - heights[front[0]][front[1]]) <= diff) {
                    if (newX == rows - 1 && newY == cols - 1) {
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
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}