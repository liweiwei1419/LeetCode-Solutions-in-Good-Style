import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    // 方法一：广度优先遍历
    // 思路：把所有的陆地添加到队列中，进行广度优先遍历，看看多少步可以扩散完成

    public int maxDistance(int[][] grid) {
        // 方向向量
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // 由于题目中给出了 grid 的范围，因此不用做输入检查
        int N = grid.length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    // 把陆地添加到队列中
                    queue.add(getIndex(i, j, N));
                }
            }
        }

        int size = queue.size();
        if (size == 0 || size == N * N) {
            return -1;
        }

        boolean[][] visited = new boolean[N][N];

        int step = 0;
        while (!queue.isEmpty()) {
            // 注意：先把当前队列的长度保存下来
            int currentQueueSize = queue.size();
            for (int i = 0; i < currentQueueSize; i++) {
                Integer head = queue.poll();
                int currentX = head / N;
                int currentY = head % N;

                for (int[] direction : directions) {
                    int newX = currentX + direction[0];
                    int newY = currentY + direction[1];
                    if (inArea(newX, newY, N) && !visited[newX][newY] && grid[newX][newY] == 0) {
                        // 赋值成为一个不等于 0 的整数均可，因为后续逻辑只关心海洋（0）
                        visited[newX][newY] = true;
                        queue.add(getIndex(newX, newY, N));
                    }
                }
            }
            step++;
        }
        // 注意：由于最后一步，没有可以扩散的的区域，但是 step 加了 1，故在退出循环的时候应该减 1
        return step - 1;
    }

    /**
     * @param x    二维表格单元格横坐标
     * @param y    二维表格单元格纵坐标
     * @param cols 二维表格列数
     * @return
     */
    private int getIndex(int x, int y, int cols) {
        return x * cols + y;
    }

    /**
     * @param x 二维表格单元格横坐标
     * @param y 二维表格单元格纵坐标
     * @param N 二维表格行数（列数）
     * @return 是否在二维表格有效范围内
     */
    private boolean inArea(int x, int y, int N) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }
}