import java.util.Arrays;

public class Solution2 {

    public int lengthOfLIS(int[] nums) {
        // 特判
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        // dp[i]：以 nums[i] 结尾的最长上升子序列的长度
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
