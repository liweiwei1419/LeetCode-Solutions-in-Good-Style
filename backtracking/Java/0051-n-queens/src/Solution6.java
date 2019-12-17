import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution6 {

    private List<List<String>> res;
    private boolean[] col;
    private boolean[] dia1;
    private boolean[] dia2;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        col = new boolean[n];
        // 可以用归纳法计算出对角线数组元素的个数为 2*n-1
        // 这里要动手用纸笔计算一下，并不难
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        // 表示一行数据，第 0 个数字表示"第 0 行的皇后应该摆放在哪个索引位置"
        LinkedList<Integer> row = new LinkedList<>();
        putQueen(n, 0, row);
        return res;
    }

    // 在一个 n 皇后问题中，尝试在第 index 行如何摆放一个皇后
    // 我们将它设计成一个递归调用的函数，所以要想清楚两个步骤
    private void putQueen(int n, int index, LinkedList<Integer> row) {
        if (index == n) {
            res.add(generateBoard(n, row));
        }
        for (int i = 0; i < n; i++) { // i 表示列数，index 表示行数
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                // 设置状态
                row.addLast(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                putQueen(n, index + 1, row);
                // 重置状态（与前面设置状态的步骤是一一对应的）
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                row.removeLast();
            }
        }
    }

    private List<String> generateBoard(int n, LinkedList<Integer> row) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] charArray = new char[n];
            Arrays.fill(charArray, '.');
            charArray[row.get(i)] = 'Q';
            board.add(new String(charArray));
        }
        return board;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
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
