public class Solution {

    // 滑动窗口

    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        // 因为题目限制了 k <= len，因此不用做特判
        int windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        int res = windowSum;

        // 边界问题
        for (int i = k; i < len; i++) {
            // 加上一个数再减去一个数
            windowSum = windowSum + nums[i] - nums[i - k];
            res = Math.max(res, windowSum);
        }
        return (double) res / k;
    }
}
