import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tempAns = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return ans;
        }
        Arrays.sort(candidates);
        dfs(0, 0, candidates, target);
        return ans;
    }

    public void dfs(int cur, int sum, int[] candidates, int target) {
        if (sum == target) {
            ans.add(new ArrayList<>(tempAns));
        }
        for (int i = cur; i < candidates.length; i++) {
            int tempSum = sum + candidates[i];
            if (cur != i && candidates[i - 1] == candidates[i]) {
                continue;
            }
            if (tempSum <= target) {
                tempAns.add(candidates[i]);
                dfs(i + 1, tempSum, candidates, target);
                tempAns.remove(tempAns.size() - 1);
            } else {
                break;
            }
        }
    }
}
