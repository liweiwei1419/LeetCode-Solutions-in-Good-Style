import java.util.Arrays;

public class Solution {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        // dp[i]：以 nums[i] 结尾的最长上升子序列的长度
        int[] dp = new int[len];
        // 如果只有 1 个元素，那么这个元素自己就构成了最长上升子序列，所以设置为 1 是合理的
        Arrays.fill(dp, 1);

        // 从第 2 个元素开始，逐个写出 dp 数组的元素的值
        for (int i = 1; i < len; i++) {
            // 找出比当前元素小的哪些元素的最小值
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    // 状态转移方程：之前比最后那个数字小的最长上升子序列的长度 + 1
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // 最后遍历一遍，求最大值
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {11, 12, 13, 14, 15, 16, 1, 2, 3, 4, 1, 5, 6, 7, 1, 8};
        // int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        Solution solution = new Solution();
        int res = solution.lengthOfLIS(nums);
        System.out.println(res);
    }
}
