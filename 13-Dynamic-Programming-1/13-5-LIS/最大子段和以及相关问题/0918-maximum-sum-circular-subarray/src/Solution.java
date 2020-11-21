public class Solution {

    public int maxSubarraySumCircular(int[] A) {
        int len = A.length;
        // 特例判断
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return A[0];
        }

        int maxSubArray = maxSubArray(A);
        int minSubArrayExcludeHeadAndTail = minSubArray(A);

        int sum = 0;
        for (int value : A) {
            sum += value;
        }
        return Math.max(maxSubArray, sum - minSubArrayExcludeHeadAndTail);
    }

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        // dp[i]：以 nums[i] 结尾的「连续」子区间的最大和
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            if (dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                // dp[i - 1] < 0 的时候，前面的部分丢弃
                dp[i] = nums[i];
            }
        }

        // 全局扫一遍，找到最大值
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int minSubArray(int[] nums) {
        // 思路和 maxSubArray 完全一致，求最大的地方改成最小
        // 但这里求的区间和不包括头和尾
        int len = nums.length;

        // dp[i]：以 nums[i] 结尾的「连续」子区间的最小和
        int[] dp = new int[len];
        dp[0] = nums[0];

        // 注意 i 的下标
        for (int i = 1; i < len - 1; i++) {
            if (dp[i - 1] >= 0) {
                // 加上前面的数，会使得结果更大，因此前面的部分丢弃
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i - 1] + nums[i];
            }
        }

        // 全局扫一遍，找到最小值
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.min(res, dp[i]);
        }
        return res;
    }
}