import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {

    // 方法一：找单源最短路径：Dijkstra 算法（方法四也是）
    // 关键信息：在遇到墙壁前不会停止滚动
    // 解释清楚：为什么不用 visited 数组？

    public static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int rows;
    private int cols;

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        this.rows = maze.length;
        this.cols = maze[0].length;

        // 声明「距离矩阵」，求最短距离，声明成 -1 表示没有被计算
        int[][] distances = new int[rows][cols];
        for (int[] row : distances) {
            Arrays.fill(row, -1);
        }
        // 起始点的距离为 0
        distances[start[0]][start[1]] = 0;

        // 最小堆：按照距离排序，第 1 维：坐标（一维），第 2 维：距离
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.offer(new int[]{getIndex(start[0], start[1]), 0});

        while (!minHeap.isEmpty()) {
            int[] head = minHeap.poll();
            int x = head[0] / cols;
            int y = head[0] % cols;

            for (int[] direction : DIRECTIONS) {
                int newX = x;
                int newY = y;
                int count = 0;
                // 朝着 4 个方向都横冲直撞
                while (inArea(newX + direction[0], newY + direction[1]) && maze[newX + direction[0]][newY + direction[1]] == 0) {
                    newX = newX + direction[0];
                    newY = newY + direction[1];
                    count++;
                }

                // 此时 count 就是，从 (x, y) 到 (newX, newY) 的最短距离
                if (distances[newX][newY] == -1 || distances[newX][newY] > distances[x][y] + count) {
                    distances[newX][newY] = distances[x][y] + count;
                    if (newX != destination[0] || newY != destination[1]) {
                        minHeap.add(new int[]{getIndex(newX, newY), distances[x][y] + count});
                    }
                }
            }
        }
        return distances[destination[0]][destination[1]];
    }

    private int getIndex(int x, int y) {
        return x * cols + y;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}