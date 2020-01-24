public class Solution {

    // 参考：力扣第 53 题思路

    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }

        // 状态定义：以索引 i 结尾
        // 思考清楚一种特例： [2, -1 ,3]，前面乘起来是负数的话，倒不如另起炉灶
        int[] maxDp = new int[len];
        int[] minDp = new int[len];

        maxDp[0] = nums[0];
        minDp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            if (nums[i] >= 0) {
                maxDp[i] = Math.max(nums[i], maxDp[i - 1] * nums[i]);
                minDp[i] = Math.min(nums[i], minDp[i - 1] * nums[i]);
            } else {
                maxDp[i] = Math.max(nums[i], minDp[i - 1] * nums[i]);
                minDp[i] = Math.min(nums[i], maxDp[i - 1] * nums[i]);
            }
        }

        int res = maxDp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, maxDp[i]);
        }
        return res;
    }
}
