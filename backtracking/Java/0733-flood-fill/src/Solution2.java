import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) {
            return image;
        }

        int rows = image.length;
        int cols = image[0].length;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{sr, sc});
        visited[sr][sc] = true;

        while (!queue.isEmpty()) {
            int[] head = queue.poll();
            image[head[0]][head[1]] = newColor;

            for (int i = 0; i < 4; i++) {
                int newX = head[0] + directions[i][0];
                int newY = head[1] + directions[i][1];

                if (inArea(newX, newY, rows, cols) && !visited[newX][newY] && image[newX][newY] == oldColor) {
                    queue.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        return image;
    }

    private boolean inArea(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
