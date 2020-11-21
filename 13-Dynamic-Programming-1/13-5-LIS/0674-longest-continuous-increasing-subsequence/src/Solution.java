public class Solution {

    // 最长且「连续」递增的子序列，关键字：连续，其实就是连续子数组的意思
    // 方法一：动态规划

    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        // dp[i]：以 nums[i] 结尾的最长连续递增的子序列的长度
        int[] dp = new int[len];
        // 初始化
        dp[0] = 1;
        // 递推开始
        int res = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] < nums[i]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            // 在遍历的过程中记录最大值
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}