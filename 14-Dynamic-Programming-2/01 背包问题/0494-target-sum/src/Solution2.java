import java.util.Arrays;

public class Solution2 {

    // 方法二：动态规划（二维状态数组）
    // 动态规划：考虑平移：

    public int findTargetSumWays(int[] nums, int S) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        int sum = Arrays.stream(nums).sum();
        if (S > sum) {
            return 0;
        }

        int target = sum + S;
        if ((target % 2) != 0) {
            return 0;
        }

        target /= 2;
        int[][] dp = new int[len][target + 1];
        dp[0][0] = 1;
        for (int j = 0; j <= target; j++) {
            if (nums[0] == j) {
                dp[0][j] += 1;
            }
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