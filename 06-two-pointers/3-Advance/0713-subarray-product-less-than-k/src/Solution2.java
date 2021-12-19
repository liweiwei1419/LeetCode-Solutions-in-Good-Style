public class Solution2 {

    // 滑动窗口

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int len = nums.length;
        int left = 0;
        int count = 0;
        int product = 1;
        for (int right = 0; right < len; right++) {
            product *= nums[right];
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }
}