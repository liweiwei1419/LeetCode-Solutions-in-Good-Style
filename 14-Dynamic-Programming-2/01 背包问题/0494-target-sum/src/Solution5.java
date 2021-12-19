import java.util.Arrays;

public class Solution5 {

    public int findTargetSumWays(int[] nums, int S) {
        int sum = Arrays.stream(nums).sum();
        int target = sum * 2 + 1;
        if (S > sum || S < -sum) {
            return 0;
        }

        int len = nums.length;
        int[][] dp = new int[2][target];
        dp[0][nums[0] + sum] = 1;
        dp[0][-nums[0] + sum] += 1;
        for (int i = 1; i < len; i++) {
            // 注意：这里如果不把当前行全部赋值为 0，答案会变多
            Arrays.fill(dp[i % 2], 0);
            for (int j = 0; j < target; j++) {
                // 作为数组下标都不能越界，因此状态转移之前需要做判断
                if (j - nums[i] >= 0) {
                    dp[i % 2][j] += dp[(i - 1) % 2][j - nums[i]];
                }
                if (j + nums[i] < target) {
                    dp[i % 2][j] += dp[(i - 1) % 2][j + nums[i]];
                }
            }

        }
        return dp[(len - 1) % 2][S + sum];
    }
}