public class Solution2 {

    // 动态规划：考虑平移：https://leetcode-cn.com/problems/target-sum/solution/java-ji-yi-hua-sou-suo-by-crsm/

    public int findTargetSumWays(int[] nums, int S) {
        int len = nums.length;

        if (len == 0) {
            return 0;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (S > sum) {
            return 0;
        }

        int target = sum + S;
        if ((target & 1) != 0) {
            return 0;
        }

        target >>>= 1;

        int[][] dp = new int[len][target + 1];
        dp[0][0] = 1;
        for (int j = 0; j < target + 1; j++) {
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

    public static void main(String[] args) {
        // int[] nums = {42, 24, 30, 14, 38, 27, 12, 29, 43, 42, 5, 18, 0, 1, 12, 44, 45, 50, 21, 47};
        // int S = 38;
        // 5602

        int[] nums = {1, 2, 7, 9, 981};
        int S = 1000000000;

        Solution2 solution2 = new Solution2();
        int res = solution2.findTargetSumWays(nums, S);
        System.out.println(res);
    }
}
