import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class Solution6 {

    public List<List<Integer>> subsets(int[] nums) {
        int size = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (size == 0) {
            return res;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < size + 1; i++) {
            backtracking(nums, 0, i, stack, res);
        }
        return res;
    }

    private void backtracking(int[] nums, int start, int depth, Deque<Integer> stack, List<List<Integer>> res) {
        if (depth == stack.size()) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            stack.add(nums[i]);
            backtracking(nums, i + 1, depth, stack, res);
            stack.pop();
        }
    }
}
