import java.util.Arrays;

public class Solution2 {

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = Arrays.stream(nums).sum();
        if ((sum % 2) == 1) {
            return false;
        }

        int target = sum / 2;
        boolean[][] dp = new boolean[len][target + 1];
        dp[0][0] = true;
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }

            // 剪枝
            if (dp[i][target]){
                return true;
            }
        }
        return dp[len - 1][target];
    }
}