public class Solution {

    public boolean canJump(int[] nums) {
        int len = nums.length;
        int maxReach = 0;
        for (int i = 0; i < len; i++) {
            if (maxReach < i) {
                return false;
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }
}