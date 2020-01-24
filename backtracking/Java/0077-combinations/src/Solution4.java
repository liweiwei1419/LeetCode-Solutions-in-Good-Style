import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class Solution4 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 && k > n) {
            return result;
        }

        Deque<Integer> path = new ArrayDeque<>(k);
        // 从 1 开始
        dfs(n, k, 1, path);
        return result;
    }

    /**
     * 从 [1, n] 中选出 k 个数，
     *
     * @param n     从 [1, n] 中选
     * @param k     选出的数字的个数
     * @param start 当前被选中的起始数字
     * @param path   已经构成的数字数组
     */
    private void dfs(int n, int k, int start, Deque<Integer> path) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.addLast(i);
            dfs(n, k, i + 1, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        List<List<Integer>> combine = solution4.combine(4, 2);
        System.out.println(combine);
    }
}