import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    // 不排序版本

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;
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
        // 剪枝
        if (residue < 0) {
            return;
        }

        if (residue == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < len; i++) {
            // 要说明这里 residue 可以作为参数传入方法，不用显示
            residue -= candidates[i];
            path.addLast(candidates[i]);

            dfs(candidates, len, residue, i, path, res);

            residue += candidates[i];
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        Solution solution = new Solution();
        List<List<Integer>> res = solution.combinationSum(candidates, target);
        System.out.println(res);
    }
}
