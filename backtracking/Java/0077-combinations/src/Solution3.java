import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// 剪枝优化版本：
public class Solution3 {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return result;
        }
        Deque<Integer> path = new ArrayDeque<>(k);
        dfs(n, k, 1, path);
        return result;
    }

    // path 可以声明成一个栈
    // i 的极限值满足： n - i + 1 = (k - pre.size())。
    // 【关键】n - i + 1 是闭区间 [i,n] 的长度。
    // k - pre.size() 是剩下还要寻找的数的个数。
    private void dfs(int n, int k, int index, Deque<Integer> path) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i <= n - (k - path.size()) + 1; i++) {
            path.push(i);
            dfs(n, k, i + 1, path);
            path.pop();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution3().combine(4, 2);
        System.out.println(lists);
    }
}
