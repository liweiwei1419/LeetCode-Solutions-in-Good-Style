/**
 * @author liwei
 * @date 2019/8/21 4:52 PM
 */
public class Solution2 {

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
            // 已经排出了 n 个数，结算
            this.count++;
            return;
        }

        // 第 1 步：col | master | slave，将列、主对角线、副对角线上的已经放置的元素做一次合并
        // 很可能 col、master、slave 三个位置都被占，这不要紧，我们只关心没有被占的位置
        // 第 2 步：我们关心的是 0，但是探测 1 容易，因此，让 0 变 1 ， 1 变 0
        // 由此带来一个问题，高位 0 全变成 1 了，因此引入第 3 步
        // 第 3 步：& (1 << n) - 1) 是只取低 n 位，1 << n 表示第 n + 1 位是 1 ，低 n 位全是 0
        // 这里 mask 中 1 表示可以放置的位置，0 表示不能放置的位置
        int mask = (~(col | master | slave) & (1 << n) - 1);
        while (mask > 0) { // 只有有位置为 1 ，表示至少有 1 个元素可以放置
            // 找到从低位到高位（从右向左）第 1 个二进制位为 1 的数
            // 这个操作保留了 1 和后面的 0
            int p = mask & (-mask);

            // col | p 表示占住这一列
            // (master | p) << 1 表示下一行右边的那个位置（主对角线方向）被占，
            // 因为位运算占位的操作是从右边向左边，因此需要左移
            // 同理理解 (slave | p) >> 1)

            // 注意：该方法是隐式回溯，基本数值类型在方法传递的时候是值传递，相当于完成了状态重置
            backtrack(row + 1, n, col | p, (master | p) << 1, (slave | p) >> 1);

            // 把低位的第 1 个 1 变成 0 ，让下一层循环探测下一个 1
            mask &= (mask - 1);
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int res = solution2.totalNQueens(8);
        System.out.println(res);
    }
}
