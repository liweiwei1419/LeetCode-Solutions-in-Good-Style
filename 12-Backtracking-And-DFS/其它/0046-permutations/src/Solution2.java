import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution2 {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(nums, 0, len, path, used, res);
        return res;
    }

    private void dfs(int[] nums, int begin, int len, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (begin == len) {
            // 注意：全程使用一份 path 变量，dfs 回到原点以后 path 为空列表
            // 因此在叶子结点处需拷贝
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            // 没有使用过，才考虑使用
            if (!used[i]) {
                used[i] = true;
                path.add(nums[i]);

                dfs(nums, begin + 1, len, path, used, res);

                // 深度优先遍历以后做逆向操作，恢复现场
                used[i] = false;
                path.removeLast();
            }
        }
    }
}
