import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution5 {

    public static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int rows;
    private int cols;

    public int minimumEffortPath(int[][] heights) {
        this.rows = heights.length;
        this.cols = heights[0].length;
        int size = rows * cols;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(edge -> edge[2]));
        boolean[][] visited = new boolean[rows][cols];
        minHeap.offer(new int[]{0, 0, 0});

        int[] dist = new int[size];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        while (!minHeap.isEmpty()) {
            int[] front = minHeap.poll();
            int currentX = front[0];
            int currentY = front[1];
            int value = front[2];

            if (visited[currentX][currentY]) {
                continue;
            }

            visited[currentX][currentY] = true;
            if (currentX == rows - 1 && currentY == cols - 1) {
                return dist[size - 1];
            }

            for (int[] direction : DIRECTIONS) {
                int newX = currentX + direction[0];
                int newY = currentY + direction[1];
                if (inArea(newX, newY) && Math.max(value, Math.abs(heights[currentX][currentY] - heights[newX][newY])) < dist[newX * cols + newY]) {
                    dist[newX * cols + newY] = Math.max(value, Math.abs(heights[currentX][currentY] - heights[newX][newY]));
                    minHeap.offer(new int[]{newX, newY, dist[newX * cols + newY]});
                }
            }
        }
        return -1;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}