import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution2 {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }

        boolean[] col = new boolean[n];
        boolean[] master = new boolean[2 * n - 1];
        boolean[] slave = new boolean[2 * n - 1];
        Stack<Integer> stack = new Stack<>();

        backtrack(nums, 0, n, col, master, slave, stack, res);
        return res;
    }

    private void backtrack(int[] nums, int row, int n,
                           boolean[] col,
                           boolean[] master,
                           boolean[] slave,
                           Stack<Integer> stack,
                           List<List<String>> res) {

        if (row == n) {
            List<String> board = convert2board(stack, n);
            res.add(board);
            return;
        }

        // 针对每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            if (!col[i] && !master[row + i] && !slave[row - i + n - 1]) {
                stack.add(nums[i]);
                col[i] = true;
                master[row + i] = true;
                slave[row - i + n - 1] = true;

                backtrack(nums, row + 1, n, col, master, slave, stack, res);

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
        Solution2 solution2 = new Solution2();
        List<List<String>> res = solution2.solveNQueens(n);
        System.out.println(res);
    }
}
