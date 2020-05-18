public class Solution3 {
    /**
     * 贪心算法
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if (len < 1) {
            return false;
        }
        int lastPosition = len - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPosition) {
                lastPosition = i;
            }
        }
        return lastPosition == 0;
    }
}
