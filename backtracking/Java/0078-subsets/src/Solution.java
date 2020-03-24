import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // Java 官方文档的 Stack 类中建议使用 Deque
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, len, 0, path, res);
        return res;
    }

    private void dfs(int[] nums, int len, int index, Deque<Integer> path, List<List<Integer>> res) {
        if (index == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 不选 nums[index]，由于在 dfs 之前什么都没有操作，不用状态重置
        dfs(nums, len, index + 1, path, res);

        // 选 nums[index]
        path.addLast(nums[index]);
        dfs(nums, len, index + 1, path, res);
        // 回溯的位置：状态重置
        path.removeLast();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        List<List<Integer>> res = solution.subsets(nums);
        System.out.println(res);
    }
}
