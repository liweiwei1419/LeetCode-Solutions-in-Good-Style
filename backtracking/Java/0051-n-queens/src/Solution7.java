import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode-cn.com/problems/n-queens/description
// 只用一张棋盘摆放的方法完成了 n 皇后问题
public class Solution7 {

    private List<List<String>> res;
    private boolean[][] solution; // true 就表示当前位置放置了皇后，false 就表示没有放置皇后

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        solution = new boolean[n][n];
        nQueens(0, n, solution);
        return res;
    }

    private void nQueens(int row, int n, boolean[][] solution) {
        if (row == n) {
            // 将 solution 处理成为一个棋盘 generateChessboard
            List<String> board = generateChessboard(solution, n);
            res.add(board);
            return;
        }

        // 站在当前这一行（索引为 row），去一列一列检查是否可以放皇后
        for (int i = 0; i < n; i++) {
            if (notInDanger(row, i, n, solution)) {
                solution[row][i] = true;
                nQueens(row + 1, n, solution);
                solution[row][i] = false;// 因为下一列的放置与上一列应该是在同样的环境下进行考虑，棋盘要重置
            }
            // 如果每一列都不能放置，那么这个方法就自动退出了，当前错误的棋盘摆放就不会被保存
        }
    }

    private List<String> generateChessboard(boolean[][] solution, int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stringBuilder;
        for (int i = 0; i < n; i++) {
            stringBuilder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (solution[i][j]) {
                    stringBuilder.append("Q");
                } else {
                    stringBuilder.append(".");
                }
            }
            res.add(stringBuilder.toString());
        }
        return res;
    }

    // i，j 表示当前尝试放置皇后棋子的坐标
    private boolean notInDanger(int i, int j, int n, boolean[][] solution) {
        // 设置一些标志，看看当前位置是不是危险的
        // 从之前递归的写法来看，一定是处于不同行的，所以要接着判断，属于不同的列，不同的主对角线和副对角线
        // 判断在 (2,3) 之前的那些行，在 3 这一列上是否有皇后，即 (0,3)、 (1,3)
        for (int r = i; r >= 0; r--) {
            if (solution[r][j]) {
                return false;
            }
        }
        // 判断在 (2,3) 之前的那些行，在它的主对角线上是否有皇后（向右上方走）
        for (int r = i, c = j; r >= 0 && c < n; r--, c++) {
            if (solution[r][c]) {
                return false;
            }
        }
        // 判断在 (2,3) 之前的那些行，在它的副对角线上是否有皇后（向左上方走）
        for (int r = i, c = j; r >= 0 && c >= 0; r--, c--) {
            if (solution[r][c]) {
                return false;
            }
        }
        // 全部判断完以后，才表示安全
        return true;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        List<List<String>> solveNQueens = solution.solveNQueens(8);
        int solveSize = solveNQueens.size();
        System.out.println("一共有 " + solveSize + " 种解。");

        for (int i = 0; i < solveNQueens.size(); i++) {
            System.out.println("第 " + (i + 1) + " 种解：");
            for (String line : solveNQueens.get(i)) {
                System.out.println(line);
            }
        }
    }
}
