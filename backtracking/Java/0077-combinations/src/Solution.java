import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    private List<List<Integer>> res = new ArrayList<>();

    private void dfs(int n, int k, int begin, Deque<Integer> path) {
        if (path.size() == k) {
            // 够数了，就添加到结果集中
            res.add(new ArrayList<>(path));
            return;
        }
        // 关键在于分析出 i 的上界
        for (int i = begin; i <= n; i++) {
            path.addLast(i);
            dfs(n, k, i + 1, path);
            path.removeLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        // 特判
        if (k <= 0 || n < k) {
            return res;
        }
        // 从 1 开始是题目的设定
        Deque<Integer> path = new ArrayDeque<>(k);
        dfs(n, k, 1, path);
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> combine = solution.combine(4, 2);
        System.out.println(combine);
    }
}
