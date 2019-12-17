import java.util.ArrayList;
import java.util.List;

// https://leetcode-cn.com/problems/n-queens/description/
// 这一版使用了递归回溯的思想完成
// 使用 marked 数组把皇后四面八方的攻击范围都给标记上了
public class Solution5 {

    //  x-1,y-1   x-1,y  x-1,y+1
    //  x,y-1     x,y    x,y+1
    //  x+1,y-1   x+1,y  x+1,y+1
    private static int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

    private int n;

    // 当前坐标 x,y 放上了皇后以后，它的 8 个方向都应该被标记不能放置其它皇后
    // 标记 marked 数组，给皇后的四面八方都标记上
    private void putDownTheQueen(int x, int y, boolean[][] marked) {
        marked[x][y] = true;
        // 从 1 开始， 从 0 开始也可以，只不过重复了 marked[x][y] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 8; j++) {
                // 不要忘记乘以 i
                int newX = x + i * dx[j];
                int newY = y + i * dy[j];
                // 只要都在棋盘内
                if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
                    marked[newX][newY] = true;
                }
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        List<List<String>> res = new ArrayList<>();
        // 默认值是 false ，表示当前没有放置皇后
        boolean[][] marked = new boolean[n][n];

        // n 皇后问题的一个解
        char[][] solution = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                solution[i][j] = '.';
            }
        }
        generate(0, n, marked, solution, res);
        return res;
    }

    // 在第 k 行（从 0 开始计算）考虑，这一行的 n 个元素，搜索皇后应该摆放在哪里
    // 皇后摆放的位置应该在 marked 数组中标记为 false 的地方，此时已经摆放皇后的情况位于 solution 数组中
    // 所有已经得到的 n 皇后问题的解位于 res 中
    private void generate(int k, int n, boolean[][] marked, char[][] solution, List<List<String>> res) {
        if (k == n) {
            res.add(transform2str(solution));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!marked[k][i]) { // 如果没有标记过，表示当前位置是安全的，可以放置皇后
                // 注意：对于二维数组的复制，不能简单实用 clone() 或者 System.arraycopy() 或者 Arrays.copyOf() 方法
                // 应该对它们在一维数组上使用
                boolean[][] temp_mark = copyNewArr(marked);
                solution[k][i] = 'Q';
                putDownTheQueen(k, i, marked);
                generate(k + 1, n, marked, solution, res);
                marked = temp_mark;
                solution[k][i] = '.';
            }
        }
    }

    // 复制一个 marked 数组
    private boolean[][] copyNewArr(boolean[][] marked) {
        boolean[][] res = new boolean[n][n];
        for (int i = 0; i < n; i++) {

            System.arraycopy(marked[i],0,res[i],0,n);
        }
        return res;
    }

    private List<String> transform2str(char[][] solution) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(new String(solution[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
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
