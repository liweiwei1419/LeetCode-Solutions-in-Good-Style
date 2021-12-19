import java.util.LinkedList;
import java.util.Queue;

public class Solution4 {

    // 方法二：广度优先遍历（使用一维坐标）

    private final static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[] visited = new boolean[rows * cols];

        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[getIndex(i, j, cols)]) {
                    maxArea = Math.max(maxArea, bfs(grid, i, j, rows, cols, visited));
                }
            }
        }
        return maxArea;
    }

    private int bfs(int[][] grid, int i, int j, int rows, int cols, boolean[] visited) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        int index = getIndex(i, j, cols);
        queue.offer(index);
        visited[index] = true;
        while (!queue.isEmpty()) {
            int front = queue.poll();
            int curX = front / cols;
            int curY = front % cols;
            count++;
            for (int[] direction : DIRECTIONS) {
                int newX = curX + direction[0];
                int newY = curY + direction[1];

                int newIndex = getIndex(newX, newY, cols);
                if (inArea(newX, newY, rows, cols) && grid[newX][newY] == 1 && !visited[newIndex]) {
                    queue.offer(newIndex);
                    visited[newIndex] = true;
                }
            }
        }
        return count;
    }


    private int getIndex(int x, int y, int cols) {
        return x * cols + y;
    }

    private boolean inArea(int i, int j, int rows, int cols) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }
}