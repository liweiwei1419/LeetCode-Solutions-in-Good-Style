import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {

    private void backtracking(int[] nums,
                              int maxCount,
                              int begin,
                              int len,
                              boolean[] used,
                              Stack<Integer> stack,
                              List<List<Integer>> res) {
        if (maxCount == stack.size()) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = begin; i < len; i++) {
            if (!used[i]) {
                // 去重都有这一步加上排序
                if (i > begin && nums[i] == nums[i - 1]) {
                    continue;
                }
                used[i] = true;
                stack.push(nums[i]);
                backtracking(nums, maxCount, i + 1, len, used, stack, res);
                stack.pop();
                used[i] = false;
            }
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 排序很关键
        Arrays.sort(nums);
        boolean[] marked = new boolean[len];
        for (int i = 0; i <= len; i++) {
            backtracking(nums, i, 0, len, marked, new Stack<>(), res);
        }
        return res;
    }
}
