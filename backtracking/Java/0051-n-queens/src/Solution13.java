import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liweiwei1419
 * @date 2019/12/2 12:22 下午
 */
public class Solution13 {

    private int size;
    private int n;
    private List<List<String>> lists = new ArrayList<>();

    private Stack<Integer> stack = new Stack<>();

    private void solve(int row, int ld, int rd) {
        if (row == size) {
            List<String> temps = new ArrayList<>();
            for (int i = 0; i < stack.size(); i++) {
                int p = stack.get(i);
                int index = getZeroIndex(p);
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == index) {
                        stringBuilder.append("Q");
                    } else {
                        stringBuilder.append(".");
                    }
                }
                temps.add(stringBuilder.toString());
            }

            lists.add(temps);
            return;
        }
        int pos = size & (~(row | ld | rd));
        while (pos != 0) {
            int p = pos & (-pos);
            pos -= p;
            stack.add(p);
            solve(row | p, (ld | p) << 1, (rd | p) >> 1);
            stack.pop();
        }
    }

    private int getZeroIndex(int num) {
        int cnt = 0;
        while (num > 1) {
            num >>= 1;
            cnt++;
        }
        return cnt;
    }

    public List<List<String>> solveNQueens(int n) {
        size = (1 << n) - 1;
        this.n = n;
        solve(0, 0, 0);
        return lists;
    }
}
