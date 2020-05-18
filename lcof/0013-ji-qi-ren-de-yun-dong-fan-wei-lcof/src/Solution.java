public class Solution {

    // 深度优先遍历

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int[][] directions = {{0, 1}, {1, 0}};

        return dfs(0, 0, k, m, n, visited, directions);
    }


    private int dfs(int x, int y, int k, int m, int n, boolean[][] visited, int[][] directions) {
        visited[x][y] = true;
        int count = 1;

        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];

            if (inArea(newX, newY, m, n) && !visited[newX][newY] && getDigitSum(newX) + getDigitSum(newY) <= k) {
                count += dfs(newX, newY, k, m, n, visited, directions);
            }
        }
        return count;
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        int m = 2;
        int n = 3;
        int k = 1;

//        int m = 3;
//        int n = 1;
//        int k = 0;
        int res = solution.movingCount(m, n, k);
        System.out.println(res);
    }
}
