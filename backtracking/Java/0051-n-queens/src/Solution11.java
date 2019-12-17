import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution11 {

    private List<List<String>> res;
    private int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        int col = 0;
        int master = 0;
        int slave = 0;
        Stack<Integer> stack = new Stack<>();

        backtrack(0, col, master, slave, stack);
        return res;
    }

    private void backtrack(int row, int col, int master, int slave, Stack<Integer> stack) {
        if (row == n) {
            List<String> board = convert2board(stack, n);
            res.add(board);
            return;
        }

        // 针对每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            if (((col >> i) & 1) == 0
                    && ((master >> (row + i)) & 1) == 0
                    && ((slave >> (row - i + n - 1)) & 1) == 0) {
                stack.add(i);
                col ^= (1 << i);
                master ^= (1 << (row + i));
                slave ^= (1 << (row - i + n - 1));

                backtrack(row + 1, col, master, slave, stack);

                slave ^= (1 << (row - i + n - 1));
                master ^= (1 << (row + i));
                col ^= (1 << i);
                stack.pop();
            }
        }
    }

    private List<String> convert2board(Stack<Integer> stack, int n) {
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


    public static void main(String[] args) {
        int n = 4;
        Solution11 solution11 = new Solution11();
        List<List<String>> res = solution11.solveNQueens(n);
        System.out.println(res);
    }
}
