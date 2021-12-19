public class Solution {

    // 二分查找 + DFS

    private int rows;
    private int cols;

    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minimumEffortPath(int[][] heights) {
        rows = heights.length;
        cols = heights[0].length;
        if (rows == 1 && cols == 1) {
            return 0;
        }

        // 1 <= heights[i][j] <= 10^6
        int left = 0;
        int right = 999999;
        while (left < right) {
            // 不会溢出，因此不用写成 left + (right - left) / 2
            int mid = (left + right) / 2;

            boolean[][] visited = new boolean[rows][cols];
            if (dfs(heights, mid, 0, 0, visited)) {
                // mid 是符合要求的，下一轮搜索区间 [left, mid]
                right = mid;
            } else {
                // 下一轮搜索区间 [mid + 1, right]
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 如果遍历到的路径的所有路径差都小于等于 diff，返回 true
     *
     * @param heights
     * @param diff
     * @param x
     * @param y
     * @param visited
     * @return
     */
    private boolean dfs(int[][] heights, int diff, int x, int y, boolean[][] visited) {
        visited[x][y] = true;
        for (int[] direction : DIRECTIONS) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            // 只要扩展下去，有一个方向的的单元格数值与当前单元格数值的绝对值 <= diff ，就继续深度优先遍历
            if (inArea(newX, newY) && !visited[newX][newY] && Math.abs(heights[newX][newY] - heights[x][y]) <= diff) {
                // 递归终止条件：走到了最后一个单元格
                if (newX == rows - 1 && newY == cols - 1) {
                    return true;
                }
                if (dfs(heights, diff, newX, newY, visited)) {
                    return true;
                }
            }
        }
        // 4 个方向深搜完以后，发现都有 > diff 的路径，才返回 false
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}