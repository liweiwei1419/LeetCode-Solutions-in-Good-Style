public class Solution {

    // 方法一：暴力解法（可以不看）
    // 时间复杂度：O(N^3)
    // 空间复杂度：O(1)

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                int sum = sumOfSubArray(nums, j, i);
                res = Math.max(res, sum);
            }
        }
        return res;
    }

    private int sumOfSubArray(int[] nums, int left, int right) {
        // 子区间的和
        int res = 0;
        for (int i = left; i <= right; i++) {
            res += nums[i];
        }
        return res;
    }
}