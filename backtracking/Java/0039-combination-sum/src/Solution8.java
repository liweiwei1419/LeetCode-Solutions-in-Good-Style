import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution8 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);

        // 您这里多传了一个参数，可能是笔误
        dfs(candidates, len, path, target, res, 0);
        return res;
    }

    // 方法名为 Depth First Search，所以应该命名为 dfs ，这里应该也是笔误

    public void dfs(int[] candidates, int len, List<Integer> path,
                    int target, List<List<Integer>> res, int start) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < len; i++) {
            if (candidates[i] > target) {
                return;
            } else {
                path.add(candidates[i]);
                target = target - candidates[i];

                dfs(candidates, len, path, target, res, i);

                // 特别注意 dfs 之前做了什么操作，在 dfs 之后就要做相应的操作抵消它，
                // 这一步操作叫做状态重置
                // 所以，您漏掉的就是这行代码
                target = target + candidates[i];
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        Solution8 solution8 = new Solution8();
        List<List<Integer>> res = solution8.combinationSum(candidates, target);
        System.out.println(res);
    }
}
