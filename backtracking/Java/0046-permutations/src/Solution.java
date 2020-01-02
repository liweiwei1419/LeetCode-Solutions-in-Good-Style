import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    // 时间复杂度: O(n^n)
    // 空间复杂度: O(n)

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;

        // 计算 factorial(len) 非必需
        List<List<Integer>> res = new ArrayList<>(factorial(len));
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private int factorial(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, boolean[] used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                used[i] = true;
                path.addLast(nums[i]);

                dfs(nums, len, depth + 1, path, used, res);

                path.removeLast();
                used[i] = false;
            }
        }
    }
}
