/**
 * @author liwei
 * @date 2019/8/21 4:48 PM
 */
public class Solution {

    private int count = 0;

    public int totalNQueens(int n) {
        if (n == 0) {
            return 0;
        }

        int col = 0;
        int master = 0;
        int slave = 0;

        backtrack(0, n, col, master, slave);
        return this.count;
    }


    private void backtrack(int row, int n,
                           int col,
                           int master,
                           int slave) {

        if (row == n) {
            this.count++;
            return;
        }

        // 针对每一列，尝试是否可以放置
        for (int i = 0; i < n; i++) {
            if (((col >> i) & 1) == 0
                    && ((master >> (row + i)) & 1) == 0
                    && ((slave >> (row - i + n - 1)) & 1) == 0) {
                col ^= (1 << i);
                master ^= (1 << (row + i));
                slave ^= (1 << (row - i + n - 1));

                backtrack(row + 1, n, col, master, slave);

                slave ^= (1 << (row - i + n - 1));
                master ^= (1 << (row + i));
                col ^= (1 << i);
            }
        }
    }

}
