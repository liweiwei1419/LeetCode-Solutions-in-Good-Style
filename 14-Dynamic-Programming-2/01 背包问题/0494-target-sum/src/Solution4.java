import java.util.Arrays;

public class Solution4 {

    public int findTargetSumWays(int[] nums, int S) {
        int sum = Arrays.stream(nums).sum();
        int target = sum * 2 + 1;
        // 特殊判断：S 大于等于填正号的和，或者小于等于全部填负号的和
        if (S > sum || S < -sum) {
            return 0;
        }

        int len = nums.length;
        // dp[i][j] 表示 [0..i] 区间里选出的数的「和」（减号视为负数）恰好为 j
        // 为了避免出现负数：所有「和」加上偏移量 target
        int[][] dp = new int[len][target];
        // 初始化
        dp[0][nums[0] + sum] = 1;
        // 针对 nums[0] = 0，这里用 +=
        dp[0][-nums[0] + sum] += 1;
        // 递推开始
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < target; j++) {
                // 作为数组下标都不能越界，因此状态转移之前需要做判断
                if (j - nums[i] >= 0) {
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
                if (j + nums[i] < target) {
                    dp[i][j] += dp[i - 1][j + nums[i]];
                }
            }
        }
        return dp[len - 1][S + sum];
    }
}