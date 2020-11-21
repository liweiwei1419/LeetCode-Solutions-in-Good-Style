public class Solution3 {

    public int combinationSum4(int[] nums, int target) {
        // 深度优先遍历会超时
        // dp[i]：和为 i 时使用 nums 中的数能组成的组合的总数（就是题目问的）

        // dp[i] = dp[i - nums[0]] + dp[i - nums[1]] + dp[i - nums[2]] + ...
        // 举个例子， nums=[1, 3, 4],target=7;
        // dp[7] = dp[6] + dp[4] + dp[3]
        // 即：7 的组合数可以由三部分组成，1 和 dp[6]，3 和 dp[4]，4 和 dp[3];
        int[] dp = new int[target + 1];

        // 是为了算上自己的情况，比如 dp[1] 可以有 dp[0] + 1 的情况
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}