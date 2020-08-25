import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class Solution10 {

    private boolean[] col;
    private boolean[] master;
    private boolean[] slave;
    private int n;
    private List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        if (n == 0) {
            return res;
        }


        col = new boolean[n];
        master = new boolean[2 * n - 1];
        slave = new boolean[2 * n - 1];
        Deque<Integer> path = new ArrayDeque<>();

        dfs(0, path);
        return res;
    }

    private void dfs(int row, Deque<Integer> path) {
        if (row == n) {
            List<String> board = convert2board(path, n);
            res.add(board);
            return;
        }

        // 针对每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            if (!col[i] && !master[row + i] && !slave[row - i + n - 1]) {
                path.add(i);
                col[i] = true;
                master[row + i] = true;
                slave[row - i + n - 1] = true;

                dfs(row + 1, path);

                slave[row - i + n - 1] = false;
                master[row + i] = false;
                col[i] = false;
                path.pop();
            }
        }
    }

    private List<String> convert2board(Deque<Integer> path, int n) {
        List<String> board = new ArrayList<>();
        for (Integer num : path) {
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
}
