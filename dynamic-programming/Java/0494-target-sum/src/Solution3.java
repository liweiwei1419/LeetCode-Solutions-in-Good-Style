public class Solution3 {

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

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {42, 24, 30, 14, 38, 27, 12, 29, 43, 42, 5, 18, 0, 1, 12, 44, 45, 50, 21, 47};
        int S = 38;
        // 5602
        Solution3 solution3 = new Solution3();
        int res = solution3.findTargetSumWays(nums, S);
        System.out.println(res);
    }
}
