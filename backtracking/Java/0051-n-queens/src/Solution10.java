import java.util.ArrayList;
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
        Stack<Integer> stack = new Stack<>();

        backtrack(0, stack);
        return res;
    }

    private void backtrack(int row, Stack<Integer> stack) {
        if (row == n) {
            List<String> board = convert2board(stack, n);
            res.add(board);
            return;
        }

        // 针对每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            if (!col[i] && !master[row + i] && !slave[row - i + n - 1]) {
                stack.add(i);
                col[i] = true;
                master[row + i] = true;
                slave[row - i + n - 1] = true;

                backtrack(row + 1, stack);

                slave[row - i + n - 1] = false;
                master[row + i] = false;
                col[i] = false;
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
        Solution10 solution10 = new Solution10();
        List<List<String>> res = solution10.solveNQueens(n);
        System.out.println(res);
    }
}
