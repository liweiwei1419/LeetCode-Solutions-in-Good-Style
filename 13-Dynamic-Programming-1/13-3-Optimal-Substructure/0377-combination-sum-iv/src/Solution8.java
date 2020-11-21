import java.util.Arrays;

public class Solution8 {

    private int[] memo;

    public int combinationSum4(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        dfs(nums, target);

        return memo[target];
    }

    private int dfs(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }

        if (memo[target] != -1) {
            return memo[target];
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                res += dfs(nums, target - nums[i]);
            }
        }
        return memo[target] = res;
    }
}