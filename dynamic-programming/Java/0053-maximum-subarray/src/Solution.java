public class Solution {

    // 定义状态：dp[i]：表示以 nums[i] 结尾的连续子数组的最大和
    // 状态转移方程：dp[i] = max{num[i], dp[i-1] + num[i]}
    // 分类讨论的标准：选或者不选前面的数

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution solution = new Solution();
        int maxSubArray = solution.maxSubArray(nums);
        System.out.println(maxSubArray);
    }
}