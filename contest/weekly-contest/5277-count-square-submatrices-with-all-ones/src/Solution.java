/**
 * @author liweiwei1419
 * @date 2019/12/1 11:32 上午
 */
public class Solution {

    public int countSquares(int[][] matrix) {
        int res = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    continue;
                }
                // 这里计算一下最小正方形 1 的个数
                res += 1;
                if (col == 0) {
                    continue;
                }
                matrix[row][col] = matrix[row][col - 1] + 1;
                // 第 1 行，由于不能构成大于等于 2 的矩形，所以跳过
                if (row == 0) {
                    continue;
                }

                // matrix[row][col] 的值，是以当前 (i, j) 为右下角可以构成的矩形的最大边长
                int maxSide = matrix[row][col];
                int minLen = maxSide;
                // 往上面几行看
                int index = row - 1;
                int side = 2;
                while (index >= 0 && side <= maxSide) {
                    minLen = Math.min(minLen, matrix[index][col]);
                    if (minLen < side) {
                        break;
                    }
                    res++;
                    index--;
                    side++;
                }
            }
        }
        return res;
    }
}
