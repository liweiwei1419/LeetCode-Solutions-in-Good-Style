import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    // 方法二：广度优先遍历

    private int rows;
    private int cols;
    private int[][] grid;
    private int origin;
    public static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.grid = grid;
        if (grid[r0][c0] == color) {
            return grid;
        }

        this.origin = grid[r0][c0];
        boolean[][] visited = new boolean[rows][cols];
        visited[r0][c0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r0, c0});

        while (!queue.isEmpty()) {
            int[] top = queue.poll();

            // 注意区分：x、y 表示当前坐标，newX 、newY 表示扩散了一步以后的新坐标
            int x = top[0];
            int y = top[1];
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (inArea(newX, newY)) {
                    if (visited[newX][newY]) {
                        continue;
                    }
                    // 情况 2：如果扩散了一步以后还是 origin ，继续递归求解
                    if (grid[newX][newY] == origin) {
                        queue.add(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    } else {
                        // 情况 3：如果扩散了一步以后还是不是 origin，当前单元格变色
                        grid[x][y] = color;
                    }
                } else {
                    // 情况 1：如果向四个方向走一步越界了，说明当前单元格是边界，当前颜色修改
                    grid[x][y] = color;
                }
            }
        }
        return grid;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}