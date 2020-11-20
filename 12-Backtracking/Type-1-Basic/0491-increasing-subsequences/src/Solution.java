import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    
    // 回溯算法，参考代码随想录：https://leetcode-cn.com/problems/increasing-subsequences/solution/491-di-zeng-zi-xu-lie-shen-sou-hui-su-xiang-jie-by/

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, 0, path, res);
        return res;
    }

    private void dfs(int[] nums, int begin, Deque<Integer> path, List<List<Integer>> res) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
            // 注意这里不要加 return，因为要取所有的可能
        }
        Set<Integer> set = new HashSet<>();
        for (int i = begin; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }

            if (path.isEmpty() || nums[i] >= path.peekLast()) {
                path.addLast(nums[i]);
                dfs(nums, i + 1, path, res);
                path.removeLast();

                set.add(nums[i]);
            }
        }
    }
}