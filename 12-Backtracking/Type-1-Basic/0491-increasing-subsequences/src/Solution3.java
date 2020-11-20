import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution3 {

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

        // 子序列，不要求连续，因此这里使用哈希表去重
        Set<Integer> hashSet = new HashSet<>();
        for (int i = begin; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                continue;
            }

            // 注意：递增不是严格递增，因此使用 >=
            if (path.isEmpty() || nums[i] >= path.peekLast()) {
                path.addLast(nums[i]);
                dfs(nums, i + 1, path, res);
                path.removeLast();

                hashSet.add(nums[i]);
            }
        }
    }
}