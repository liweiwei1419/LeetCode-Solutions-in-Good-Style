import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution2 {

    private void dfs(int[] nums, int begin, int len, Stack<Integer> stack, List<List<Integer>> res) {
        // 关键 3：记录每个结点的路径
        res.add(new ArrayList<>(stack));
        for (int i = begin; i < len; i++) {
            // 关键 2：剪枝的常见操作
            if (i > begin && nums[i] == nums[i - 1]) {
                continue;
            }
            stack.push(nums[i]);
            dfs(nums, i + 1, len, stack, res);
            stack.pop();
        }
    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        // 关键 1：排序是为了后面剪枝去重
        Arrays.sort(nums);
        dfs(nums, 0, len, new Stack<>(), res);
        return res;
    }
}
