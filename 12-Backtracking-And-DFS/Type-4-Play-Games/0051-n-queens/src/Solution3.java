import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution3 {

    private List<List<String>> res;
    private int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        int col = 0;
        int main = 0;
        int sub = 0;
        Deque<Integer> path = new ArrayDeque<>();
        dfs(0, col, main, sub, path);
        return res;
    }

    private void dfs(int row, int col, int main, int sub, Deque<Integer> path) {
        if (row == n) {
            List<String> board = convert2board(path);
            res.add(board);
            return;
        }

        // 针对每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            if (((col >> i) & 1) == 0
                    && ((main >> (row - i + n - 1)) & 1) == 0
                    && ((sub >> (row + i)) & 1) == 0) {
                path.addLast(i);
                col ^= (1 << i);
                main ^= (1 << (row - i + n - 1));
                sub ^= (1 << (row + i));

                dfs(row + 1, col, main, sub, path);

                sub ^= (1 << (row + i));
                main ^= (1 << (row - i + n - 1));
                col ^= (1 << i);
                path.removeLast();
            }
        }
    }

    private List<String> convert2board(Deque<Integer> path) {
        List<String> board = new ArrayList<>();
        for (Integer num : path) {
            StringBuilder row = new StringBuilder();
            row.append(".".repeat(Math.max(0, n)));
            row.replace(num, num + 1, "Q");
            board.add(row.toString());
        }
        return board;
    }
}