import java.util.Arrays;

public class Solution3 {

    // 方法二：动态规划（一维状态数组）

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
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[target];
    }
}