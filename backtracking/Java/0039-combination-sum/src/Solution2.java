import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution2 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        backtracking(candidates, target, len, 0, new ArrayDeque<>(), res);
        return res;
    }

    private void backtracking(int[] candidates, int target, int len, int start, Deque<Integer> stack, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i < len; i++) {
            stack.push(candidates[i]);

            // 基本数据类型，不状态重置也可以，因为每一次都是拿新的数
            backtracking(candidates, target - candidates[i], len, i, stack, res);

            stack.pop();
        }
    }
}
