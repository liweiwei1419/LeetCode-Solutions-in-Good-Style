import java.util.ArrayList;
import java.util.List;

public class Solution4 {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        List<Integer> path = new ArrayList<>(len);
        boolean[] used = new boolean[len];
        dfs(nums, 0, len, used, res, path);
        return res;
    }

    void dfs(int[] nums, int depth, int len, boolean[] used,
             List<List<Integer>> res, List<Integer> path) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                used[i] = true;
                // 改动：add()替代addLast()
                // path.addLast(nums[i]);
                path.add(nums[i]);

                dfs(nums, depth + 1, len, used, res, path);

                used[i] = false;
                // 改动: 用remove()替代removeLast()
                // path.removeLast();
                path.remove(path.size() - 1);
            }
        }
    }
}
