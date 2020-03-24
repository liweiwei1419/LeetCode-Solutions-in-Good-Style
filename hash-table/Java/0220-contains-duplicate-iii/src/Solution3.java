public class Solution3 {

    /**
     * 暴力解法：会超时，不推荐
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        // k 滑动窗口长度
        // t 是半径
        int len = nums.length;
        if (len == 0 || k <= 0 || t < 0) {
            return false;
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j - i <= k && j < len; j++) {
                if (Math.abs((long) nums[j] - (long) nums[i]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }

}
