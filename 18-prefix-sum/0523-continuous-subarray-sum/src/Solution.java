public class Solution {

    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        for (int left = 0; left < len - 1; left++) {
            // 大小至少为 2
            for (int right = left + 1; right < len; right++) {
                int sum = 0;
                for (int i = left; i <= right; i++) {
                    sum += nums[i];
                }
                if (sum == k || (k != 0 && sum % k == 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}
