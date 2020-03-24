import java.util.Arrays;
import java.util.LinkedList;


public class Solution {

    /**
     * x-1,y
     * x,y-1  x,y    x,y+1
     * x+1,y
     */
    private static int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public int[][] updateMatrix(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) {
            return new int[0][0];
        }
        int col = matrix[0].length;
        LinkedList<Integer[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    // 从为 0 的地方开始向外扩散
                    queue.addLast(new Integer[]{i, j});
                } else {
                    // 设置成一个特殊值，说明当前这个坐标的位置还没有被扩散到
                    matrix[i][j] = -1;
                }
            }
        }
        // 从为 0 的地方开始进行广度优先遍历
        while (!queue.isEmpty()) {
            // 当前的位置，一开始的时候，"0" 正好，到"0" 的距离也是 0 ，符合题意
            Integer[] curPostion = queue.removeFirst();
            // 现在要往 4 个方向扩散
            for (int i = 0; i < 4; i++) {
                int newX = curPostion[0] + directions[i][0];
                int newY = curPostion[1] + directions[i][1];
                // 在有效的坐标范围内，并且还没有被访问过
                if (inArea(newX, newY, row, col) && matrix[newX][newY] == -1) {
                    matrix[newX][newY] = matrix[curPostion[0]][curPostion[1]] + 1;
                    queue.addLast(new Integer[]{newX, newY});
                }
            }
        }
        return matrix;
    }

    private boolean inArea(int x, int y, int row, int col) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        Solution solution = new Solution();
        int[][] updateMatrix = solution.updateMatrix(matrix);
        for (int i = 0; i < updateMatrix.length; i++) {
            System.out.println(Arrays.toString(updateMatrix[i]));
        }
    }
}