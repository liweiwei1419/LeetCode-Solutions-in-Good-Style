import java.util.LinkedList;
import java.util.Queue;


public class Solution {

    // 广度优先遍历

    public int[][] updateMatrix(int[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return new int[0][0];
        }
        int cols = matrix[0].length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    // 从为 0 的地方开始向外扩散
                    queue.add(getIndex(i, j, cols));
                } else {
                    // 设置成一个特殊值，说明当前这个坐标的位置还没有被扩散到
                    matrix[i][j] = -1;
                }
            }
        }

        int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        // 从为 0 的地方开始进行广度优先遍历
        while (!queue.isEmpty()) {
            // 当前的位置，一开始的时候，"0" 正好，到"0" 的距离也是 0 ，符合题意
            Integer head = queue.poll();

            int currentX = head / cols;
            int currentY = head % cols;

            // 现在要往 4 个方向扩散
            for (int i = 0; i < 4; i++) {
                int newX = currentX + directions[i][0];
                int newY = currentY + directions[i][1];
                // 在有效的坐标范围内，并且还没有被访问过
                if (inArea(newX, newY, rows, cols) && matrix[newX][newY] == -1) {
                    matrix[newX][newY] = matrix[currentX][currentY] + 1;
                    queue.add(getIndex(newX, newY, cols));
                }
            }
        }
        return matrix;
    }

    /**
     * @param x    二维表格单元格横坐标
     * @param y    二维表格单元格纵坐标
     * @param cols 二维表格列数
     * @return
     */
    private int getIndex(int x, int y, int cols) {
        return x * cols + y;
    }


    /**
     * @param x    二维表格单元格横坐标
     * @param y    二维表格单元格纵坐标
     * @param rows 二维表格行数
     * @param cols 二维表格列数
     * @return
     */
    private boolean inArea(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}