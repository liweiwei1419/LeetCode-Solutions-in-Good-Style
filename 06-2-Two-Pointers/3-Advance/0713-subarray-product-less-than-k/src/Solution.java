public class Solution {

    // 暴力解法：超时
    
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int len = nums.length;
        int count = 0;
        for (int left = 0; left < len; left++) {
            for (int right = left; right < len; right++) {
                int product = 1;
                for (int i = left; i <= right; i++) {
                    product *= nums[i];
                }
                // 注意：乘积可能越界
                if (product > 0 && product < k) {
                    count++;
                }
            }
        }
        return count;
    }
}