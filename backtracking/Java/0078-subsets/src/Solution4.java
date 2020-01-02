import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class Solution4 {

    private void backtracking(int[] nums, int len,
                              int maxCount, int begin,
                              Deque<Integer> stack,
                              List<List<Integer>> res) {
        if (maxCount == stack.size()) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = begin; i < len; i++) {
            // 包括当前这个元素
            stack.add(nums[i]);
            backtracking(nums, len, maxCount, i + 1, stack, res);
            // 不包括当前这个元素
            stack.pop();
        }
    }

    // 主函数
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
            backtracking(nums, len, i, 0, new ArrayDeque<>(), res);
        }
        return res;
    }
}
