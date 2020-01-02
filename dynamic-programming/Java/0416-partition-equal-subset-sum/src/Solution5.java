public class Solution5 {

    public boolean canPartition(int[] nums) {
        int size = nums.length;
        if (size == 0) {
            return false;
        }
        int s = 0;
        for (int num : nums) {
            s += num;
        }
        if ((s & 1) == 1) {
            return false;
        }

        int target = s / 2;

        boolean[] dp = new boolean[target + 1];

        // 状态转移方程：dp[i - 1][j] = dp[i - 1][j] or dp[i - 1][j - nums[i]]
        // 单独 1 个数可以构成子集，根据状态转移方程，当 j == nums[i] 成立的时候，会来看 dp[i - 1][0] 的值
        // 因此根据语义，dp[0] 应该设置为 True
        dp[0] = true;

        for (int j = 1; j < target + 1; j++) {
            if (nums[0] == j) {
                dp[j] = true;
                break;
            }
        }
        for (int i = 1; i < size; i++) {
            // 先看最后一个数是不是返回 True，如果是，后面就没有必要计算了，方法可以直接返回 True
            if(target >= nums[i]){
                dp[target] = dp[target] || dp[target - nums[i]];
            }
            if (dp[target]) {
                return true;
            }

            // 然后再写倒数第 2 个数，倒数第 3 个数
            for (int j = target - 1; j >= 0 && j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
