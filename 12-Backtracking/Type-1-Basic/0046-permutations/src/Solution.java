import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(nums, 0, len, used, path, res);
        return res;
    }

    private void dfs(int[] nums, int index, int len, boolean[] used, Deque<Integer> path, List<List<Integer>> res) {
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            path.addLast(nums[i]);

            // 在添加 nums[i] 以后输出
            // System.out.println("path => " + path);
            dfs(nums, index + 1, len, used, path, res);

            used[i] = false;
            path.removeLast();
            // 在撤销 nums[i] 以后输出
            // System.out.println("path => " + path);
        }
    }
}