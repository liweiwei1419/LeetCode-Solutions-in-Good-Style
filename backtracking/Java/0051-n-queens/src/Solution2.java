import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class Solution2 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        // 使用布尔数组要注意下标偏移
        boolean[] col = new boolean[n];
        boolean[] main = new boolean[2 * n - 1];
        boolean[] sub = new boolean[2 * n - 1];
        Deque<Integer> path = new ArrayDeque<>();

        dfs(0, n, col, main, sub, path, res);
        return res;
    }

    private void dfs(int row, int n,
                     boolean[] col,
                     boolean[] main,
                     boolean[] sub,
                     Deque<Integer> path,
                     List<List<String>> res) {

        if (row == n) {
            List<String> board = convert2board(path, n);
            res.add(board);
            return;
        }

        // 针对每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            if (!col[i] && !main[row + i] && !sub[row - i + n - 1]) {
                path.addLast(i);
                col[i] = true;
                main[row + i] = true;
                sub[row - i + n - 1] = true;

                dfs(row + 1, n, col, main, sub, path, res);

                sub[row - i + n - 1] = false;
                main[row + i] = false;
                col[i] = false;
                path.removeLast();
            }
        }
    }

    private List<String> convert2board(Deque<Integer> stack, int n) {
        List<String> board = new ArrayList<>();
        for (Integer num : stack) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n; i++) {
                stringBuilder.append(".");
            }
            stringBuilder.replace(num, num + 1, "Q");
            board.add(stringBuilder.toString());
        }
        return board;
    }
}
