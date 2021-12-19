import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution3 {

    // 方法三：广度优先遍历

    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int rows;
    private int cols;

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        rows = maze.length;
        if (rows == 0) {
            return -1;
        }
        cols = maze[0].length;
        int[][] dist = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(dist[i], -1);
        }
        dist[start[0]][start[1]] = 0;
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int[] head = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = head[0];
                int y = head[1];
                int count = 0;
                while (inArea(x + directions[i][0], y + directions[i][1]) && maze[x + directions[i][0]][y + directions[i][1]] == 0) {
                    x = x + directions[i][0];
                    y = y + directions[i][1];
                    count++;
                }
                if (dist[x][y] == -1 || dist[x][y] > (dist[head[0]][head[1]] + count)) {
                    dist[x][y] = dist[head[0]][head[1]] + count;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return dist[destination[0]][destination[1]];
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}