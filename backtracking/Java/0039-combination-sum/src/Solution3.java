import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution3 {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, path, 0, 0, target);
        return res;
    }

    public void dfs(int[] candidates,
                    Deque<Integer> path,
                    int start,
                    int currentSum,
                    int target) {
        if (currentSum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 从起始位置开始尝试每一个可能的解
        for (int i = start; i < candidates.length; i++) {
            if (currentSum + candidates[i] <= target) {
                path.addLast(candidates[i]);
                currentSum += candidates[i];

                // 因为每一个数字可以重复使用多次，因此下一轮搜索还是从 i 开始
                dfs(candidates, path, i, currentSum, target);
                // 一轮搜索结束以后，状态需要重置，因此数字加上的要减去，列表末尾加上的要移除
                currentSum -= candidates[i];
                path.removeLast();
            }
        }
    }
}
