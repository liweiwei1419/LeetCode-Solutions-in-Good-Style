public class Solution {

    // 参考资料：https://leetcode-cn.com/problems/check-if-there-is-a-valid-path-in-a-grid/solution/cdfsjie-fa-rong-yi-li-jie-dai-ma-duan-zhu-shi-duo-/

    /**
     * 0 下、1 右、2 上、3 左
     */
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    public boolean hasValidPath(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        // 起点的拼图编号
        int start = grid[0][0];

        // 朝着四个方向都试一下
        for (int i = 0; i < 4; ++i) {
            // 当前方向可以走
            if (pipe[start][i] != -1) {
                if (dfs(0, 0, pipe[start][i], grid)) {
                    return true;
                }
            }
        }
        return false;
    }

    private int m;
    private int n;

    /**
     * 总共就 6 种拼图，所以下标到 6
     */
    int[][] pipe = {
            {-1, -1, -1, -1},
            {-1, 1, -1, 3},
            {0, -1, 2, -1},
            {-1, 0, 3, -1},
            {-1, -1, 1, 0},
            {3, 2, -1, -1},
            {1, -1, -1, 2}
    };

    /**
     * 记录各个拼图块路径的方向，0、1、2、3代表方向，-1 代表不可走
     */
    private boolean[][] visited;

    private boolean dfs(int x, int y, int dir, int[][] grid) {
        visited[x][y] = true;
        if (x == m - 1 && y == n - 1) {
            // 到达终点
            return true;
        }

        // 得到下一个准备走的坐标
        int newX = x + dx[dir];
        int newY = y + dy[dir];
        if (newX < 0 || newY < 0 || newX >= m || newY >= n) {
            // 越界
            return false;
        }
        // 得到下一块拼图的编号
        int nxt = grid[newX][newY];
        if (pipe[nxt][dir] != -1 && !visited[newX][newY]) {
            // 如果当前方向可走，则方向改变，继续走
            return dfs(newX, newY, pipe[nxt][dir], grid);
        }
        return false;
    }
}