import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class Solution4 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        int len = candidates.length;
        dfs(candidates, target, 0, len, new ArrayDeque<>(), res);
        return res;
    }

    private void dfs(int[] candidates, int residue, int start, int len, Deque<Integer> stack,
                     List<List<Integer>> res) {
        if (residue == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i < len; i++) {
            if (residue - candidates[i] < 0) {
                break;
            }
            // 注意：这里不能写 i > 0
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            stack.push(candidates[i]);
            dfs(candidates, residue - candidates[i], i + 1, len, stack, res);
            stack.pop();
        }
    }
}
