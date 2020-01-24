/**
 * @author liweiwei1419
 * @date 2019/11/20 2:12 下午
 */
public class Solution {

    public int minFallingPathSum(int[][] A) {
        int row = A.length;
        if (row == 0) {
            return 0;
        }

        if (){


            return ;
        }

        //DP，从第二行开始
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < row; j++) {
                //边界判断
                if (j == 0) {
                    A[i][j] = Math.min(A[i - 1][j], A[i - 1][j + 1]) + A[i][j];
                } else if (j + 1 == row) {
                    A[i][j] = Math.min(A[i - 1][j], A[i - 1][j - 1]) + A[i][j];
                } else {
                    A[i][j] = A[i][j] = Math.min(Math.min(A[i - 1][j], A[i - 1][j - 1]), A[i - 1][j + 1]) + A[i][j];
                }
            }
        }
        // 找出最小值
        int res = A[row -1][0];
        for (int i = 1; i < row; i++) {
            res = Math.min(res, A[row - 1][i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] A = {{1},{4},{7}};
        Solution solution = new Solution();
        int res = solution.minFallingPathSum(A);
        System.out.println(res);
    }
}
