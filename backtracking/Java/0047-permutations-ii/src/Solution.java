import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    // 时间复杂度: O(n^n)
    // 空间复杂度: O(n)

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        boolean[] used = new boolean[len];
        Deque<Integer> stack = new ArrayDeque<>();
        backtrack(nums, 0, len, used, stack, res);
        return res;
    }

    /**
     * @param nums
     * @param index
     * @param len
     * @param used
     * @param stack
     * @param res
     */
    private void backtrack(int[] nums, int index, int len, boolean[] used, Deque<Integer> stack, List<List<Integer>> res) {
        if (index == len) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                // 在这里"剪枝"，used[i - 1] 前面加加感叹号剪枝更彻底
                if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                    continue;
                }
                used[i] = true;
                stack.add(nums[i]);
                // 注意：index + 1 不要写成 i + 1
                backtrack(nums, index + 1, len, used, stack, res);
                stack.pop();
                used[i] = false;
            }
        }
    }
}
