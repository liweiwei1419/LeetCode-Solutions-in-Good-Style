import java.util.ArrayList;
import java.util.List;

public class Solution {

    // 方法一：深度优先遍历

    private int[][] directions = new int[][]{{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
    private int rows;
    private int cols;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        this.rows = matrix.length;
        if (rows == 0) {
            return res;
        }
        this.cols = matrix[0].length;
        // 太平洋 Pacific
        boolean[][] canReachP = new boolean[rows][cols];
        // 大西洋 Atlantic
        boolean[][] canReachA = new boolean[rows][cols];

        // 四周执行 dfs，注意：看图区分行和列、太平洋和大西洋
        for (int j = 0; j < cols; j++) {
            dfs(matrix, canReachP, 0, j);
        }
        for (int i = 1; i < rows; i++) {
            dfs(matrix, canReachP, i, 0);
        }
        for (int i = 0; i < rows; i++) {
            dfs(matrix, canReachA, i, cols - 1);
        }
        for (int j = 0; j < cols - 1; j++) {
            dfs(matrix, canReachA, rows - 1, j);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (canReachP[i][j] && canReachA[i][j]) {
                    List<Integer> point = new ArrayList<>();
                    point.add(i);
                    point.add(j);
                    res.add(point);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, boolean[][] canReach, int x, int y) {
        canReach[x][y] = true;
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (inArea(newX, newY) && !canReach[newX][newY] && matrix[x][y] <= matrix[newX][newY]) {
                dfs(matrix, canReach, newX, newY);
            }
        }

    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}