import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    // 回溯

    public List<List<Integer>> dfs(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, len, 0, path, res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 不选 nums[depth]
        dfs(nums, len, depth + 1, path, res);
        path.addLast(nums[depth]);
        // 选 nums[depth]
        dfs(nums, len, depth + 1, path, res);
        // 状态重置
        path.removeLast();
    }
}
