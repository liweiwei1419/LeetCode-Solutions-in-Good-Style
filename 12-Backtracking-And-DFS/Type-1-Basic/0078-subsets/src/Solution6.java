import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution6 {

    // 方法四：按照长度遍历

    public List<List<Integer>> subsets(int[] nums) {
        int size = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (size == 0) {
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        for (int i = 0; i < size + 1; i++) {
            dfs(nums, 0, i, path, res);
        }
        return res;
    }

    private void dfs(int[] nums, int start, int depth, Deque<Integer> stack, List<List<Integer>> res) {
        if (depth == stack.size()) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            stack.addLast(nums[i]);
            dfs(nums, i + 1, depth, stack, res);
            stack.removeLast();
        }
    }
}