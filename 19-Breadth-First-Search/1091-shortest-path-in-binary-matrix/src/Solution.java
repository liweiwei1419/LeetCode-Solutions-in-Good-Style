import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private int len;

    private static final int[][] DIRECTIONS = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        this.len = grid.length;
        if (grid[0][0] == 1) {
            return -1;
        }
        if (len == 1) {
            return len;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        boolean[][] visited = new boolean[len][len];
        visited[0][0] = true;
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                int[] top = queue.poll();
                int curX = top[0];
                int curY = top[1];

                for (int[] direction : DIRECTIONS) {
                    int newX = curX + direction[0];
                    int newY = curY + direction[1];

                    // 剪枝
                    if (inArea(newX, newY) && !visited[newX][newY] && grid[newX][newY] == 0) {
                        if (newX == len - 1 && newY == len - 1) {
                            return depth;
                        }

                        queue.add(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
            }
        }
        return -1;
    }

    private int getIndex(int x, int y) {
        return x * len + y;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < len && y >= 0 && y < len;
    }
}
