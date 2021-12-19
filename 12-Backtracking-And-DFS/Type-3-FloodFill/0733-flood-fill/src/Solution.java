public class Solution {

    // 方法一：深度优先遍历

    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int rows;
    private int cols;
    private int[][] image;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // 前面这个特殊的判断很重要
        int originColor = image[sr][sc];
        if (originColor == newColor) {
            return image;
        }

        this.rows = image.length;
        this.cols = image[0].length;
        this.image = image;
        // 从一个结点开始进行深度优先遍历
        dfs(sr, sc, originColor, newColor);
        return image;
    }

    private void dfs(int i, int j, int originColor, int newColor) {
        image[i][j] = newColor;
        for (int[] direction : DIRECTIONS) {
            int newX = i + direction[0];
            int newY = j + direction[1];
            if (inArea(newX, newY, rows, cols) && image[newX][newY] == originColor) {
                dfs(newX, newY, originColor, newColor);
            }
        }
    }

    private boolean inArea(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}