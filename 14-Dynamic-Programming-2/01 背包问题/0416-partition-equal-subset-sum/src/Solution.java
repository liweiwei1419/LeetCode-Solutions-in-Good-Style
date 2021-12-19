import java.util.Arrays;

public class Solution {

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = Arrays.stream(nums).sum();
        if ((sum % 2) == 1) {
            return false;
        }

        int target = sum / 2;
        boolean[][] dp = new boolean[len][target + 1];
        // 初始化
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }
        // 递推开始
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][target];
    }
}