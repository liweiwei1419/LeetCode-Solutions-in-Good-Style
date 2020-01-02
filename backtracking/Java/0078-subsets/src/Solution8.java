import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class Solution8 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        backtracking(nums, 0, len, stack, res);
        return res;
    }

    private void backtracking(int[] nums, int index, int len,
                              Deque<Integer> stack,
                              List<List<Integer>> res) {
        if (index == len) {
            res.add(new ArrayList<>(stack));
            return;
        }
        // 当前数可选，也可以不选

        // 不选，直接进入下一层
        backtracking(nums, index + 1, len, stack, res);

        // 选了有，进入下一层
        stack.push(nums[index]);
        backtracking(nums, index + 1, len, stack, res);
        stack.pop();
    }
}
