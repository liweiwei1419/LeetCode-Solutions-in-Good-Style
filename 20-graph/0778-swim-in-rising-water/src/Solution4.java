import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution4 {

    // Dijkstra 算法（应用前提：没有负权边）

    public int swimInWater(int[][] grid) {
        int n = grid.length;

        Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> grid[a[0]][a[1]]));
        minHeap.offer(new int[]{0, 0});
        boolean[][] visited = new boolean[n][n];

        // distTo[i][j] 表示：到顶点 [i, j] 须要等待的最少的时间
        int[][] distTo = new int[n][n];
        for (int[] row : distTo) {
            Arrays.fill(row, n * n);
        }
        distTo[0][0] = grid[0][0];

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!minHeap.isEmpty()) {
            // 找最短
            int[] front = minHeap.poll();
            int currentX = front[0];
            int currentY = front[1];
            if (visited[currentX][currentY]) {
                continue;
            }

            // 确定
            visited[currentX][currentY] = true;
            if (currentX == n - 1 && currentY == n - 1) {
                return distTo[n - 1][n - 1];
            }

            for (int[] direction : directions) {
                int newX = currentX + direction[0];
                int newY = currentY + direction[1];
                // 更新
                if (inArea(newX, newY, n) && !visited[newX][newY] &&
                        Math.max(distTo[currentX][currentY], grid[newX][newY]) < distTo[newX][newY]) {
                    distTo[newX][newY] = Math.max(distTo[currentX][currentY], grid[newX][newY]);
                    minHeap.offer(new int[]{newX, newY});
                }
            }
        }
        return -1;
    }

    private boolean inArea(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}