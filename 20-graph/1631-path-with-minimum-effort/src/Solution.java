import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    // 二分查找 + BFS

    private int rows;
    private int cols;

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minimumEffortPath(int[][] heights) {
        this.rows = heights.length;
        this.cols = heights[0].length;
        if (rows == 1 && cols == 1) {
            return 0;
        }

        int left = 0;
        int right = 999999;
        int size = rows * cols;

        while (left < right) {
            int mid = (left + right) / 2;
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, 0});

            boolean[] visited = new boolean[size];
            visited[0] = true;
            while (!queue.isEmpty()) {
                int[] front = queue.poll();
                int currentX = front[0];
                int currentY = front[1];
                for (int[] direction : DIRECTIONS) {
                    int newX = currentX + direction[0];
                    int newY = currentY + direction[1];
                    if (inArea(newX, newY) && !visited[newX * cols + newY] && Math.abs(heights[currentX][currentY] - heights[newX][newY]) <= mid) {
                        queue.offer(new int[]{newX, newY});
                        visited[newX * cols + newY] = true;
                    }
                }
            }

            if (visited[size - 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}