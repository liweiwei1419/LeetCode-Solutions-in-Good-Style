import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class Solution3 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        int col = 0;
        int main = 0;
        int sub = 0;
        Deque<Integer> path = new ArrayDeque<>();

        dfs(0, n, col, main, sub, path, res);
        return res;
    }

    private void dfs( int row, int n,
                     int col,
                     int main,
                     int sub,
                     Deque<Integer> path,
                     List<List<String>> res) {

        if (row == n) {
            List<String> board = convert2board(path, n);
            res.add(board);
            return;
        }

        // 针对每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            if (((col >> i) & 1) == 0
                    && ((main >> (row + i)) & 1) == 0
                    && ((sub >> (row - i + n - 1)) & 1) == 0) {
                path.addLast(i);
                col ^= (1 << i);
                main ^= (1 << (row + i));
                sub ^= (1 << (row - i + n - 1));

                dfs( row + 1, n, col, main, sub, path, res);

                sub ^= (1 << (row - i + n - 1));
                main ^= (1 << (row + i));
                col ^= (1 << i);
                path.removeLast();
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
