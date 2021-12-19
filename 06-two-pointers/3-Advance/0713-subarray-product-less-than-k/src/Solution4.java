public class Solution4 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // 特殊用例判断
        if (k <= 1) {
            return 0;
        }
        int len = nums.length;
        int left = 0;
        int right = 0;
        int res = 0;
        int product = 1;
        // 循环不变量：nums[left..right) 里所有元素的乘积严格小于 k
        while (right < len) {
            product *= nums[right];
            right++;
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            res += (right - left);
        }
        return res;
    }
}