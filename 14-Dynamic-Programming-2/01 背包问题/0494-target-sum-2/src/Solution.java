public class Solution {

    // 等价问题转换
    // sum(正) - sum(负) = S
    // sum(正) + sum(负) = sum

    // sum(正) = (S + sum) / 2 计数问题，问有多少种方法

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        // 特判 1
        if (S > sum) {
            return 0;
        }

        // 特判 2
        int len = nums.length;
        if ((S + sum) % 2 == 1) {
            return 0;
        }

        int target = (S + sum) / 2;
        int[][] dp = new int[len][target + 1];
        // 状态转移的时候用得上
        dp[0][0] = 1;

        // 初始化
        if (nums[0] <= target) {
            dp[0][nums[0]]+=1;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < target + 1; j++) {
                // 至少是不选这个物品时候的种数
                dp[i][j] += dp[i - 1][j];
                if (j >= nums[i]) {
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[len - 1][target];
    }
}

