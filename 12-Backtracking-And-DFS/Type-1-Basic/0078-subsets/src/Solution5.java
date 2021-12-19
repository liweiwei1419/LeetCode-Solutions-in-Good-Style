import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution5 {

    // 方法四：按照长度遍历

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 第 1 轮一共找 0 个元素
        // 第 2 轮一共找 1 个元素
        // 最后 1 轮一共找 len 个元素
        for (int i = 0; i <= len; i++) {
            dfs(nums, len, i, 0, new ArrayDeque<>(), res);
        }
        return res;
    }

    private void dfs(int[] nums, int len,
                     int maxCount, int begin,
                     Deque<Integer> path,
                     List<List<Integer>> res) {
        if (maxCount == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            // 包括当前这个元素
            path.addLast(nums[i]);
            dfs(nums, len, maxCount, i + 1, path, res);
            // 不包括当前这个元素
            path.removeLast();
        }
    }
}