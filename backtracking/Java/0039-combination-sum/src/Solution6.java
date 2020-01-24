import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution6 {

    // 剪枝用减法

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
        Arrays.sort(candidates);

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, len, target, 0, path, res);
        return res;
    }

    private void dfs(int[] candidates,
                     int len,
                     int residue,
                     int start,
                     Deque<Integer> path,
                     List<List<Integer>> res) {

        if (residue == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < len; i++) {
            if (residue - candidates[i] < 0) {
                break;
            }

            residue -= candidates[i];
            path.push(candidates[i]);

            dfs(candidates, len, residue, i, path, res);

            residue += candidates[i];
            path.pop();
        }
    }
}
