import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    List<List<Integer>> res = new ArrayList<>();
    int n;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        n = candidates.length;

        List<Integer> cur = new ArrayList<>();
        dfs(cur, target, 0, candidates);
        return res;
    }

    public void dfs(List<Integer> cur, int target, int sum, int[] candidates) {
        if (sum >= target) {
            if (sum == target) {
                System.out.println("排序之前 " + cur);

                // 注意：这句话导致 cur 的结构发生变化，从而在下面的位置 ① 处弹出了错误的数字，但是 sum 却没变，
                // 所以看到了 [2, 2, 3], [2, 5] 这样的输出
                Collections.sort(cur);
                System.out.println("排序之后 " + cur);
                System.out.println("--- 收集结果 => " + cur);
                res.add(new ArrayList<>(cur));
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            cur.add(candidates[i]);
            System.out.println(cur + " " + (sum + candidates[i]));
            dfs(cur, target, sum + candidates[i], candidates);

            // 位置 ①
            cur.remove(cur.size() - 1);
            System.out.println(cur + " " + sum );
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer>> res = solution.combinationSum(candidates, target);
        System.out.println(res);
    }
}
