import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {

    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 实现类有泛型的时候需要加 <>
        res = new ArrayList<>();
        if (candidates == null) {
            return res;
        }
        List<Integer> cur = new ArrayList<>();

        // 先排序，然后再剪枝，可以剪去很多枝叶
        Arrays.sort(candidates);
        dfs(candidates, target, 0, cur);
        return res;
    }

    private void dfs(int[] candidates, int target, int start, List<Integer> cur) {
        // 这部分剪枝放在递归之前
//        if (target < 0) {
//            return;
//        }
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 排序是剪枝的前提
            if (target - candidates[i] < 0) {
                break;
            }
            cur.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, cur);
            cur.remove(cur.size() - 1);
        }
        // 这里不要 return
        // return;
    }
}
