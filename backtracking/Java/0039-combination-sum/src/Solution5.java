import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution5 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        if (len == 0) {
            return res;
        }

        Arrays.sort(candidates);
        this.len = len;
        this.candidates = candidates;

        Deque<Integer> path = new ArrayDeque<>();
        dfs(target, 0, path);
        return res;
    }

    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;
    private int len;

    private void dfs(int residue, int start, Deque<Integer> stack) {
        if (residue == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i < len && residue - candidates[i] >= 0; i++) {
            stack.addLast(candidates[i]);
            dfs(residue - candidates[i], i, stack);
            stack.removeLast();
        }
    }
}
