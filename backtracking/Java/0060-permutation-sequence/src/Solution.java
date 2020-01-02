import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    /**
     * 记录数字是否使用过
     */
    private boolean[] used;

    /**
     * 阶乘数组
     */
    private int[] factorial;

    private int n;
    private int k;
    /**
     * 从根结点到叶子结点的路径
     */
    private List<Integer> path;

    public String getPermutation(int n, int k) {
        this.n = n;
        this.k = k;
        used = new boolean[n + 1];
        Arrays.fill(used, false);

        // 计算阶乘数组
        factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        path = new ArrayList<>(n);
        dfs(0);

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer c : path) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    /**
     * @param index 在这一步之前已经选择了几个数字，其值恰好等于这一步需要确定的索引位置
     * @return
     */
    private void dfs(int index) {
        if (index == n) {
            return;
        }

        // 还未确定的数字的全排列的个数，第 1 次进入的时候是 n - 1
        int cnt = factorial[n - 1 - index];
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            if (cnt < k) {
                k -= cnt;
                continue;
            }
            path.add(i);
            used[i] = true;
            dfs(index + 1);
        }
    }
}
