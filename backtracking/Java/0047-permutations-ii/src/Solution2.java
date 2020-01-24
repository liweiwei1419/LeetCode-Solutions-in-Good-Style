import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution2 {

    private List<List<Integer>> res = new ArrayList<>();
    private boolean[] used;
    private int[] nums;
    private int n;

    private void dfs(int depth, Deque<Integer> path) {
        if (depth == n) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                if (i != 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                path.addLast(nums[i]);
                dfs(depth + 1, path);
                path.removeLast();
                used[i] = false;
            }
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        n = len;
        Arrays.sort(nums);
        this.nums = nums;
        used = new boolean[len];
        dfs(0, new ArrayDeque<>(len));
        return res;
    }
}
