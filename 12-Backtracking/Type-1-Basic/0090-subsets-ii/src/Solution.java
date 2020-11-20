import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }

        // 排序是为了后面剪枝
        Arrays.sort(nums);

        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, 0, len, path, res);
        return res;
    }

    private void dfs(int[] nums, int begin, int len, Deque<Integer> path, List<List<Integer>> res) {
        res.add(new ArrayList<>(path));
        for (int i = begin; i < len; i++) {
            // 剪枝条件，不能写成 i > 0
            if (i > begin && nums[i] == nums[i - 1]){
                continue;
            }

            path.addLast(nums[i]);
            // 从 i + 1 开始继续枚举，按顺序枚举，所以不会重复
            dfs(nums, i + 1, len, path, res);
            path.removeLast();
        }
    }
}