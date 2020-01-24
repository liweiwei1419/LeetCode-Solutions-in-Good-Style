import java.util.Arrays;

/**
 * 动态规划
 */
public class Solution {

    // 将 dp 数组定义为：以 nums[i] 结尾的最长上升子序列的长度
    // 那么题目要求的，就是这个 dp 数组中的最大者
    // 以数组 [10, 9, 2, 5, 3, 7, 101, 18] 为例：
    // 数组 dp：[1, 1, 1, 2, 2, 3, 4, 4]

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        // 状态的定义是：以 i 结尾的最长上升子序列的长度
        // 状态转移方程：之前比最后那个数字小的最长上升子序列的长度 + 1
        int[] dp = new int[len];
        // 如果只有 1 个元素，那么这个元素自己就构成了最长上升子序列，所以设置为 1 是合理的
        Arrays.fill(dp, 1);
        // 从第 2 个元素开始，逐个写出 dp 数组的元素的值
        for (int i = 1; i < len; i++) {
            // 找出比当前元素小的哪些元素的最小值
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
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
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        Solution solution = new Solution();
        int lengthOfLIS = solution.lengthOfLIS(nums);
        System.out.println(lengthOfLIS);
    }
}
