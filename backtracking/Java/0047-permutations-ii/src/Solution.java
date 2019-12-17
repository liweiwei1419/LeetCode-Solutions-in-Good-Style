import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        boolean[] used = new boolean[len];
        backtrack(nums, 0, len, used, new Stack<Integer>(), res);
        return res;
    }

    /**
     * @param nums
     * @param depth
     * @param len
     * @param used
     * @param path
     * @param res
     */
    private void backtrack(int[] nums, int depth, int len, boolean[] used, Stack<Integer> path, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));

            return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                // 在这里"剪枝"，used[i - 1] 前面加不加感叹号均可
                if (i > 0 && nums[i - 1] == nums[i] && used[i - 1]) {
                    continue;
                }
                used[i] = true;
                path.add(nums[i]);
                // depth + 1 不要写成 i + 1，所以递归函数的语义很重要
                backtrack(nums, depth + 1, len, used, path, res);
                path.pop();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2};
        // [[1, 1, 2], [1, 2, 1], [2, 1, 1]]
        Solution solution = new Solution();
        List<List<Integer>> res = solution.permuteUnique(nums);
        System.out.println(res);
    }
}
