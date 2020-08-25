public class Solution2 {

    // 从后向前遍历

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return nums[0];
        }

        // dp[i]：区间 [i, len - 1] 偷取的最大价值
        int[] dp = new int[len];
        dp[len - 1] = nums[len - 1];
        dp[len - 2] = Math.max(nums[len - 1], nums[len - 2]);

        for (int i = len - 3; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[0];
    }
}
