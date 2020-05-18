public class Solution8 {

    // 从前向后

    public boolean canJump(int[] nums) {
        int len = nums.length;
        int end = 0;
        for (int i = 0; i < len; i++) {
            if (i > end) {
                return false;
            }
            end = Math.max(end, i + nums[i]);
        }
        return true;
    }
}
