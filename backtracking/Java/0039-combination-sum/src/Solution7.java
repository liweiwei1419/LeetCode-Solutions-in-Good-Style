import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution7 {

    // 剪枝版本

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        Arrays.sort(candidates);
        dfs(candidates, target, len, 0, new ArrayDeque<>(), res);
        return res;
    }

    private void dfs(int[] candidates, int residue, int len, int start, Deque<Integer> stack, List<List<Integer>> res) {
        if (residue == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i < len; i++) {
            residue -= candidates[i];
            if (residue < 0) {
                break;
            }

            stack.addLast(candidates[i]);
            dfs(candidates, residue, len, i, stack, res);
            stack.removeLast();
            residue += candidates[i];
        }
    }
}
