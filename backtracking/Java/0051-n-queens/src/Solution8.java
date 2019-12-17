import java.util.ArrayList;
import java.util.List;

public class Solution8 {
    /**
     * 记录在列上第几列已经放置了元素
     */
    private boolean[] col;
    /**
     * 记录在主对角线上哪些位置已经放置了元素
     */
    private boolean[] dia1;
    /**
     * 记录在副对角线上哪些位置已经放置了元素
     */
    private boolean[] dia2;
    private List<List<String>> res = new ArrayList<>();

    // 入口函数
    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        // 可以用归纳法得到对角线上的元素个数
        dia1 = new boolean[2 * n - 1];
        // 可以用归纳法得到对角线上的元素个数
        dia2 = new boolean[2 * n - 1];
        putQueue(n, 0, new ArrayList<Integer>());
        return res;
    }

    /**
     * 递归调用函数：尝试在一个 n 皇后的问题中，摆放第 index 行的皇后的位置
     * @param n
     * @param index
     * @param row
     */
    private void putQueue(int n, int index, List<Integer> row) {
        if (index == n) {
            res.add(generateBoard(n, row));
            return;
        }
        // i 表示第几列，循环的过程就是在尝试给每一行的每一列放置皇后，看看在列上能不能放，看看在对角线上能不能放
        // 其实 n 皇后问题和使用回溯解决排列问题的思路是一致的：暴力遍历，使用额外数组记录状态，一层层减少，递归到底以后回溯，回溯的过程中，一层一层地恢复状态
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                row.add(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;

                // putQueue 的前后 4 行是对称的，这是一个典型的回溯的过程
                putQueue(n, index + 1, row);

                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                row.remove(row.size() - 1);
            }
        }
    }

    private List<String> generateBoard(int n, List<Integer> row) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(".");
        }
        StringBuilder cur = null;
        for (int i = 0; i < n; i++) {
            cur = new StringBuilder(sb);
            int queueLoc = row.get(i);
            cur.replace(queueLoc, queueLoc + 1, "Q");
            res.add(cur.toString());
        }
        return res;
    }

    // 测试用例
    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        int n = 4;
        List<List<String>> solveNQueens = solution8.solveNQueens(n);
        for (int i = 0; i < solveNQueens.size(); i++) {
            System.out.println("第 " + (i + 1) + " 种解法：");
            List<String> sloveOne = solveNQueens.get(i);
            printList(sloveOne);
            System.out.println("********");
        }
    }

    private static void printList(List<String> sloveOne) {
        for (int i = 0; i < sloveOne.size(); i++) {
            System.out.println(sloveOne.get(i));
        }
    }
}
