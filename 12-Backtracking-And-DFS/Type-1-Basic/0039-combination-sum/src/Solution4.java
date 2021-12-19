import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution4 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        dfs(candidates, 0, target, list, res);
        return res;
    }

    public void dfs(int[] candidates, int start, int target, List<Integer> list, List<List<Integer>> res) {
        // 如果非要这样写的话，在收集结果之前，需要 list.add(candidates[start]);
        // 在记录结果以后，还需要 list.remove(list.size() - 1);
        // 并且 candidates[start] == target 的语义表示搜索数组 candidates[start..len - 1] 这部分，
        // 只有在 candidates[start] == target 的时候，才记录结果，这不符合题意
        if (candidates[start] == target) {
            list.add(candidates[start]);
            res.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[start] > target) {
                return;
            }
            list.add(candidates[i]);
            dfs(candidates, i, target - candidates[i], list, res);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        // 把 candidates 的 2 改成 1，可以得到结果，这是特殊情况
        int[] candidates = new int[]{1, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = solution4.combinationSum(candidates, target);
        System.out.println(res);
    }
}