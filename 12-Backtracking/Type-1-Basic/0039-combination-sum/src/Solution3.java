import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution3 {

    // 方法二：回溯（画成二叉树）

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, target, res, path, 0);
        return res;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> res, Deque<Integer> path, int begin) {
        if (begin == candidates.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        dfs(candidates, target, res, path, begin + 1);
        if (target - candidates[begin] >= 0) {
            path.add(candidates[begin]);
            dfs(candidates, target - candidates[begin], res, path, begin);
            path.remove(path.size() - 1);
        }
    }
}