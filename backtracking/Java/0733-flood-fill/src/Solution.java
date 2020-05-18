import java.util.Arrays;

public class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // 前面这个特殊的判断很重要
        int currentColor = image[sr][sc];
        if (currentColor == newColor) {
            return image;
        }

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int rows = image.length;
        int cols = image[0].length;
        dfs(image, sr, sc, rows, cols, directions, currentColor, newColor);
        return image;
    }

    private void dfs(int[][] image,
                     int i,
                     int j,
                     int rows,
                     int cols,
                     int[][] directions,
                     int currentColor,
                     int newColor) {
        image[i][j] = newColor;
        for (int k = 0; k < 4; k++) {
            int newX = i + directions[k][0];
            int newY = j + directions[k][1];
            if (inArea(newX, newY, rows, cols) && image[newX][newY] == currentColor) {
                dfs(image, newX, newY, rows, cols, directions, currentColor, newColor);
            }
        }
    }

    private boolean inArea(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public static void main(String[] args) {
//        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
//        int sr = 1;
//        int sc = 1;
//        int newColor = 2;
        int[][] image = {{0, 0, 0}, {0, 1, 1}};
        int sr = 1;
        int sc = 1;
        int newColor = 1;
        Solution solution = new Solution();
        int[][] res = solution.floodFill(image, sr, sc, newColor);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
