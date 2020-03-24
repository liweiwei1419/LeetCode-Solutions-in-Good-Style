import java.util.Stack;

// 以前写的方法，现在看起来比较"幼稚"

public class Solution3 {

    private boolean[] marked;
    private int count;

    public int totalNQueens(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] board = new int[n];
        for (int i = 0; i < n; i++) {
            board[i] = i;
        }
        permuta(board);
        return count;
    }

    /**
     * 生成一个 [0,1,...,n-1] 的全排列
     * @param board
     */
    private void permuta(int[] board) {
        int len = board.length;
        marked = new boolean[len];
        Stack<Integer> pre = new Stack<>();
        findPermutation(board, 0, len, pre);
    }

    private void findPermutation(int[] board, int usedCount, int len, Stack<Integer> pre) {
        if (usedCount == len) {
            // 判断是否是符合要求的棋盘布局
            if (noDanger(pre, len)) {
                count++;
            }
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!marked[i]) {
                marked[i] = true;
                pre.push(board[i]);
                findPermutation(board, usedCount + 1, len, pre);
                marked[i] = false;
                pre.pop();
            }

        }
    }

    private boolean noDanger(Stack<Integer> pre, int len) {
        int[] board = new int[len];
        for (int i = 0; i < len; i++) {
            board[i] = pre.get(i);
        }
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                // 得到所有不同的 i j 的组合，是一个组合问题，按顺序来就行
                // System.out.println(i + "\t" + j);
                if (i - j == board[i] - board[j]) {
                    return false;
                }
                if (i - j == -(board[i] - board[j])) {
                    return false;
                }
            }

        }
        // 走到这里表示通过检验
        // System.out.println(Arrays.toString(board));
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int totalNQueens = solution.totalNQueens(8);
        System.out.println(totalNQueens);
    }
}
