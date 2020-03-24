public class Solution6 {

    // 超时

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int len = nums.length;
        long a;
        long b;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                a = nums[i];
                b = nums[j];
                if (Math.abs(a - b) <= t & Math.abs(i - j) <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}
