import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        // 新鲜橘子的个数
        int count = 0;
        // 初始化的时候，把腐烂的橘子加入队列
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                } else if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        int step = 0;
        while (!queue.isEmpty()) {
            // 如果当前没有新鲜的橘子，就没有可以扩散的区域了
            if (count == 0) {
                break;
            }
            step++;
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                int[] front = queue.poll();
                int x = front[0];
                int y = front[1];
                for (int[] direction : directions) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];
                    if (inArea(newX, newY, rows, cols) && !visited[newX][newY] && grid[newX][newY] == 1) {
                        count--;
                        queue.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
        }

        if (count > 0) {
            // 此时说明，好的橘子是一个「孤岛」，不会被坏橘子污染到
            return -1;
        }
        return step;
    }


    private boolean inArea(int i, int j, int rows, int cols) {
        return 0 <= i && i < rows && 0 <= j && j < cols;
    }
}