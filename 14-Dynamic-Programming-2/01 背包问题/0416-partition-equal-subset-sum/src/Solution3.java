import java.util.Arrays;

public class Solution3 {

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = Arrays.stream(nums).sum();
        if ((sum % 2) == 1) {
            return false;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }

        for (int i = 1; i < len; i++) {
            for (int j = target; j >= 0 && nums[i] <= j; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
            if (dp[target]) {
                return true;
            }
        }
        return dp[target];
    }
}