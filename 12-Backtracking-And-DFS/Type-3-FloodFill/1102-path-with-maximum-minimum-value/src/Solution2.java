import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    private int rows;
    private int cols;

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int maximumMinimumPath(int[][] A) {
        if (A[0][0] == 0) {
            return 0;
        }

        this.rows = A.length;
        this.cols = A[0].length;
        int left = 0;
        int right = Math.min(A[0][0], A[rows - 1][cols - 1]);
        while (left < right) {
            // 不会溢出，因此不用写成 left + (right - left) / 2
            int mid = (left + right + 1) / 2;

            boolean[][] visited = new boolean[rows][cols];
            if (bfs(A, 0, 0, visited, mid)) {
                // 答案至少是 mid，下一轮搜索区间在 [mid, right]
                left = mid;
            } else {
                // 下一轮搜索区间在 [left, mid - 1]
                right = mid - 1;
            }
        }
        return left;
    }


    /**
     * @param A
     * @param x
     * @param y
     * @param visited
     * @param threshold
     * @return 从 A[x][y] 开始进行深度优先遍历的所有结点的值都大于等于 threshold
     */
    private boolean bfs(int[][] A, int x, int y, boolean[][] visited, int threshold) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            for (int[] direction : DIRECTIONS) {
                int newX = front[0] + direction[0];
                int newY = front[1] + direction[1];
                if (inArea(newX, newY) && !visited[newX][newY] && A[newX][newY] >= threshold) {
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