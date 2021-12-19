import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {

    // 方法二：深度优先遍历（显式使用栈）

    private final static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];

        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j, rows, cols, visited));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j, int rows, int cols, boolean[][] visited) {
        int count = 0;
        Deque<int[]> stack = new ArrayDeque<>();
        stack.addLast(new int[]{i, j});
        visited[i][j] = true;
        while (!stack.isEmpty()) {
            int[] top = stack.removeLast();
            int curX = top[0];
            int curY = top[1];
            count++;
            for (int[] direction : DIRECTIONS) {
                int newX = curX + direction[0];
                int newY = curY + direction[1];
                if (inArea(newX, newY, rows, cols) && grid[newX][newY] == 1 && !visited[newX][newY]) {
                    stack.addLast(new int[]{newX, newY});
                    visited[newX][newY] = true;
                }
            }
        }
        return count;
    }

    private boolean inArea(int i, int j, int rows, int cols) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }
}