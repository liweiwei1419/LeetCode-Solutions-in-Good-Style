import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution4 {

    // 方法一：Dijkstra 算法（2021 年 1 月 28 日通过）

    private int rows;
    private int cols;

    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        this.rows = maze.length;
        this.cols = maze[0].length;

        int[][] distance = new int[rows][cols];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        distance[start[0]][start[1]] = 0;
        dijkstra(maze, start, distance);
        return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];
    }

    /**
     * 通过 dijkstra 算法求解没有负权边的单源最短路径
     *
     * @param maze
     * @param start
     * @param distance
     */
    public void dijkstra(int[][] maze, int[] start, int[][] distance) {
        int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        // 没有用 visited 数组，这是因为这里不能用
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        queue.offer(new int[]{start[0], start[1], 0});

        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            if (distance[front[0]][front[1]] < front[2]) {
                continue;
            }
            for (int[] dir : dirs) {
                int x = front[0] + dir[0];
                int y = front[1] + dir[1];

                // 这一步设计的 count 非常有用，这是抽象出带权图
                int count = 0;
                while (inArea(x,y) && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    count++;
                }

                // 细节
                if (distance[front[0]][front[1]] + count < distance[x - dir[0]][y - dir[1]]) {
                    // 记得退一格
                    distance[x - dir[0]][y - dir[1]] = distance[front[0]][front[1]] + count;
                    // 记得退一格
                    queue.offer(new int[]{x - dir[0], y - dir[1], distance[x - dir[0]][y - dir[1]]});
                }
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}