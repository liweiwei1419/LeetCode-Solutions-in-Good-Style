import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution12 {

    private List<List<String>> res;
    /**
     * 数组索引为行索引, 值为列索引
     */
    private int[] col;
    private int len;

    private List<String> generateBoard() {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            char[] charArray = new char[len];
            Arrays.fill(charArray, '.');
            charArray[this.col[i]] = 'Q';
            board.add(new String(charArray));
        }
        return board;
    }

    /**
     * 皇后编号0 ~ n-1
     *
     * @param rowIndex 当前皇后编号(编号为x的皇后放置在x行)
     */
    public void dfs(int rowIndex) {
        // 八个皇后成功放置
        if (rowIndex == len) {
            res.add(generateBoard());
            return;
        }

        for (int i = 0; i < len; i++) {
            // 编号为cur的皇后分别尝试放到cur行i列
            col[rowIndex] = i;
            boolean flag = true;

            // 判断是否与前面放置的皇后有冲突
            for (int j = 0; j < rowIndex; j++) {
                // col[j] == i，判断前面放置的皇后是否与当前的皇后在同一列
                // j - rowIndex == arr[j] - arr[rowIndex]
                // 判断是否在对角线上，因为有主对角线和副对角线的情况所以要取绝对值判断

                if (col[j] == i || Math.abs(j - rowIndex) == Math.abs(col[j] - col[rowIndex])) {
                    flag = false;
                    break;
                }
            }

            // 无冲突则进行下一个皇后的摆放
            if (flag) {
                dfs(rowIndex + 1);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.res = new ArrayList<>();
        col = new int[n];
        len = n;
        dfs(0);
        return res;

    }

    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        List<List<String>> solveNQueens = solution12.solveNQueens(8);
        int solveSize = solveNQueens.size();
        System.out.println("一共有 " + solveSize + " 种解。");

        for (int i = 0; i < solveNQueens.size(); i++) {
            System.out.println("第 " + (i + 1) + " 种解：");
            for (String line : solveNQueens.get(i)) {
                System.out.println(line);
            }
        }
    }
}
