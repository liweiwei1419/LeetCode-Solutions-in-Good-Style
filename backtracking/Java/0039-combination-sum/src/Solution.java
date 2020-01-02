import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    // 不排序版本

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        backtracking(candidates, len, target, 0, new ArrayDeque<>(), res);
        return res;
    }

    private void backtracking(int[] candidates, int len, int residue,
                              int start, Deque<Integer> stack, List<List<Integer>> res) {
        if (residue < 0) {
            return;
        }
        if (residue == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i < len; i++) {
            residue -= candidates[i];
            stack.push(candidates[i]);

            backtracking(candidates, len, residue, i, stack, res);

            residue += candidates[i];
            stack.pop();
        }
    }
}
