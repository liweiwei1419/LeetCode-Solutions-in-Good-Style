import java.util.ArrayDeque;
import java.util.Queue;

public class Solution2 {

    // 方法二：修改 grid 的写法
    // 参考资料：https://leetcode-cn.com/problems/as-far-from-land-as-possible/solution/jian-dan-java-miao-dong-tu-de-bfs-by-sweetiee/

    public int maxDistance(int[][] grid) {
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<int[]> queue = new ArrayDeque<>();
        int N = grid.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        boolean hasOcean = false;
        int[] point = null;
        while (!queue.isEmpty()) {
            point = queue.poll();
            int x = point[0];
            int y = point[1];
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (isArea(newX, newY, N) && grid[newX][newY] == 0) {
                    // 这里我直接修改了原数组，因此就不需要额外的数组来标志是否访问
                    grid[newX][newY] = grid[x][y] + 1;
                    // 有海洋
                    hasOcean = true;
                    queue.offer(new int[]{newX, newY});
                }
            }

        }
        if (point == null || !hasOcean) {
            return -1;
        }

        // 返回最后一次遍历到的海洋的距离。
        return grid[point[0]][point[1]] - 1;
    }

    private boolean isArea(int X, int Y, int N) {
        return X >= 0 && X < N && Y >= 0 && Y < N;
    }
}