import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    // Main diagonal (主对角线) sub diagonal（副对角线）

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        Set<Integer> col = new HashSet<>();
        Set<Integer> main = new HashSet<>();
        Set<Integer> sub = new HashSet<>();
        Deque<Integer> path = new ArrayDeque<>();

        dfs(0, n, col, main, sub, path, res);
        return res;
    }

    private void dfs(int row, int n,
                     Set<Integer> col,
                     Set<Integer> main,
                     Set<Integer> sub,
                     Deque<Integer> path,
                     List<List<String>> res) {

        if (row == n) {
            List<String> board = convert2board(path, n);
            res.add(board);
            return;
        }

        // 针对每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !main.contains(row + i) && !sub.contains(row - i)) {
                path.addLast(i);
                col.add(i);
                main.add(row + i);
                sub.add(row - i);

                dfs(row + 1, n, col, main, sub, path, res);

                sub.remove(row - i);
                main.remove(row + i);
                col.remove(i);
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

    public static void main(String[] args) {
        int n = 4;
        Solution solution = new Solution();
        List<List<String>> res = solution.solveNQueens(n);
        System.out.println(res);
    }
}
