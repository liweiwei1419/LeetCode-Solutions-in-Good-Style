public class Solution3 {

    // 方法一：动态规划（推荐）

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        // dp[i]：表示以 nums[i] 结尾的连续子数组的最大和（这样的定义满足无后效性）
        for (int i = 1; i < len; i++) {
            // 分类讨论的标准：选或者不选前面的连续子数组的和
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        // 遍历 dp 数组，找出最大值，即连续子数组的最大和
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}