import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution2 {

    // 回溯

    private void dfs(int[] nums, int begin, int len, Deque<Integer> stack, List<List<Integer>> res) {
        // 在遍历的过程中，收集
        res.add(new ArrayList<>(stack));
        for (int i = begin; i < len; i++) {
            stack.addLast(nums[i]);
            dfs(nums, i + 1, len, stack, res);
            stack.removeLast();
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, 0, len, path, res);
        return res;
    }

}
