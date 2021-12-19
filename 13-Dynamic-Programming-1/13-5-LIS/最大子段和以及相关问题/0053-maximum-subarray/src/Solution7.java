public class Solution7 {

    public int maxSubArray(int[] nums) {
        // dp[i] 表示：以 nums[i] 开头的连续子序列的最大和
        int len = nums.length;
        int[] dp = new int[len];
        dp[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            if (dp[i + 1] <= 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i + 1] + nums[i];
            }
        }

        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
