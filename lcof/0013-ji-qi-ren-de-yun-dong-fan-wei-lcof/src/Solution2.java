import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    // 广度优先遍历

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int[][] directions = {{0, 1}, {1, 0}};

        Queue<Integer> queue = new LinkedList<>();
        queue.add(getIndex(0, 0, n));

        int res = 0;
        while (!queue.isEmpty()) {
            Integer head = queue.poll();

            int currentX = head / n;
            int currentY = head % n;

            visited[currentX][currentY] = true;
            res++;

            for (int[] direction : directions) {
                int newX = currentX + direction[0];
                int newY = currentY + direction[1];

                if (inArea(newX, newY, m, n) && !visited[newX][newY] && getDigitSum(newX) + getDigitSum(newY) <= k) {
                    queue.add(getIndex(newX, newY, n));
                    // 注意：添加到队列的时候，就要占住
                    visited[newX][newY] = true;
                }
            }
        }
        return res;
    }

    /**
     * @param num 一个整数的数位之和
     * @return
     */
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
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

    /**
     * @param x    二维表格单元格横坐标
     * @param y    二维表格单元格纵坐标
     * @param cols 二维表格列数
     * @return
     */
    private int getIndex(int x, int y, int cols) {
        return x * cols + y;
    }


    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int m = 2;
        int n = 3;
        int k = 1;

//        int m = 3;
//        int n = 1;
//        int k = 0;
        int res = solution2.movingCount(m, n, k);
        System.out.println(res);
    }
}
