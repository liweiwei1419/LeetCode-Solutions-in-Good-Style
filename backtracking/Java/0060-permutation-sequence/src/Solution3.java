import java.util.ArrayList;
import java.util.List;

// 既然没有回溯，就不用 used 数组

public class Solution3 {

    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
            used[i] = false;
        }
        int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
        List<String> pre = new ArrayList<>();
        return dfs(nums, used, n, k, 0, pre, factorial);
    }

    private String dfs(int[] nums, boolean[] used, int n, int k, int depth, List<String> pre, int[] factorial) {
        if (depth == n) {
            StringBuilder sb = new StringBuilder();
            for (String c : pre) {
                sb.append(c);
            }
            return sb.toString();
        }
        int ps = factorial[n - 1 - depth];
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            if (ps < k) {
                k -= ps;
                continue;
            }
            pre.add(nums[i] + "");
            used[i] = true;
            return dfs(nums, used, n, k, depth + 1, pre, factorial);
        }
        // 如果参数正确的话，代码不会走到这里
        throw new RuntimeException("参数错误");
    }
}
