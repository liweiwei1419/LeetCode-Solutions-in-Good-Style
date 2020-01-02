import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class Solution3 {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>(factorial(len));
        if (len == 0) {
            return res;
        }

        int used = 0;
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
                     Deque<Integer> path, int used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (((used >> i) & 1) == 0) {
                path.addLast(nums[i]);
                used ^= (1 << i);

                dfs(nums, len, depth + 1, path, used, res);
                used ^= (1 << i);
                path.removeLast();
            }
        }
    }
}
