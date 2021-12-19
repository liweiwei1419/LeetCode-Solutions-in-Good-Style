import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution5 {

    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 排序是剪枝的前提
        Arrays.sort(candidates);
        result = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        findCombination(0,candidates, target, path);
        return result;
    }

    // 需要设置 begin 变量
    private void findCombination(int begin,int[] candidates, int target, LinkedList<Integer> path) {
        if (target == 0) {
            result.add(new LinkedList<>(path));
            return;
        }

        // 从 begin 开始搜索
        for (int i = begin; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            target -= candidates[i];
            // System.out.println(target);
            // 从 i 开始搜索
            findCombination(i,candidates, target, path);

            // path 和 target 的操作在递归方法 findCombination 前后是对称的
            target += candidates[i];
            path.removeLast();
        }
    }
}
