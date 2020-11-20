import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    // 方法二：广度优先遍历

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int originColor = image[sr][sc];
        if (originColor == newColor) {
            return image;
        }
        int rows = image.length;
        int cols = image[0].length;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        // 从一个结点开始进行深度优先遍历
        queue.offer(new int[]{sr, sc});
        visited[sr][sc] = true;
        while (!queue.isEmpty()) {
            int[] head = queue.poll();
            image[head[0]][head[1]] = newColor;
            for (int[] direction : directions) {
                int newX = head[0] + direction[0];
                int newY = head[1] + direction[1];
                if (inArea(newX, newY, rows, cols) && !visited[newX][newY] && image[newX][newY] == originColor) {
                    queue.offer(new int[]{newX, newY});
                    // 特别注意：添加到队列以后，需要马上标记为已经访问，否则相同结点会重复入队
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