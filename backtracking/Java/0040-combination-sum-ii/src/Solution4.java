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
        dfs(candidates, target, 0, len, new ArrayDeque<>(len), res);
        return res;
    }

    private void dfs(int[] candidates, int residue, int start, int len, Deque<Integer> path,
                     List<List<Integer>> res) {
        if (residue == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < len; i++) {
            if (residue - candidates[i] < 0) {
                break;
            }

            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);
            dfs(candidates, residue - candidates[i], i + 1, len, path, res);
            path.removeLast();
        }
    }
}
