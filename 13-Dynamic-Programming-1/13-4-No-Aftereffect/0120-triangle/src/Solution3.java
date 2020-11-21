import java.util.Arrays;
import java.util.List;

public class Solution3 {

    // 记忆化递归

    private Integer[][] memo;

    public int minimumTotal(List<List<Integer>> triangle) {
        int N = triangle.size();
        memo = new Integer[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(memo[i], -1);

        }
        return dfs(triangle, 0, 0);
    }

    /**
     * 以 (row, col) 为顶点的三角形的最小路径和
     *
     * @param triangle
     * @param row
     * @param col
     * @return
     */
    private int dfs(List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.size()) {
            return 0;
        }
        if (memo[row][col] != null) {
            return memo[row][col];
        }
        return memo[row][col] = Math.min(dfs(triangle, row + 1, col),
                dfs(triangle, row + 1, col + 1))
                + triangle.get(row).get(col);
    }
}