public class Solution2 {

    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;

        // preSum[i] 表示：区间 [0..i) 的前缀和
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }

        for (int left = 0; left < len - 1; left++) {
            // 大小至少为 2
            for (int right = left + 1; right < len; right++) {
                int sum = preSum[right + 1] - preSum[left];
                if (sum == k || (k != 0 && sum % k == 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}