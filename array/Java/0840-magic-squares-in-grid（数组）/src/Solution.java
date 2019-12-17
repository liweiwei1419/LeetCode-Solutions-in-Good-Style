public class Solution {
    
    // 参考资料：https://blog.csdn.net/firefly_2002/article/details/7886989

    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;
        if (row < 3 || col < 3) {
            return 0;
        }

        int res = 0;
        int[] temp = new int[8];
        // 找中心是 5 的矩阵
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                System.out.println(i + " " + j);
                if (magicSquares(grid, temp, i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    // 以坐标 i j 为中心的矩阵是不是河图矩阵
    private boolean magicSquares(int[][] grid, int[] temp, int i, int j) {
        if (grid[i][j] != 5) {
            return false;
        }

        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if (grid[i - 1 + k][j - 1 + l] < 1 || grid[i - 1 + k][j - 1 + l] > 9) {
                    return false;
                }
            }
        }

        temp[0] = grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1];
        if (temp[0] != 15) {
            return false;
        }
        temp[1] = grid[i][j - 1] + grid[i][j] + grid[i][j + 1];
        if (temp[1] != 15) {
            return false;
        }
        temp[2] = grid[i + 1][j - 1] + grid[i + 1][j] + grid[i + 1][j + 1];
        if (temp[2] != 15) {
            return false;
        }
        temp[3] = grid[i - 1][j - 1] + grid[i][j - 1] + grid[i + 1][j - 1];
        if (temp[3] != 15) {
            return false;
        }
        temp[4] = grid[i - 1][j] + grid[i][j] + grid[i + 1][j];
        if (temp[4] != 15) {
            return false;
        }
        temp[5] = grid[i - 1][j + 1] + grid[i][j + 1] + grid[i + 1][j + 1];
        if (temp[5] != 15) {
            return false;
        }
        temp[6] = grid[i - 1][j - 1] + grid[i][j] + grid[i + 1][j + 1];
        if (temp[6] != 15) {
            return false;
        }
        temp[7] = grid[i + 1][j - 1] + grid[i][j] + grid[i - 1][j + 1];
        if (temp[7] != 15) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {5, 2, 9, 5, 4},
                {8, 1, 6, 1, 4},
                {7, 2, 4, 7, 8},
                {1, 8, 3, 5, 9},
                {5, 7, 2, 6, 1}};

        Solution solution = new Solution();
        int numMagicSquaresInside = solution.numMagicSquaresInside(grid);
        System.out.println(numMagicSquaresInside);
    }
}
