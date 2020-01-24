import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private int k;

    private void findCombinationSum3(int target, int depth, int start, Deque<Integer> path) {
        if (target == 0 && depth == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 注意：题目中要求组合中只允许含有 1 - 9 的正整数。
        for (int i = start; i <= 9 && target - i >= 0; i++) {
            path.addLast(i);
            findCombinationSum3(target - i, depth + 1, i + 1, path);
            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k < 0 || n < 0 || k > n) {
            return res;
        }

        if (n > (9 * k - (k * (k - 1)) / 2)) {
            return res;
        }

        this.k = k;
        // 注意，深度应该从 0 开始，往下走一层，深度加 1 ，加到 3 为止
        findCombinationSum3(n, 0, 1, new ArrayDeque<>());
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 3;
        int n = 15;
        List<List<Integer>> combinationSum3 = solution.combinationSum3(k, n);
        System.out.println(combinationSum3);
    }
}
