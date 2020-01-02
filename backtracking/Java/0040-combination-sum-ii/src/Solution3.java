import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution3 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        int len = candidates.length;
        dfs(candidates, target, 0, len, new Stack<>(), res);
        return res;
    }

    private void dfs(int[] candidates, int residue, int start, int len, Stack<Integer> stack,
                     List<List<Integer>> res) {
        if (residue == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = start; i < len; i++) {
            if (residue - candidates[i] < 0) {
                break;
            }
            // 注意：这里不能写 i > 0
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // 如果是复制进去的就没有必要回溯
            residue -= candidates[i];
            stack.add(candidates[i]);

            dfs(candidates, residue, i + 1, len, stack, res);

            stack.pop();
            residue += candidates[i];
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        Solution solution = new Solution();
        List<List<Integer>> res = solution.combinationSum2(candidates, target);
        System.out.println(res);
    }
}
