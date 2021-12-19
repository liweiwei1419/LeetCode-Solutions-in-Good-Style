public class Solution2 {

    // 暴力解法（超时）

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        if (len == 0 || k <= 0 || t < 0) {
            return false;
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                // 注意：nums[j] - nums[i] 的结果可能会整型溢出，因此运算之前需要转换成 long 类型
                if (Math.abs(j - i) <= k && Math.abs((long) nums[j] - (long) nums[i]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }
}