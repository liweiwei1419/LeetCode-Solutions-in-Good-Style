import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    // 回溯

    public List<List<Integer>> backtracking(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        backtracking(nums, len, 0, new ArrayDeque<>(), res);
        return res;
    }

    private void backtracking(int[] nums, int len, int step, Deque<Integer> path, List<List<Integer>> res) {
        if (step == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 不选 nums[step]
        backtracking(nums, len, step + 1, path, res);
        path.push(nums[step]);
        // 选 nums[step]
        backtracking(nums, len, step + 1, path, res);
        // 状态重置
        path.remove(path.size() - 1);
    }

}
