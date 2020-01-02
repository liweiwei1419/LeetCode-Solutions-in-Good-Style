import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class Solution3 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        // 排序很重要
        Arrays.sort(nums);
        backtracking(nums, 0, len, new ArrayDeque<>(), res);
        return res;
    }

    private void backtracking(int[] nums, int start, int len, Deque<Integer> stack, List<List<Integer>> res) {
        res.add(new ArrayList<>(stack));
        for (int i = start; i < len; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            stack.push(nums[i]);
            backtracking(nums, i + 1, len, stack, res);
            stack.pop();
        }
    }
}
