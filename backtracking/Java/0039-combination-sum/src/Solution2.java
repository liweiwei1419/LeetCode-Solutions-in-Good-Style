import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution2 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, target, len, 0, path, res);
        return res;
    }

    private void dfs(int[] candidates,
                     int target,
                     int len,
                     int start,
                     Deque<Integer> path,
                     List<List<Integer>> res) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < len; i++) {
            path.addLast(candidates[i]);

            dfs(candidates, target - candidates[i], len, i, path, res);

            path.removeLast();
        }
    }
}
